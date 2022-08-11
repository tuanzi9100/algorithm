package node.list;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 5，1，2，3，4
 * 4，5，1，2，3
 * 输出：[4,5,1,2,3]
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 2，0，1
 * 1，2，0
 * 0，1，2
 * 2，0，1
 * 输出：[2,0,1]
 *
 * @author shenWenWen 2021/7/19 下午5:35
 */
public class RotateRight {
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

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        // 边界条件
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 对长度取余
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 让 fast 先向后走 k 步;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 此时 slow 和 fast 之间的距离是 k； fast 指向第 k+1 节点；
        // 当 fast.next 为空时，fast 指向链表最后一个节点，slow 指向倒数 k+1 个节点
        // 快慢指针同时向前移动，直到快指针指向的节点的
        // 下一个节点为null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 快指针此时在链表末尾
        // 然后其指向的节点的后继指针指向头节点
        // 这时链表首尾相连成环
        fast.next = head;
        // 新的头节点是慢指针所指节点的下一个节点
        head = slow.next;
        // 慢指针所指节点的的后继指针指向null
        // 断开环
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = rotateRight2(l1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
