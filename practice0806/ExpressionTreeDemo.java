import java.util.*;

public class ExpressionTreeDemo {
    
    static class TreeNode {
        String data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(String data) {
            this.data = data;
        }
        
        public boolean isOperator() {
            return data.equals("+") || data.equals("-") || 
                   data.equals("*") || data.equals("/");
        }
    }
    
    public static TreeNode buildExpressionTree(String[] postfix) {
        Stack<TreeNode> stack = new Stack<>();
        
        for (String token : postfix) {
            TreeNode node = new TreeNode(token);
            
            if (isOperator(token)) {
                node.right = stack.pop();
                node.left = stack.pop();
            }
            stack.push(node);
        }
        
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }

    public static double evaluateExpressionTree(TreeNode root) {
        if (root == null) return 0;
        if (!root.isOperator()) {
            return Double.parseDouble(root.data);
        }
        double leftValue = evaluateExpressionTree(root.left);
        double rightValue = evaluateExpressionTree(root.right);
        switch (root.data) {
            case "+": return leftValue + rightValue;
            case "-": return leftValue - rightValue;
            case "*": return leftValue * rightValue;
            case "/":
                if (rightValue == 0) throw new ArithmeticException("Division by zero");
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Unknown operator: " + root.data);
        }
    }

    public static String toInfixExpression(TreeNode root) {
        if (root == null) return "";
        if (!root.isOperator()) return root.data;
        String leftExpr = toInfixExpression(root.left);
        String rightExpr = toInfixExpression(root.right);
        return "(" + leftExpr + " " + root.data + " " + rightExpr + ")";
    }

    public static String toPrefixExpression(TreeNode root) {
        if (root == null) return "";
        if (!root.isOperator()) return root.data;
        String leftExpr = toPrefixExpression(root.left);
        String rightExpr = toPrefixExpression(root.right);
        return root.data + " " + leftExpr + " " + rightExpr;
    }

    public static String toPostfixExpression(TreeNode root) {
        if (root == null) return "";
        if (!root.isOperator()) return root.data;
        String leftExpr = toPostfixExpression(root.left);
        String rightExpr = toPostfixExpression(root.right);
        return leftExpr + " " + rightExpr + " " + root.data;
    }

    public static void displayTree(TreeNode root, String prefix, boolean isLast) {
        if (root != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + root.data);
            if (root.left != null || root.right != null) {
                if (root.left != null) {
                    displayTree(root.left, prefix + (isLast ? "    " : "│   "), root.right == null);
                }
                if (root.right != null) {
                    displayTree(root.right, prefix + (isLast ? "    " : "│   "), true);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] postfixExpression = {"3", "4", "+", "2", "1", "-", "*"};
        System.out.println("=== Expression Tree Demo ===");
        System.out.println("Postfix Expression: " + Arrays.toString(postfixExpression));
        TreeNode root = buildExpressionTree(postfixExpression);

        System.out.println("\nExpression Tree Structure:");
        displayTree(root, "", true);

        System.out.println("\n=== Expression Conversion ===");
        System.out.println("Infix: " + toInfixExpression(root));
        System.out.println("Prefix: " + toPrefixExpression(root));
        System.out.println("Postfix: " + toPostfixExpression(root));

        System.out.println("\n=== Evaluation ===");
        double result = evaluateExpressionTree(root);
        System.out.printf("Result: %.2f\n", result);

        String[] complexPostfix = {"5", "3", "+", "8", "6", "-", "*", "2", "/"};
        System.out.println("\n=== Complex Expression Test ===");
        System.out.println("Postfix: " + Arrays.toString(complexPostfix));
        TreeNode complexRoot = buildExpressionTree(complexPostfix);
        System.out.println("Infix: " + toInfixExpression(complexRoot));
        System.out.printf("Result: %.2f\n", evaluateExpressionTree(complexRoot));
    }
}
