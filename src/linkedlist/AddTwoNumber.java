package linkedlist;

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int tens = 0;
        ListNode head = new ListNode();
        ListNode tail = head;
        ListNode node;
        int ds = 0;
        while (p != null || q != null) {
            if (p == null) {
                ds = q.val + tens;
            } else if (q == null) {
                ds = p.val + tens;
            } else {
                ds = p.val + q.val + tens;
            }
            if (ds >= 10) {
                int unit = ds - 10;
                node = new ListNode(unit);
                tens = 1;
            } else {
                node = new ListNode(ds);
                tens = 0;
            }
            //使用尾插法创建单链表
            tail.next = node;
            tail = tail.next;
            if (p!=null) {
                p = p.next;
            }
            if (q!=null) {
                q = q.next;
            }
        }
        if (tens == 1) {//边界情况：l1、l2节点个数相同且相加大于10需进位
            node = new ListNode(1);
            tail.next = node;
            tail = tail.next;
        }
        head = head.next;
        return head;
    }
}
