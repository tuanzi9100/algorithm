package node.list;

/**
 * @author shenWenWen 2021/7/19 下午4:13
 */
public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;
        }
    }
        /**
         * 6,2,1,3,4
         * 1,2,3,4
         * @param head
         * @return
         */
        public static ListNode sortList(ListNode head) {
            if(head==null || head.next==null) {
                return head;
            }
            ListNode slow = head; //慢指针
            ListNode fast = head.next; //快指针

            while(fast!=null && fast.next!=null){ //快慢指针找到链表中点
                slow = slow.next; //慢指针走一步
                fast = fast.next.next; //快指针走两步
            }
            ListNode rightHead = slow.next; //链表第二部分的头节点
            slow.next = null; //cut 链表

            ListNode left = sortList(head); //递归排序前一段链表
            ListNode right = sortList(rightHead); //递归排序后一段链表
            return merge(left,right);
        }
        public static ListNode merge(ListNode h1, ListNode h2){ //合并两个有序链表
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            while(h1!=null && h2!=null){
                if(h1.val < h2.val){
                    p.next = h1;
                    h1 = h1.next;
                }else{
                    p.next = h2;
                    h2 = h2.next;
                }
                p = p.next;
            }
            if(h1!=null) {
                p.next = h1;
            } else if(h2!=null) {
                p.next = h2;
            }
            return dummy.next;
        }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = sortList(l1);
        ListNode pre = listNode;
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }
}
