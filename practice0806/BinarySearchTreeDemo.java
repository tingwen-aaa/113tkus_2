public class BinarySearchTreeDemo {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class BST {
        TreeNode root;

        public BST() {
            root = null;
        }

        public void insert(int data) {
            root = insertRec(root, data);
        }

        private TreeNode insertRec(TreeNode root, int data) {
            if (root == null) {
                return new TreeNode(data);
            }

            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        public boolean search(int data) {
            return searchRec(root, data);
        }

        private boolean searchRec(TreeNode root, int data) {
            if (root == null) {
                return false;
            }

            if (root.data == data) {
                return true;
            }

            if (data < root.data) {
                return searchRec(root.left, data);
            } else {
                return searchRec(root.right, data);
            }
        }

        public void delete(int data) {
            root = deleteRec(root, data);
        }

        private TreeNode deleteRec(TreeNode root, int data) {
            if (root == null) {
                return null;
            }

            if (data < root.data) {
                root.left = deleteRec(root.left, data);
            } else if (data > root.data) {
                root.right = deleteRec(root.right, data);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                root.data = findMin(root.right);
                root.right = deleteRec(root.right, root.data);
            }

            return root;
        }

        public int findMin() {
            if (root == null) {
                throw new RuntimeException("Tree is empty");
            }
            return findMin(root);
        }

        private int findMin(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root.data;
        }

        public int findMax() {
            if (root == null) {
                throw new RuntimeException("Tree is empty");
            }
            return findMax(root);
        }

        private int findMax(TreeNode root) {
            while (root.right != null) {
                root = root.right;
            }
            return root.data;
        }

        public void inOrderTraversal() {
            inOrderRec(root);
            System.out.println();
        }

        private void inOrderRec(TreeNode root) {
            if (root != null) {
                inOrderRec(root.left);
                System.out.print(root.data + " ");
                inOrderRec(root.right);
            }
        }

        public boolean isValidBST() {
            return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean validate(TreeNode node, int min, int max) {
            if (node == null) return true;
            if (node.data <= min || node.data >= max) return false;
            return validate(node.left, min, node.data) && validate(node.right, node.data, max);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();

        System.out.println("=== BST Demo ===");

        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        System.out.println("Insert: " + java.util.Arrays.toString(values));

        for (int value : values) {
            bst.insert(value);
        }

        System.out.print("In-order: ");
        bst.inOrderTraversal();

        System.out.println("\n=== Search ===");
        int[] searchValues = {35, 55, 25, 100};
        for (int value : searchValues) {
            boolean found = bst.search(value);
            System.out.printf("Search %d: %s\n", value, found ? "Found" : "Not found");
        }

        System.out.println("\n=== Min/Max ===");
        System.out.println("Min: " + bst.findMin());
        System.out.println("Max: " + bst.findMax());

        System.out.println("\n=== Delete ===");

        System.out.print("Before delete 10: ");
        bst.inOrderTraversal();
        bst.delete(10);
        System.out.print("After delete 10: ");
        bst.inOrderTraversal();

        System.out.print("Before delete 20: ");
        bst.inOrderTraversal();
        bst.delete(20);
        System.out.print("After delete 20: ");
        bst.inOrderTraversal();

        System.out.print("Before delete 30: ");
        bst.inOrderTraversal();
        bst.delete(30);
        System.out.print("After delete 30: ");
        bst.inOrderTraversal();

        System.out.println("Is valid BST: " + bst.isValidBST());
    }
}
