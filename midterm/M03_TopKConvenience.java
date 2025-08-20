import java.util.*;

public class M03_TopKConvenience {
    static class Item {
        String name;
        int qty;
        Item(String n, int q) {
            this.name = n;
            this.qty = q;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            items.add(new Item(name, qty));
        }

        PriorityQueue<Item> pq = new PriorityQueue<>(new Comparator<Item>() {
            public int compare(Item a, Item b) {
                if (a.qty != b.qty) return a.qty - b.qty;
                return a.name.compareTo(b.name);
            }
        });

        for (Item it : items) {
            pq.offer(it);
            if (pq.size() > k) pq.poll();
        }

        List<Item> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll());

        result.sort(new Comparator<Item>() {
            public int compare(Item a, Item b) {
                if (b.qty != a.qty) return b.qty - a.qty;
                return a.name.compareTo(b.name);
            }
        });

        for (Item it : result) {
            System.out.println(it.name + " " + it.qty);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n log k)
 * 說明：每個元素插入大小為 k 的最小堆，單次 O(log k)，共 n 次 → O(n log k)。
 * 取出並排序 k 個元素成本 O(k log k)，因 k << n，可忽略，總複雜度為 O(n log k)。
 */
