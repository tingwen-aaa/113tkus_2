import java.util.*;

public class MultiWayTreeAndDecisionTree {

    static class MultiWayNode {
        String data;
        List<MultiWayNode> children;

        MultiWayNode(String data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static void dfs(MultiWayNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        for (MultiWayNode child : node.children) {
            dfs(child);
        }
    }

    public static void bfs(MultiWayNode root) {
        Queue<MultiWayNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            MultiWayNode current = queue.poll();
            System.out.print(current.data + " ");
            for (MultiWayNode child : current.children) {
                queue.offer(child);
            }
        }
    }

    public static int height(MultiWayNode node) {
        if (node == null) return 0;
        int maxChildHeight = 0;
        for (MultiWayNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
        }
        return 1 + maxChildHeight;
    }

    public static void printDegrees(MultiWayNode node) {
        if (node == null) return;
        System.out.println("Node: " + node.data + ", Degree: " + node.children.size());
        for (MultiWayNode child : node.children) {
            printDegrees(child);
        }
    }

    static class DecisionNode {
        String question;
        DecisionNode yes;
        DecisionNode no;

        DecisionNode(String question) {
            this.question = question;
        }

        boolean isLeaf() {
            return yes == null && no == null;
        }
    }

    public static void playDecisionTree(DecisionNode node, Scanner scanner) {
        while (!node.isLeaf()) {
            System.out.println(node.question + " (yes/no)");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                node = node.yes;
            } else {
                node = node.no;
            }
        }
        System.out.println("Answer: " + node.question);
    }

    public static void main(String[] args) {
        MultiWayNode root = new MultiWayNode("A");
        MultiWayNode b = new MultiWayNode("B");
        MultiWayNode c = new MultiWayNode("C");
        MultiWayNode d = new MultiWayNode("D");
        MultiWayNode e = new MultiWayNode("E");
        MultiWayNode f = new MultiWayNode("F");
        root.children.add(b);
        root.children.add(c);
        b.children.add(d);
        b.children.add(e);
        c.children.add(f);

        System.out.print("DFS: ");
        dfs(root);
        System.out.println();

        System.out.print("BFS: ");
        bfs(root);
        System.out.println();

        System.out.println("Tree Height: " + height(root));
        printDegrees(root);

        DecisionNode q1 = new DecisionNode("Is it a number?");
        DecisionNode q2 = new DecisionNode("Is it greater than 5?");
        DecisionNode q3 = new DecisionNode("Is it even?");
        DecisionNode leaf1 = new DecisionNode("Number is 8");
        DecisionNode leaf2 = new DecisionNode("Number is 7");
        DecisionNode leaf3 = new DecisionNode("Number is 4");
        DecisionNode leaf4 = new DecisionNode("Number is 1");

        q1.yes = q2;
        q1.no = leaf4;
        q2.yes = q3;
        q2.no = leaf3;
        q3.yes = leaf1;
        q3.no = leaf2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Decision Tree ---");
        playDecisionTree(q1, scanner);
        scanner.close();
    }
}
