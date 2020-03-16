package linkedlist;

public class IsPalindrome {
    public Boolean isPalindrome(LinkedNode linkedNode) {
        LinkedNode h = linkedNode;
        LinkedNode q = linkedNode;
        LinkedNode p = linkedNode;
        while (q!=null) {
            //快指针q步长为2,慢指针p步长为1。当循环结束时，慢指针直到链表中点(奇数个节点)，或第n/2 + 1个节点(偶数个节点)。
            if (q.getNext()!=null)
                q = q.getNext().getNext();
            else
                q = q.getNext();
            p = p.getNext();
        }
        //将p开始到链表末尾的节点转置。
        //c表时当前节点、l表示前一节点
        LinkedNode l = null;
        LinkedNode c = null;
        while (p!=null) {
            c = p;
            p = p.getNext();
            c.setNext(l);
            l = c;
        }//循环结束时，c和l都指向原链表末尾节点。
        while (c != null) {
            //如果查到不相等的值则返回false
            if (!c.getValue().equals(h.getValue())) {
                return false;
            }
            c = c.getNext();
            h = h.getNext();
        }
        return true;
    }


    public static void main(String[] args) {

        LinkedNode f = new LinkedNode("1",null);
        LinkedNode e = new LinkedNode("2",f);
//        LinkedNode d = new LinkedNode("c",e);
        LinkedNode c = new LinkedNode("3",e);
        LinkedNode b = new LinkedNode("2",c);
        LinkedNode a = new LinkedNode("1",b);
        IsPalindrome isPalindrome = new IsPalindrome();
//        isPalindrome.setLinkedList(linkedList);
        System.out.println(isPalindrome.isPalindrome(a));
    }
}
