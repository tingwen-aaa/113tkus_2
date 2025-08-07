import java.util.*;

public class AdvancedBSTOperations {
    
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inOrderForKth(root, result, k);
        if (result.size() >= k) {
            return result.get(k - 1);
        } else {
            throw new IllegalArgumentException("k is out of bounds");
        }
    }

    private static void inOrderForKth(TreeNode root, List<Integer> result, int k) {
        if (root == null || result.size() >= k) return;
        inOrderForKth(root.left, result, k);
        if (result.size() < k) {
            result.add(root.data);
        }
        inOrderForKth(root.right, result, k);
    }

    public static List<Integer> rangeBST(TreeNode root, int low, int high) {
        List<Integer> result = new ArrayList<>();
        rangeHelper(root, low, high, result);
        return result;
    }

    private static void rangeHelper(TreeNode root, int low, int high, List<Integer> result) {
        if (root == null) return;
        if (root.data >= low && root.data <= high) {
            result.add(root.data);
        }
        if (root.data > low) {
            rangeHelper(root.left, low, high, result);
        }
        if (root.data < high) {
            rangeHelper(root.right, low, high, result);
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (p < root.data && q < root.data) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p > root.data && q > root.data) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode arrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBSTHelper(nums, left, mid - 1);
        root.right = arrayToBSTHelper(nums, mid + 1, right);
        return root;
    }

    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.data) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        for (int val : values) {
            root = insertIntoBST(root, val);
        }

        System.out.println("=== Advanced BST Demo ===");
        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("\n=== Kth Smallest ===");
        for (int k = 1; k <= 5; k++) {
            try {
                int kthElement = kthSmallest(root, k);
                System.out.printf("K = %d: %d\n", k, kthElement);
            } catch (IllegalArgumentException e) {
                System.out.printf("K = %d: %s\n", k, e.getMessage());
            }
        }

        System.out.println("\n=== Range Query ===");
        List<Integer> rangeResult = rangeBST(root, 25, 45);
        System.out.println("[25, 45]: " + rangeResult);

        rangeResult = rangeBST(root, 15, 35);
        System.out.println("[15, 35]: " + rangeResult);

        System.out.println("\n=== Lowest Common Ancestor ===");
        TreeNode lca1 = lowestCommonAncestor(root, 10, 25);
        System.out.printf("LCA of 10 and 25: %d\n", lca1.data);
        TreeNode lca2 = lowestCommonAncestor(root, 35, 45);
        System.out.printf("LCA of 35 and 45: %d\n", lca2.data);
        TreeNode lca3 = lowestCommonAncestor(root, 20, 70);
        System.out.printf("LCA of 20 and 70: %d\n", lca3.data);

        System.out.println("\n=== Sorted Array to Balanced BST ===");
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        TreeNode balancedRoot = sortedArrayToBST(sortedArray);
        System.out.print("Balanced BST: ");
        inOrderTraversal(balancedRoot);
        System.out.println();

        System.out.println("\n=== Balance Check ===");
        System.out.printf("Original BST is balanced: %s\n", isBalanced(root));
        System.out.printf("Balanced BST from array is balanced: %s\n", isBalanced(balancedRoot));

        TreeNode unbalancedRoot = new TreeNode(1);
        unbalancedRoot.right = new TreeNode(2);
        unbalancedRoot.right.right = new TreeNode(3);
        unbalancedRoot.right.right.right = new TreeNode(4);
        System.out.printf("Chain-like BST is balanced: %s\n", isBalanced(unbalancedRoot));
    }
}
