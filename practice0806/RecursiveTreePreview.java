import java.util.*;

public class RecursiveTreePreview {

    static class FileNode {
        String name;
        boolean isFile;
        List<FileNode> children;

        public FileNode(String name, boolean isFile) {
            this.name = name;
            this.isFile = isFile;
            this.children = new ArrayList<>();
        }

        public void addChild(FileNode child) {
            this.children.add(child);
        }
    }

    public static int countFiles(FileNode node) {
        if (node == null) return 0;
        if (node.isFile) return 1;
        int count = 0;
        for (FileNode child : node.children) {
            count += countFiles(child);
        }
        return count;
    }

    public static void printMenu(Map<String, Object> menu, int indent) {
        for (String key : menu.keySet()) {
            for (int i = 0; i < indent; i++) System.out.print("  ");
            System.out.println("- " + key);
            if (menu.get(key) instanceof Map) {
                printMenu((Map<String, Object>) menu.get(key), indent + 1);
            }
        }
    }

    public static List<Integer> flatten(List<Object> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (Object element : nestedList) {
            if (element instanceof Integer) {
                result.add((Integer) element);
            } else if (element instanceof List) {
                result.addAll(flatten((List<Object>) element));
            }
        }
        return result;
    }

    public static int maxDepth(List<Object> nestedList) {
        int max = 1;
        for (Object element : nestedList) {
            if (element instanceof List) {
                max = Math.max(max, 1 + maxDepth((List<Object>) element));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("=== File System Simulation ===");
        FileNode root = new FileNode("root", false);
        FileNode file1 = new FileNode("a.txt", true);
        FileNode file2 = new FileNode("b.txt", true);
        FileNode folder = new FileNode("docs", false);
        FileNode file3 = new FileNode("c.pdf", true);
        root.addChild(file1);
        root.addChild(folder);
        folder.addChild(file2);
        folder.addChild(file3);
        System.out.println("File count: " + countFiles(root));

        System.out.println("\n=== Nested Menu ===");
        Map<String, Object> menu = new LinkedHashMap<>();
        Map<String, Object> fileMenu = new LinkedHashMap<>();
        fileMenu.put("Open", null);
        fileMenu.put("Save", null);
        fileMenu.put("Export", null);
        Map<String, Object> editMenu = new LinkedHashMap<>();
        editMenu.put("Cut", null);
        editMenu.put("Paste", null);
        menu.put("File", fileMenu);
        menu.put("Edit", editMenu);
        printMenu(menu, 0);

        System.out.println("\n=== Flatten Nested List ===");
        List<Object> nestedList = Arrays.asList(1, Arrays.asList(2, Arrays.asList(3, 4)), 5);
        List<Integer> flat = flatten(nestedList);
        System.out.println("Flattened: " + flat);

        System.out.println("\n=== Max Depth of Nested List ===");
        System.out.println("Max Depth: " + maxDepth(nestedList));
    }
}
