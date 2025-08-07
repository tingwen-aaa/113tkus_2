import java.util.*;

public class FileSystemDemo {
    
    static class FileNode {
        String name;
        boolean isDirectory;
        List<FileNode> children;
        FileNode parent;
        int size;
        
        public FileNode(String name, boolean isDirectory) {
            this.name = name;
            this.isDirectory = isDirectory;
            this.children = isDirectory ? new ArrayList<>() : null;
            this.parent = null;
            this.size = 0;
        }
        
        public FileNode(String name, int size) {
            this.name = name;
            this.isDirectory = false;
            this.children = null;
            this.parent = null;
            this.size = size;
        }
    }
    
    static class FileSystem {
        FileNode root;
        FileNode currentDirectory;
        
        public FileSystem() {
            root = new FileNode("/", true);
            currentDirectory = root;
        }
        
        public boolean mkdir(String dirName) {
            if (findChild(currentDirectory, dirName) != null) return false;
            FileNode newDir = new FileNode(dirName, true);
            newDir.parent = currentDirectory;
            currentDirectory.children.add(newDir);
            return true;
        }
        
        public boolean createFile(String fileName, int size) {
            if (findChild(currentDirectory, fileName) != null) return false;
            FileNode newFile = new FileNode(fileName, size);
            newFile.parent = currentDirectory;
            currentDirectory.children.add(newFile);
            return true;
        }
        
        public boolean cd(String dirName) {
            if (dirName.equals("..")) {
                if (currentDirectory.parent != null) {
                    currentDirectory = currentDirectory.parent;
                    return true;
                }
                return false;
            }
            FileNode targetDir = findChild(currentDirectory, dirName);
            if (targetDir != null && targetDir.isDirectory) {
                currentDirectory = targetDir;
                return true;
            }
            return false;
        }
        
        public void ls() {
            System.out.println("[" + getCurrentPath() + "]");
            for (FileNode child : currentDirectory.children) {
                String type = child.isDirectory ? "[DIR]" : "[FILE]";
                String sizeInfo = child.isDirectory ? "" : " (" + child.size + " bytes)";
                System.out.println("  " + type + " " + child.name + sizeInfo);
            }
        }
        
        public String getCurrentPath() {
            List<String> pathComponents = new ArrayList<>();
            FileNode current = currentDirectory;
            while (current != null && current != root) {
                pathComponents.add(current.name);
                current = current.parent;
            }
            Collections.reverse(pathComponents);
            return "/" + String.join("/", pathComponents);
        }
        
        public long calculateDirectorySize(FileNode dir) {
            if (!dir.isDirectory) return dir.size;
            long totalSize = 0;
            for (FileNode child : dir.children) {
                totalSize += calculateDirectorySize(child);
            }
            return totalSize;
        }
        
        public List<String> findFile(String fileName) {
            List<String> results = new ArrayList<>();
            findFileHelper(root, fileName, "", results);
            return results;
        }
        
        private void findFileHelper(FileNode node, String fileName, String currentPath, List<String> results) {
            String nodePath = currentPath + "/" + node.name;
            if (node.name.equals(fileName)) results.add(nodePath);
            if (node.isDirectory && node.children != null) {
                for (FileNode child : node.children) {
                    findFileHelper(child, fileName, nodePath, results);
                }
            }
        }
        
        public void tree() {
            displayTree(root, "", true);
        }
        
        private void displayTree(FileNode node, String prefix, boolean isLast) {
            String icon = node.isDirectory ? "[D]" : "[F]";
            String sizeInfo = node.isDirectory ? "" : " (" + node.size + " bytes)";
            System.out.println(prefix + (isLast ? "└── " : "├── ") + icon + " " + node.name + sizeInfo);
            if (node.isDirectory && node.children != null && !node.children.isEmpty()) {
                for (int i = 0; i < node.children.size(); i++) {
                    boolean childIsLast = (i == node.children.size() - 1);
                    displayTree(node.children.get(i), prefix + (isLast ? "    " : "│   "), childIsLast);
                }
            }
        }
        
        private FileNode findChild(FileNode parent, String name) {
            if (parent.children == null) return null;
            for (FileNode child : parent.children) {
                if (child.name.equals(name)) return child;
            }
            return null;
        }
    }
    
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        
        fs.mkdir("documents");
        fs.mkdir("programs");
        fs.mkdir("pictures");
        
        fs.createFile("readme.txt", 1024);
        fs.createFile("config.ini", 512);
        fs.ls();
        
        fs.cd("documents");
        fs.mkdir("projects");
        fs.mkdir("reports");
        fs.createFile("important.doc", 2048);
        fs.createFile("notes.txt", 256);
        fs.ls();
        
        fs.cd("projects");
        fs.mkdir("java");
        fs.mkdir("python");
        fs.createFile("project1.zip", 5120);
        fs.ls();
        
        fs.cd("java");
        fs.createFile("Main.java", 1536);
        fs.createFile("Utils.java", 2048);
        fs.createFile("README.md", 512);
        fs.ls();
        
        fs.tree();
        
        long rootSize = fs.calculateDirectorySize(fs.root);
        System.out.printf("Total size: %d bytes (%.2f KB)\n", rootSize, rootSize / 1024.0);
        
        while (fs.currentDirectory != fs.root) fs.cd("..");
        for (FileNode child : fs.root.children) {
            if (child.isDirectory) {
                long dirSize = fs.calculateDirectorySize(child);
                System.out.printf("Directory %s: %d bytes (%.2f KB)\n", child.name, dirSize, dirSize / 1024.0);
            }
        }
        
        List<String> results = fs.findFile("readme.txt");
        for (String path : results) {
            System.out.println("Found: " + path);
        }
        
        results = fs.findFile("Main.java");
        for (String path : results) {
            System.out.println("Found: " + path);
        }
    }
}
