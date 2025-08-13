import java.util.*;

class Task {
    String name;
    int priority;
    long timestamp;
    
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

public class TaskScheduler {
    private PriorityQueue<Task> taskQueue;
    
    public TaskScheduler() {
        taskQueue = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return Integer.compare(b.priority, a.priority);
            }
            return Long.compare(a.timestamp, b.timestamp);
        });
    }
    
    public void addTask(String name, int priority) {
        Task task = new Task(name, priority);
        taskQueue.offer(task);
        System.out.println("Added task: " + task + 
                         " (Queue size: " + taskQueue.size() + ")");
    }
    
    public Task executeNextTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to execute");
            return null;
        }
        Task task = taskQueue.poll();
        System.out.println("Executing task: " + task + 
                         " (Remaining tasks: " + taskQueue.size() + ")");
        return task;
    }
    
    public Task peekNextTask() {
        if (taskQueue.isEmpty()) {
            return null;
        }
        return taskQueue.peek();
    }
    
    public void showPendingTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No pending tasks");
        } else {
            System.out.println("Next task: " + peekNextTask());
            System.out.println("Total pending tasks: " + taskQueue.size());
        }
    }
    
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        System.out.println("=== Task Scheduler Demo ===");
        
        scheduler.addTask("System Backup", 1);
        scheduler.addTask("Emergency Fix", 5);
        scheduler.addTask("Data Cleanup", 2);
        scheduler.addTask("System Update", 4);
        scheduler.addTask("Routine Maintenance", 1);
        scheduler.addTask("Security Scan", 3);
        
        System.out.println("\nCurrent status:");
        scheduler.showPendingTasks();
        
        System.out.println("\nStart executing tasks:");
        while (!scheduler.taskQueue.isEmpty()) {
            scheduler.executeNextTask();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("\nAll tasks executed!");
    }
}
