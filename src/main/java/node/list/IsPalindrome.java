package node.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenWenWen 2021/7/13 下午11:04
 */
public class IsPalindrome {
    public class ListNode {
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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        ListNode next = head;
        while (next != null) {
            list.add(next.val);
            next = next.next;
        }
        //双指针
        int front = 0, back = list.size() - 1;
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
