import java.util.*;

public class AVLRangeQueryExercise {
    static class Node {
        int key, height;
        Node left, right;
        Node(int k) { key = k; height = 1; }

        int balance() {
            int lh = (left == null ? 0 : left.height);
            int rh = (right == null ? 0 : right.height);
            return lh - rh;
        }
        void update() {
            int lh = (left == null ? 0 : left.height);
            int rh = (right == null ? 0 : right.height);
            height = Math.max(lh, rh) + 1;
        }
    }

    private Node root;

    public void insert(int x) { root = insert(root, x); }

    public List<Integer> rangeQuery(int min, int max) {
        List<Integer> res = new ArrayList<>();
        rangeQuery(root, min, max, res);
        return res;
    }

    public void printInOrder() { printInOrder(root); System.out.println(); }

    private Node insert(Node n, int x) {
        if (n == null) return new Node(x);
        if (x < n.key) n.left = insert(n.left, x);
        else if (x > n.key) n.right = insert(n.right, x);
        else return n;
        n.update();
        int bf = n.balance();
        if (bf > 1 && x < n.left.key) return rotateRight(n);
        if (bf < -1 && x > n.right.key) return rotateLeft(n);
        if (bf > 1 && x > n.left.key) { n.left = rotateLeft(n.left); return rotateRight(n); }
        if (bf < -1 && x < n.right.key) { n.right = rotateRight(n.right); return rotateLeft(n); }
        return n;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = (x == null ? null : x.right);
        x.right = y; y.left = t2;
        y.update(); x.update();
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = (y == null ? null : y.left);
        y.left = x; x.right = t2;
        x.update(); y.update();
        return y;
    }

    private void rangeQuery(Node n, int min, int max, List<Integer> out) {
        if (n == null) return;
        if (min < n.key) rangeQuery(n.left, min, max, out);
        if (min <= n.key && n.key <= max) out.add(n.key);
        if (n.key < max) rangeQuery(n.right, min, max, out);
    }

    private void printInOrder(Node n) {
        if (n == null) return;
        printInOrder(n.left);
        System.out.print(n.key + " ");
        printInOrder(n.right);
    }

    public static void main(String[] args) {
        AVLRangeQueryExercise t = new AVLRangeQueryExercise();
        int[] a = {30,20,40,10,25,35,50,5,22,37,60,27,33,45,55};
        for (int v : a) t.insert(v);

        System.out.print("In-order: ");
        t.printInOrder();

        int[][] qs = {{1,15},{21,27},{26,45},{33,60},{41,100}};
        for (int[] q : qs) {
            System.out.println("range ["+q[0]+", "+q[1]+"] -> " + t.rangeQuery(q[0], q[1]));
        }
    }
}
