package linkedlist;

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;
            current = current.next;
            if (p!=null) p = p.next;
            if (q!=null) q = q.next;
        }
        if (carry > 0) {
            ListNode carryNode = new ListNode(carry);
            current.next = carryNode;
        }
        return head.next;
    }
}
