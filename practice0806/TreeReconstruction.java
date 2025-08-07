import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode buildPreIn(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer, Integer> map) {
        if (preL > preR || inL > inR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int inRoot = map.get(root.val);
        int leftSize = inRoot - inL;
        root.left = buildPreIn(preorder, preL + 1, preL + leftSize, inorder, inL, inRoot - 1, map);
        root.right = buildPreIn(preorder, preL + leftSize + 1, preR, inorder, inRoot + 1, inR, map);
        return root;
    }

    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode buildPostIn(int[] post, int postL, int postR, int[] in, int inL, int inR, Map<Integer, Integer> map) {
        if (postL > postR || inL > inR) return null;
        TreeNode root = new TreeNode(post[postR]);
        int inRoot = map.get(root.val);
        int leftSize = inRoot - inL;
        root.left = buildPostIn(post, postL, postL + leftSize - 1, in, inL, inRoot - 1, map);
        root.right = buildPostIn(post, postL + leftSize, postR - 1, in, inRoot + 1, inR, map);
        return root;
    }

    public static TreeNode buildCompleteTreeFromLevelOrder(int[] level) {
        if (level.length == 0) return null;
        TreeNode[] nodes = new TreeNode[level.length];
        for (int i = 0; i < level.length; i++) nodes[i] = new TreeNode(level[i]);
        for (int i = 0; i < level.length; i++) {
            int left = 2 * i + 1, right = 2 * i + 2;
            if (left < level.length) nodes[i].left = nodes[left];
            if (right < level.length) nodes[i].right = nodes[right];
        }
        return nodes[0];
    }

    public static void inorderPrint(TreeNode root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.val + " ");
            inorderPrint(root.right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder =  {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        int[] levelOrder = {1, 2, 3, 4, 5, 6, 7};

        TreeNode root1 = buildTreePreIn(preorder, inorder);
        TreeNode root2 = buildTreePostIn(postorder, inorder);
        TreeNode root3 = buildCompleteTreeFromLevelOrder(levelOrder);

        System.out.print("Inorder of tree built from preorder + inorder: ");
        inorderPrint(root1);
        System.out.println();

        System.out.print("Inorder of tree built from postorder + inorder: ");
        inorderPrint(root2);
        System.out.println();

        System.out.print("Inorder of tree built from level-order (complete): ");
        inorderPrint(root3);
        System.out.println();
    }
}
