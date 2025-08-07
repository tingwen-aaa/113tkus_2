public class BinaryTreeOperationsDemo {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;
        return search(root.left, target) || search(root.right, target);
    }

    public static int sumAllNodes(TreeNode root) {
        if (root == null) return 0;
        return root.data + sumAllNodes(root.left) + sumAllNodes(root.right);
    }

    public static int findMax(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("Empty tree");
        int max = root.data;
        if (root.left != null) max = Math.max(max, findMax(root.left));
        if (root.right != null) max = Math.max(max, findMax(root.right));
        return max;
    }

    public static int findMin(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("Empty tree");
        int min = root.data;
        if (root.left != null) min = Math.min(min, findMin(root.left));
        if (root.right != null) min = Math.min(min, findMin(root.right));
        return min;
    }

    public static boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return (tree1.data == tree2.data) &&
               isSameTree(tree1.left, tree2.left) &&
               isSameTree(tree1.right, tree2.right);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.data == right.data) &&
               isSymmetricHelper(left.left, right.right) &&
               isSymmetricHelper(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);

        System.out.println("Search 7: " + search(root, 7));
        System.out.println("Search 20: " + search(root, 20));
        System.out.println("Sum of all nodes: " + sumAllNodes(root));
        System.out.println("Max value: " + findMax(root));
        System.out.println("Min value: " + findMin(root));

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(12);
        root2.right.right = new TreeNode(18);

        System.out.println("Same tree: " + isSameTree(root, root2));

        TreeNode symmetricRoot = new TreeNode(1);
        symmetricRoot.left = new TreeNode(2);
        symmetricRoot.right = new TreeNode(2);
        symmetricRoot.left.left = new TreeNode(3);
        symmetricRoot.left.right = new TreeNode(4);
        symmetricRoot.right.left = new TreeNode(4);
        symmetricRoot.right.right = new TreeNode(3);

        System.out.println("Symmetric test: " + isSymmetric(symmetricRoot));
        System.out.println("Original tree symmetric: " + isSymmetric(root));
    }
}
