package tree;

public class BinarySearchTree {
    private Node tree;

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public BinarySearchTree(Node root) {
        this.tree = root;
    }

    private Node find(int data) {
        return null;
    }

    private void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (p.data > data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }

    }

    private void delete(int data) {
        if (tree == null) {
            return;
        }
        Node p = tree;
        Node pParent = null;
        while (p != null && p.data != data) {
            if (p.data > data) {
                pParent = p;
                p = p.left;
            } else {
                pParent = p;
                p = p.right;
            }
        }
        if (p == null){ return;}
        if (p.left != null && p.right != null) {//待删除节点左右子树不空
            Node minP = p.right;                //右子树最小节点
            Node minPParent = p;                //最小节点父节点
            while (minP.left != null) {
                minPParent = minP;
                minP = minP.left;
            }
            p.data = minP.data;//替换待删除节点，将问题转化为删除minP节点
            p = minP;
            pParent = minPParent;
        }
        /*待删除节点是叶子节点或只有一个孩子节点*/
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pParent == null) {//删除的是根节点
            tree = child;
        } else if (pParent.left == p) {
            pParent.left = child;
        } else {
            pParent.right = child;
        }
    }

    private Node findMin() {
        return null;
    }

    private Node findMax() {
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);

    }
}
