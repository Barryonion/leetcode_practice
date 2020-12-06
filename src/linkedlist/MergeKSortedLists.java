package linkedlist;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {//method1 : for loop using lists.length's merge operations
        ListNode arg = null;
        for (int i = 0; i < lists.length; i++) {
            arg = mergeTwoLists(arg, lists[i]);
        }
        return arg;
    }
    public ListNode merge(ListNode[] lists, int l, int r){//method2: division using log(lists.length) merge operations
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
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

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(3);
        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(4);
        ListNode[] list = new ListNode[3];
        list[0] = head1;
        list[1] = head2;
        list[2] = head3;
        ListNode merge = mergeKSortedLists.merge(list, 0, 2);
        System.out.println(merge);
    }
}
