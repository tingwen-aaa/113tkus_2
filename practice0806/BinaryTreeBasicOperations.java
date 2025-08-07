public class BinaryTreeBasicOperations {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int totalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int maxValue(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxValue(root.left), maxValue(root.right)));
    }

    public static int minValue(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(minValue(root.left), minValue(root.right)));
    }

    public static int treeWidth(TreeNode root) {
        if (root == null) return 0;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            maxWidth = Math.max(maxWidth, levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return maxWidth;
    }

    public static boolean isComplete(TreeNode root) {
        if (root == null) return true;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                foundNull = true;
            } else {
                if (foundNull) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        int sum = totalSum(root);
        int count = countNodes(root);
        int max = maxValue(root);
        int min = minValue(root);
        int width = treeWidth(root);
        boolean complete = isComplete(root);

        System.out.println("Total sum: " + sum);
        System.out.println("Average: " + (double)sum / count);
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);
        System.out.println("Max width: " + width);
        System.out.println("Is complete binary tree: " + complete);
    }
}
