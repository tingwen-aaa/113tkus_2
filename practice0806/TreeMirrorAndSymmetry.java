public class TreeMirrorAndSymmetry {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static TreeNode mirror(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);
        return root;
    }

    public static boolean areMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree1 = buildSampleTree();
        System.out.println("Symmetric: " + isSymmetric(tree1));

        TreeNode mirrored = mirror(buildSampleTree());
        System.out.println("Are Mirror: " + areMirror(tree1, mirrored));

        TreeNode sub = new TreeNode(2);
        sub.left = new TreeNode(3);
        System.out.println("Is Subtree: " + isSubtree(tree1, sub));
    }
}
