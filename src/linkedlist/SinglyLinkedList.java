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
        System.out.println("\n打印完毕！\n\n");
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

    /*两个有序的链表合并*/
    private SinglyLinkedList mergeTwoSortedLinkeList(SinglyLinkedList linkedList1, SinglyLinkedList linkedList2) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        /*边界条件判断：判断入参的链表情况，是否有仅存在头节点的情况*/
        if (linkedList1.head == linkedList1.tail || linkedList2.head == linkedList2.tail) {
            System.out.println("待合并的链表中，存在空链表，请传入正确的有序链表！");
            return singlyLinkedList;
        }
        /*初始化时，l1,l2分别指向各自链表的第一个元素。*/
        Node l1 = linkedList1.head.next;
        Node l2 = linkedList2.head.next;
        while (l1 != null && l2 != null) {
            /*两个链表均有序递增*/
            if (l1.data < linkedList1.tail.data && l2.data < linkedList2.tail.data) {
                if (l1.data <= l2.data) {               /*对于l1、l2都指向最后一个节点时进行如下判断：1.讲当前tail节点与l1、l2进行比较，以确定是递增有序、还是递减有序来决定先合并哪个节点*/
                    singlyLinkedList.tail.next = l1;
                    l1 = l1.next;
                } else {
                    singlyLinkedList.tail.next = l2;
                    l2 = l2.next;
                }
                singlyLinkedList.tail = singlyLinkedList.tail.next;
            }else if (l1.data > linkedList1.tail.data && l2.data > linkedList2.tail.data) {//此条件有问题吗？
                /*两个链表均有序递减*/     //此if条件有问题，因为最终l1、l2会指向尾节点，出现相等的情况，此时判断条件为flase，会执行else语句进入无限循环
                if (l1.data >= l2.data) {
                    singlyLinkedList.tail.next = l1;
                    l1 = l1.next;
                } else {
                    singlyLinkedList.tail.next = l2;
                    l2 = l2.next;
                }
                singlyLinkedList.tail = singlyLinkedList.tail.next;
            } else {
                if (singlyLinkedList.tail.data > l1.data && singlyLinkedList.tail.data > l2.data) {//递减有序
                    if (l1.data >= l2.data) {
                        singlyLinkedList.tail.next = l1;
                        l1 = l1.next;
                    } else {
                        singlyLinkedList.tail.next = l2;
                        l2 = l2.next;
                    }
                    singlyLinkedList.tail = singlyLinkedList.tail.next;
                } else {//递增有序
                    if (l1.data <= l2.data) {
                        singlyLinkedList.tail.next = l1;
                        l1 = l1.next;
                    } else {
                        singlyLinkedList.tail.next = l2;
                        l2 = l2.next;
                    }
                    singlyLinkedList.tail = singlyLinkedList.tail.next;
                }
            }
        }
        if (l1 == null) {
            singlyLinkedList.tail.next = l2;
            singlyLinkedList.tail = linkedList2.tail;//更新尾节点
        }
        if (l2 == null) {
            singlyLinkedList.tail.next = l1;
            singlyLinkedList.tail = linkedList1.tail;
        }
        return singlyLinkedList;
    }

    /*删除倒数第n个节点*/
    private void deleteNthNodeFromEnd(int n) {
        /*首先判断输入的n是否有效*/
        int count = 1;
        Node fast = head.next;
        while (fast != null && count < n) {
            fast = fast.next;
            count++;
        }
        if (fast == null) {
            System.out.println("输入的n值大于链表长度");
            return;
        }
        if (count > n) {
            System.out.println("请输入正整数！");
            return;
        }
        /*拉开快慢指针间隔*/
        Node slow = head.next;
        Node pre = null;
        while (fast.next != null) {//当fast指向最后一个节点时退出循环
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {//当倒数第n（n为链表长度）个节点要被删除时
            head.next = head.next.next;
        } else {
            pre.next = pre.next.next;
        }
        return;
    }

    /*求链表的中间节点*/
    private Node[] findMiddleNode() {
        Node[] nodes = new Node[2];
        if (head == tail) {
            System.out.println("此链表为空！");
            return null;
        }
        if (head.next == tail) {
            System.out.println("此链表仅有一个节点！");
            nodes[0] = tail;
            return nodes;
        }
        Node slow = head.next;
        Node fast = slow;
        while (fast.next != tail && fast.next != null) {//当链表为奇数时，一旦fast指向尾节点，则结束while循环，此时slow正好指向中间节点
            slow = slow.next;                           //当链表为偶数时，一旦fast指向倒数第二个节点，则结束while循环，此时slow正好指向中间节点
            fast = fast.next.next;                      //注意为偶数时有两个中间节点
        }
        /*链表长度为奇数或者偶数的判断*/
        if (fast.next == null) {//奇数
            nodes[0] = slow;
            return nodes;
        }
        nodes[0] = slow;
        nodes[1] = slow.next;
        return nodes;
    }


    public static void main(String[] args) {
        int[] datas1 = {9,7,5,3,1};
        int[] datas2 = {8,6,4,2,0};
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        for (int i = 0; i <datas1.length ; i++) {
            singlyLinkedList1.insertToTail(datas1[i]);
        }
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        for (int i = 0; i <datas2.length ; i++) {
            singlyLinkedList2.insertToTail(datas2[i]);
        }
        System.out.println("链表操作前：");
        singlyLinkedList1.printAllNode();
//        singlyLinkedList2.printAllNode();
        System.out.println("链表操作后：");
        singlyLinkedList1.deleteNthNodeFromEnd(0);
//        singlyLinkedList2.deleteNthNodeFromEnd(6);
        singlyLinkedList1.printAllNode();
//        singlyLinkedList2.printAllNode();
//        SinglyLinkedList mergedLinkeList = singlyLinkedList1.mergeTwoSortedLinkeList(singlyLinkedList1, singlyLinkedList2);
//        mergedLinkeList.printAllNode();
//        singlyLinkedList.reverseLinkedList();
//        singlyLinkedList.setCycleLinkedList(2);
//        System.out.println(singlyLinkedList.isCycleLinkedList());
//        singlyLinkedList.printAllNode();
//        Node[] middleNodes = singlyLinkedList1.findMiddleNode();
//        System.out.println("链表的中间节点为：" + middleNodes[0].data+ "和" + middleNodes[1].data);




    }
}
