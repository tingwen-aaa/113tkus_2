import java.util.*;

class Task {
    String name;
    int priority;
    long timestamp; // 用於相同優先級的先後順序

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.timestamp = System.nanoTime();
    }

    @Override
    public String toString() {
        return name + "(priority:" + priority + ")";
    }
}

public class PriorityQueueWithHeap {
    private PriorityQueue<Task> taskQueue;

    public PriorityQueueWithHeap() {
        taskQueue = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return Integer.compare(b.priority, a.priority); // 高優先級在前
            }
            return Long.compare(a.timestamp, b.timestamp); // 同優先級先加入先執行
        });
    }

    public void addTask(String name, int priority) {
        Task task = new Task(name, priority);
        taskQueue.offer(task);
        System.out.println("Added task: " + task + " (Queue size: " + taskQueue.size() + ")");
    }

    public Task executeNext() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to execute");
            return null;
        }
        Task task = taskQueue.poll();
        System.out.println("Executing task: " + task + " (Remaining: " + taskQueue.size() + ")");
        return task;
    }

    public Task peek() {
        return taskQueue.peek();
    }

    public void changePriority(String name, int newPriority) {
        List<Task> temp = new ArrayList<>();
        boolean found = false;

        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            if (task.name.equals(name) && !found) {
                System.out.println("Changing priority of " + task.name +
                                   " from " + task.priority + " to " + newPriority);
                task.priority = newPriority;
                task.timestamp = System.nanoTime();
                found = true;
            }
            temp.add(task);
        }

        taskQueue.addAll(temp);

        if (!found) {
            System.out.println("Task with name \"" + name + "\" not found.");
        }
    }

    public static void main(String[] args) {
        PriorityQueueWithHeap pq = new PriorityQueueWithHeap();

        System.out.println("=== Priority Queue with Heap Demo ===");
        pq.addTask("Backup", 1);
        pq.addTask("Emergency Fix", 5);
        pq.addTask("Update", 3);

        System.out.println("\nNext to execute: " + pq.peek());

        System.out.println("\nExecuting tasks in order:");
        pq.executeNext();
        pq.executeNext();
        pq.executeNext();

        System.out.println("\nAdding tasks again for priority change test:");
        pq.addTask("Backup", 1);
        pq.addTask("Update", 3);
        pq.changePriority("Backup", 4);

        System.out.println("\nExecuting tasks after priority change:");
        while (pq.peek() != null) {
            pq.executeNext();
        }
    }
}
