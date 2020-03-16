package linkedlist;

public class SinglyLinkedList {
    private Node head = new Node(9999,null);//初始化dummy node。
    private Node tail = head;                          //初始状态 head与tail均指向dummy节点。
    public class Node {
        private int data;
        private Node next;
        public Node(int data , Node next) {
            this.data = data;
            this.next = next;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    /*使用尾插法生成链表*/
    private void insertToTail(int data) {
        // 生成新node
        Node node = new Node(data, null);
        // 从尾部插入Node  当tail不在尾部时，fetch到尾部！ (这种情况会存在吗？)
        /*while (tail.next != null) {
            tail = tail.next;
        }*/
        tail.next = node;/*插入节点*/
        tail = tail.next;
    }

    private void printAllNode() {
        if (head.next == null) return;
        Node cur = head.next;
        do {
            System.out.print(cur.data + "---");
            cur = cur.next;
        } while (cur != null);
        System.out.println("\n打印完毕！");
    }
    private void reverseLinkedList() {
        if(head.next == null || head.next == tail) return;//若无节点或只有一个节点，则无需反转！
        Node firstNode = head.next;
        Node currentNode = firstNode.next;//（不包含dummy节点）从第二个节点开始使用头插法！
        Node next = null;
        firstNode.next = null;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = head.next;//头插法
            head.next = currentNode;
            currentNode = next;
        }
        System.out.println("反转带头(dummy)节点单链表完毕！");
    }

    private boolean isCycleLinkedList() {
        if (head.next == null) {
            return false;
        }
        Node fast = head.next;
        Node slow = head.next;
        do {
            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                return false;
            }

            if (slow.next != null) {
                slow = slow.next;
            }
        } while ( fast != slow );
        if (fast.next == null) {
            return false;//无环
        }
        return true;//有环
    }
    /*构造有环链表*/
    private void setCycleLinkedList(int index) {
        Node p = head.next;
        int i = 0;
        while (i < index) {
            p = p.next;
            i++;
        }
        tail.next = p;//把尾节点指针指向第index个节点
    }




    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 4, 5, 6, 7};
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int i = 0; i <datas.length ; i++) {
            singlyLinkedList.insertToTail(datas[i]);
        }
        singlyLinkedList.printAllNode();
//        singlyLinkedList.reverseLinkedList();
//        singlyLinkedList.setCycleLinkedList(2);
        System.out.println(singlyLinkedList.isCycleLinkedList());
//        singlyLinkedList.printAllNode();
    }
}
