class AllOne {
    static class Node {
        String key;
        int count;
        Node(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    HashMap<String, Integer> map;
    PriorityQueue<Node> maxPQ;
    PriorityQueue<Node> minPQ;

    public AllOne() {
        map = new HashMap<>();

        maxPQ = new PriorityQueue<>((a, b) -> b.count - a.count); // max-heap
        minPQ = new PriorityQueue<>((a, b) -> a.count - b.count); // min-heap
    }

    public void inc(String key) {
        int newCount = map.getOrDefault(key, 0) + 1;
        map.put(key, newCount);

        maxPQ.offer(new Node(key, newCount));
        minPQ.offer(new Node(key, newCount));
    }

    public void dec(String key) {
        int newCount = map.get(key) - 1; // guaranteed to exist

        if (newCount == 0) {
            map.remove(key);
        } else {
            map.put(key, newCount);
            maxPQ.offer(new Node(key, newCount));
            minPQ.offer(new Node(key, newCount));
        }
    }

    public String getMaxKey() {
        while (!maxPQ.isEmpty()) {
            Node top = maxPQ.peek();
            // stale if key removed OR freq changed
            if (!map.containsKey(top.key) || map.get(top.key) != top.count) {
                maxPQ.poll();
            } else {
                return top.key;
            }
        }
        return "";
    }

    public String getMinKey() {
        while (!minPQ.isEmpty()) {
            Node top = minPQ.peek();
            if (!map.containsKey(top.key) || map.get(top.key) != top.count) {
                minPQ.poll();
            } else {
                return top.key;
            }
        }
        return "";
    }
}
