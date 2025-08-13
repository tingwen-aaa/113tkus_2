import java.util.ArrayList;

class Task {
    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + "(priority:" + priority + ")";
    }
}

class MaxHeap {
    private ArrayList<Task> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void insert(Task task) {
        heap.add(task);
        heapifyUp(heap.size() - 1);
    }

    public Task extractMax() {
        if (heap.isEmpty()) return null;
        Task max = heap.get(0);
        Task last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return max;
    }

    public Task peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).priority > heap.get(parent).priority) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        int left, right, largest;
        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            largest = index;

            if (left < heap.size() && heap.get(left).priority > heap.get(largest).priority) {
                largest = left;
            }
            if (right < heap.size() && heap.get(right).priority > heap.get(largest).priority) {
                largest = right;
            }
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        Task temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

public class TaskSchedulerWithHeap {
    public static void main(String[] args) {
        MaxHeap scheduler = new MaxHeap();

        System.out.println("=== Max Heap Task Scheduler Demo ===");
        scheduler.insert(new Task("System Backup", 1));
        scheduler.insert(new Task("Emergency Fix", 5));
        scheduler.insert(new Task("Data Cleanup", 2));
        scheduler.insert(new Task("System Update", 4));
        scheduler.insert(new Task("Routine Maintenance", 1));
        scheduler.insert(new Task("Security Scan", 3));

        System.out.println("\nCurrent top priority task: " + scheduler.peek());
        System.out.println("Total tasks: " + scheduler.size());

        System.out.println("\nExecuting tasks in priority order:");
        while (!scheduler.isEmpty()) {
            Task t = scheduler.extractMax();
            System.out.println("Executing: " + t + " (Remaining: " + scheduler.size() + ")");
        }
    }
}
