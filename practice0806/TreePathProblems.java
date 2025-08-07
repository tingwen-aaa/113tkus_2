import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(root, current, paths);
        return paths;
    }

    private static void dfs(TreeNode node, List<Integer> current, List<List<Integer>> paths) {
        if (node == null) return;
        current.add(node.val);
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(current));
        } else {
            dfs(node.left, current, paths);
            dfs(node.right, current, paths);
        }
        current.remove(current.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static int maxRootToLeafSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + Math.max(maxRootToLeafSum(root.left), maxRootToLeafSum(root.right));
    }

    public static int treeDiameter(TreeNode root) {
        int[] diameter = new int[1];
        maxDepth(root, diameter);
        return diameter[0];
    }

    private static int maxDepth(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        int left = maxDepth(node.left, diameter);
        int right = maxDepth(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        List<List<Integer>> paths = allRootToLeafPaths(root);
        System.out.println("All Root to Leaf Paths:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        int target = 14;
        System.out.println("Has Path Sum " + target + ": " + hasPathSum(root, target));

        System.out.println("Max Root to Leaf Sum: " + maxRootToLeafSum(root));
        System.out.println("Tree Diameter: " + treeDiameter(root));
    }
}
