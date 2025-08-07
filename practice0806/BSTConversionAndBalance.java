
public class BSTConversionAndBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode prev = null;
    static TreeNode head = null;

    public static void bstToDoublyList(TreeNode root) {
        if (root == null) return;
        bstToDoublyList(root.left);
        if (prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bstToDoublyList(root.right);
    }

    public static TreeNode sortedArrayToBST(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedArrayToBST(arr, left, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, right);
        return node;
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        int right = checkHeight(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static void convertToGreaterSumTree(TreeNode root) {
        convertHelper(root, new int[]{0});
    }

    private static void convertHelper(TreeNode node, int[] sum) {
        if (node == null) return;
        convertHelper(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        convertHelper(node.left, sum);
    }

    public static void inOrderPrint(TreeNode root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.print(root.val + " ");
            inOrderPrint(root.right);
        }
    }

    public static void printDoublyList(TreeNode head) {
        TreeNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bst = sortedArrayToBST(sortedArray, 0, sortedArray.length - 1);

        System.out.print("In-order of BST: ");
        inOrderPrint(bst);
        System.out.println();

        bstToDoublyList(bst);
        System.out.print("BST to Doubly Linked List: ");
        printDoublyList(head);

        TreeNode bst2 = sortedArrayToBST(sortedArray, 0, sortedArray.length - 1);
        System.out.println("Is Balanced BST: " + isBalanced(bst2));

        convertToGreaterSumTree(bst2);
        System.out.print("Greater Sum Tree (In-order): ");
        inOrderPrint(bst2);
        System.out.println();
    }
}
