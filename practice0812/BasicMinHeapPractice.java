import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicMinHeapPractice {
    private List<Integer> heap;

    public BasicMinHeapPractice() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap.get(i) < heap.get(parent(i))) {
            Collections.swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int minIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < heap.size() && heap.get(left) < heap.get(minIndex)) {
            minIndex = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(minIndex)) {
            minIndex = right;
        }
        if (minIndex != i) {
            Collections.swap(heap, i, minIndex);
            heapifyDown(minIndex);
        }
    }

    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (!isEmpty()) heapifyDown(0);
        return min;
    }

    public int getMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        BasicMinHeapPractice minHeap = new BasicMinHeapPractice();
        int[] values = {15, 10, 20, 8, 25, 5};

        System.out.println("Inserting values:");
        for (int v : values) {
            minHeap.insert(v);
            System.out.println("Inserted " + v + ", Heap: " + minHeap.heap);
        }

        System.out.println("\nExtracting values in ascending order:");
        while (!minHeap.isEmpty()) {
            int min = minHeap.extractMin();
            System.out.println("Extracted: " + min + ", Heap: " + minHeap.heap);
        }
    }
}
