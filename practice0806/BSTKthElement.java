public class BSTKthElement {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Counter {
        int count = 0;
        int result = -1;
    }

    public static int kthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        inorderKth(root, k, counter);
        return counter.result;
    }

    private static void inorderKth(TreeNode node, int k, Counter counter) {
        if (node == null) return;
        inorderKth(node.left, k, counter);
        counter.count++;
        if (counter.count == k) {
            counter.result = node.val;
            return;
        }
        inorderKth(node.right, k, counter);
    }

    public static int kthLargest(TreeNode root, int k) {
        Counter counter = new Counter();
        reverseInorderKth(root, k, counter);
        return counter.result;
    }

    private static void reverseInorderKth(TreeNode node, int k, Counter counter) {
        if (node == null) return;
        reverseInorderKth(node.right, k, counter);
        counter.count++;
        if (counter.count == k) {
            counter.result = node.val;
            return;
        }
        reverseInorderKth(node.left, k, counter);
    }

    public static void rangePrint(TreeNode root, int k, int j) {
        printRangeInorder(root, k, j);
        System.out.println();
    }

    private static void printRangeInorder(TreeNode node, int k, int j) {
        if (node == null) return;
        if (node.val > k) printRangeInorder(node.left, k, j);
        if (node.val >= k && node.val <= j) System.out.print(node.val + " ");
        if (node.val < j) printRangeInorder(node.right, k, j);
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] nums = {5, 3, 8, 2, 4, 7, 10};
        for (int n : nums) root = insert(root, n);

        System.out.println("Kth Smallest (k=3): " + kthSmallest(root, 3));
        System.out.println("Kth Largest (k=2): " + kthLargest(root, 2));
        System.out.print("Range (3~8): ");
        rangePrint(root, 3, 8);
    }
}