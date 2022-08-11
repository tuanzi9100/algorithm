/**
 * @author shenWenWen 2022/6/13 下午3:48
 */
public class NodeTest {
    public static class ListNode{
        int var;
        ListNode next;
        ListNode (int x){
            var = x;
        }
    }
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node4.next = node3;
        node2.next = node4;


        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node6.next = node7;
        node5.next = node6;

        ListNode res =addTwoNode(node2,node5);
        while(res != null){
            System.out.println(res.var);
            res = res.next;
        }
    }
    public static ListNode addTwoNode(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null ?0:l1.var;
            int y = l2 ==null ? 0 :l2.var;
            int sum = x+y+carry;

            carry = sum/10;
            sum = sum%10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
