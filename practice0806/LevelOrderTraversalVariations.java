import java.util.*;

public class LevelOrderTraversalVariations {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void printRightMost(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode last = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) last = node;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            System.out.print(last.val + " ");
        }
        System.out.println();
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        if (root != null) q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.computeIfAbsent(p.col, k -> new ArrayList<>()).add(p.node.val);
            if (p.node.left != null) q.offer(new Pair(p.node.left, p.col - 1));
            if (p.node.right != null) q.offer(new Pair(p.node.right, p.col + 1));
        }
        return new ArrayList<>(map.values());
    }

    static class Pair {
        TreeNode node;
        int col;
        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
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

        System.out.println("Level Order:");
        for (List<Integer> level : levelOrder(root)) System.out.println(level);

        System.out.println("Zigzag Level Order:");
        for (List<Integer> level : zigzagLevelOrder(root)) System.out.println(level);

        System.out.print("Rightmost Node Each Level: ");
        printRightMost(root);

        System.out.println("Vertical Order:");
        for (List<Integer> col : verticalOrder(root)) System.out.println(col);
    }
}