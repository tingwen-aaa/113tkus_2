import java.util.*;

public class BSTValidationAndRepair {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    static TreeNode first = null, second = null, prev = null;

    public static void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorder(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) first = prev;
            second = node;
        }
        prev = node;
        inorder(node.right);
    }

    public static int countInvalidNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        collectValues(root, list);
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) count++;
        }
        return count;
    }

    private static void collectValues(TreeNode node, List<Integer> list) {
        if (node == null) return;
        collectValues(node.left, list);
        list.add(node.val);
        collectValues(node.right, list);
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void inorderPrint(TreeNode node) {
        if (node == null) return;
        inorderPrint(node.left);
        System.out.print(node.val + " ");
        inorderPrint(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        int temp = root.left.val;
        root.left.val = root.right.right.val;
        root.right.right.val = temp;

        System.out.print("Inorder Before Repair: ");
        inorderPrint(root);
        System.out.println();

        System.out.println("Is Valid BST: " + isValidBST(root));
        System.out.println("Invalid Node Count: " + countInvalidNodes(root));

        recoverTree(root);

        System.out.print("Inorder After Repair: ");
        inorderPrint(root);
        System.out.println();

        System.out.println("Is Valid BST: " + isValidBST(root));
    }
}
