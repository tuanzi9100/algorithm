package node;

/** 2021040114
 * 删除链表的倒数第 N 个结点
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 输入：head = [1], n = 1
 * 输出：[]
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * @author shenWenWen 2021/4/11 下午11:09
 */
public class RemoveNthFromEnd {
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

    /**
     * 提示：
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     * @param head
     * @param n
     * @return 标签：链表
     * 整体思路是让前面的指针先移动n步，之后前后指针共同移动直到前面的指针到尾部为止
     * 首先设立预先指针 pre，预先指针是一个小技巧，在第2题中进行了讲解
     * 设预先指针 pre 的下一个节点指向 head，设前指针为 start，后指针为 end，二者都等于 pre
     * start 先向前移动n步
     * 之后 start 和 end 共同向前移动，此时二者的距离为 n，当 start 到尾部时，end 的位置恰好为倒数第 n 个节点
     * 因为要删除该节点，所以要移动到该节点的前一个才能删除，所以循环结束条件为 start.next != null
     * 删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
     * 时间复杂度：O(n)O(n)
     * <p>
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/hua-jie-suan-fa-19-shan-chu-lian-biao-de-dao-shu-d/
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode();
        node5.val = 5;
        ListNode node4 = new ListNode();
        node4.val = 4;
        node4.next = node5;
        ListNode node3 = new ListNode();
        node3.val = 3;
        node3.next = node4;
        ListNode node2 = new ListNode();
        node2.val = 2;
        node2.next = node3;
        ListNode node1 = new ListNode();
        node1.val = 1;
        node1.next = node2;
        removeNthFromEnd(node1,2);
    }
}
