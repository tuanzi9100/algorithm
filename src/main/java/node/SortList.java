package node;

/**
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * @author shenWenWen 2021/6/24 下午2:53
 */
public class SortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        return new ListNode();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 4;

        ListNode l2 = new ListNode();
        l2.val = 2;
        l2.next = l1;

        ListNode l3 = new ListNode();
        l3.val = 1;
        l3.next = l2;

        ListNode l4 = new ListNode();
        l4.val = 4;

        ListNode l5 = new ListNode();
        l5.val = 3;
        l5.next = l4;

        ListNode l6 = new ListNode();
        l6.val = 1;
        l6.next = l5;

        ListNode listNode = mergeTwoLists(l3, l6);
        System.out.println(listNode);
    }
}
