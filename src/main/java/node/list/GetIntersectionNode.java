package node.list;

/**
 * @author shenWenWen 2022/4/22 下午4:44
 */
public class GetIntersectionNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode intersectionNode = getIntersectionNode(node,node2);
        System.out.println(intersectionNode);
    }
}
