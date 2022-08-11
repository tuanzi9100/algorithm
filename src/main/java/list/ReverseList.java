package list;

/**
 * @author shenWenWen 2022/4/17 上午9:24
 */
public class ReverseList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
      return pre;
    }
}
