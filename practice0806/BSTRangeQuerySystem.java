public class BSTRangeQuerySystem {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void rangeQuery(TreeNode root, int min, int max) {
        if (root == null) return;
        if (root.val > min) rangeQuery(root.left, min, max);
        if (root.val >= min && root.val <= max) System.out.print(root.val + " ");
        if (root.val < max) rangeQuery(root.right, min, max);
    }

    public static int rangeCount(TreeNode root, int min, int max) {
        if (root == null) return 0;
        if (root.val < min) return rangeCount(root.right, min, max);
        if (root.val > max) return rangeCount(root.left, min, max);
        return 1 + rangeCount(root.left, min, max) + rangeCount(root.right, min, max);
    }

    public static int rangeSum(TreeNode root, int min, int max) {
        if (root == null) return 0;
        if (root.val < min) return rangeSum(root.right, min, max);
        if (root.val > max) return rangeSum(root.left, min, max);
        return root.val + rangeSum(root.left, min, max) + rangeSum(root.right, min, max);
    }

    public static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            root = (target < root.val) ? root.left : root.right;
        }
        return closest;
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        int[] values = {15, 10, 20, 5, 13, 18, 25};
        TreeNode root = null;
        for (int v : values) {
            root = insert(root, v);
        }

        System.out.print("Range [10, 20]: ");
        rangeQuery(root, 10, 20);
        System.out.println();

        System.out.println("Count in range [10, 20]: " + rangeCount(root, 10, 20));
        System.out.println("Sum in range [10, 20]: " + rangeSum(root, 10, 20));
        System.out.println("Closest to 17: " + closestValue(root, 17));
    }
}
