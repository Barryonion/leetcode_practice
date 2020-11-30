package linkedlist;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode arg = null;
        for (int i = 0; i < lists.length; i++) {
            arg = mergeTwoLists(arg, lists[i]);
        }
        return arg;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode aPtr = a;
        ListNode bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = aPtr != null ? aPtr : bPtr;
        return head.next;
    }
}
