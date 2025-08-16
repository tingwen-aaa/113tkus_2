
public class AVLRotationExercise {

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

    public void insert(int x) {
        root = insert(root, x);
    }

    public void clear() {
        root = null;
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    public boolean isValidAVL() {
        return checkAVL(root) != -1;
    }

    private Node insert(Node n, int x) {
        if (n == null) return new Node(x);

        if (x < n.key) {
            n.left = insert(n.left, x);
        } else if (x > n.key) {
            n.right = insert(n.right, x);
        } else {
            return n; // ignore duplicates
        }

        n.update();
        int bf = n.balance();

        // LL
        if (bf > 1 && x < n.left.key) {
            return rotateRight(n);
        }
        // RR
        if (bf < -1 && x > n.right.key) {
            return rotateLeft(n);
        }
        // LR
        if (bf > 1 && x > n.left.key) {
            n.left = rotateLeft(n.left);
            return rotateRight(n);
        }
        // RL
        if (bf < -1 && x < n.right.key) {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }
        return n;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = (x == null ? null : x.right);
        x.right = y;
        y.left = t2;
        y.update();
        x.update();
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = (y == null ? null : y.left);
        y.left = x;
        x.right = t2;
        x.update();
        y.update();
        return y;
    }

    private void printInOrder(Node n) {
        if (n == null) return;
        printInOrder(n.left);
        System.out.print(n.key + "(bf=" + n.balance() + ",h=" + n.height + ") ");
        printInOrder(n.right);
    }

    private int checkAVL(Node n) {
        if (n == null) return 0;
        int lh = checkAVL(n.left);
        if (lh == -1) return -1;
        int rh = checkAVL(n.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        AVLRotationExercise t = new AVLRotationExercise();

        // RR case: triggers single left rotation
        t.clear();
        int[] rr = {10, 20, 30};
        for (int v : rr) t.insert(v);
        System.out.println("RR (Left rotation) after insert {10,20,30}:");
        t.printInOrder();
        System.out.println("Valid AVL: " + t.isValidAVL());
        System.out.println();

        // LL case: triggers single right rotation
        t.clear();
        int[] ll = {30, 20, 10};
        for (int v : ll) t.insert(v);
        System.out.println("LL (Right rotation) after insert {30,20,10}:");
        t.printInOrder();
        System.out.println("Valid AVL: " + t.isValidAVL());
        System.out.println();

        // LR case: triggers left then right rotation
        t.clear();
        int[] lr = {30, 10, 20};
        for (int v : lr) t.insert(v);
        System.out.println("LR (Left-Right rotation) after insert {30,10,20}:");
        t.printInOrder();
        System.out.println("Valid AVL: " + t.isValidAVL());
        System.out.println();

        // RL case: triggers right then left rotation
        t.clear();
        int[] rl = {10, 30, 20};
        for (int v : rl) t.insert(v);
        System.out.println("RL (Right-Left rotation) after insert {10,30,20}:");
        t.printInOrder();
        System.out.println("Valid AVL: " + t.isValidAVL());
        System.out.println();

        // Boundary checks
        t.clear();
        int[] more = {50, 25, 75, 10, 30, 60, 80, 5, 15, 27, 65};
        for (int v : more) t.insert(v);
        // duplicate insert should be ignored and not break invariants
        t.insert(25);
        System.out.println("Boundary check with larger set (duplicates ignored):");
        t.printInOrder();
        System.out.println("Valid AVL: " + t.isValidAVL());
    }
}
