public class TreeNodeBasicDemo {
    
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
        public void displayNode() {
            System.out.println("Value: " + data);
            System.out.println("Left: " + (left != null ? left.data : "null"));
            System.out.println("Right: " + (right != null ? right.data : "null"));
        }
    }
    
    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        
        System.out.println("=== Tree Info ===");
        System.out.println("Root:");
        root.displayNode();
        
        System.out.println("\n=== Tree Stats ===");
        System.out.println("Height: " + getHeight(root));
        System.out.println("Total nodes: " + countNodes(root));
        System.out.println("Leaf nodes: " + countLeaves(root));
        
        System.out.println("\n=== Node Details ===");
        System.out.println("Left child (5):");
        root.left.displayNode();
        
        System.out.println("\nRight child (15):");
        root.right.displayNode();
    }
}
