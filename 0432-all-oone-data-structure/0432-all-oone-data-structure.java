class AllOne {

    HashMap <String, Node> track;
    Node head;
    Node tail;

    private void insertNode (Node old, Node newNode) {
        newNode.next = old.next;
        newNode.next.prev = newNode;
        old.next = newNode;
        newNode.prev = old;
    }

    private void jump (Node jumpFrom, Node jumpTo, String key) {
        jumpFrom.remove(key);
        jumpTo.add(key);
    }

    public AllOne() {
        track = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        
        if (track.containsKey(key)) {
            Node node = track.get(key);

            if (node.next.freq != node.freq + 1) {
                Node newNode = new Node(node.freq + 1);
                insertNode(node, newNode);
                jump(node,newNode,key);
                track.put(key,newNode);
            } else {
                Node newNode = node.next;
                jump(node,newNode,key);
                track.put(key, newNode);
            }

            node.removeNode();

        } else {
            if (head.next.freq != 1) {
                Node newNode = new Node(1);
                insertNode(head,newNode);
                newNode.add(key);
                track.put(key,newNode);
            } else {
                Node node = head.next;
                node.add(key);
                track.put(key,node);
            }

        }


        
    }
    
    public void dec(String key) {
        if(!track.containsKey(key)) {
            System.out.println("key Not found");
            return;
        }

        Node node = track.get(key);
        
        //if freq == 1

        if (node.freq == 1) {
            node.remove(key);
            track.remove(key);
            node.removeNode();
            return;
        }

        //if prev of node is node (node - 1)

        if (node.prev.freq != node.freq - 1) {
            Node newNode = new Node(node.freq - 1);
            insertNode(node.prev,newNode);
            jump(node,newNode,key);
            track.put(key, newNode);
        } else {
            jump(node,node.prev,key);
            track.put(key,node.prev);
        }
        
        node.removeNode();

    }
    
    public String getMaxKey() {
        
        return tail.prev.get();
        
    }
    
    public String getMinKey() {
        return head.next.get();
    }


    class Node {
        int freq;
        HashSet <String> set;
        Node next;
        Node prev;

        Node(int freq) {
            this.freq = freq;
            set = new HashSet<>();
            next = null;
            prev = null;
        }

        void remove (String s) {
            if (set.contains(s)){
                set.remove(s);
            }
            System.out.println(s + " not found in node : " + freq);
        }

        void add(String s) {
            set.add(s);
        }

        boolean isEmpty() {
            return set.isEmpty();
        }

        void removeNode() {
            if (isEmpty()){
                prev.next = next;
                next.prev = prev;
            }
        }

        public String get(){
            if (isEmpty()) {
                System.out.println("set is Empty at get function");
                return "";
            }

            for (String s : set) {
                return s;
            }
            return null;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */


//  class AllOne {
//     static class Node {
//         String key;
//         int count;
//         Node(String key, int count) {
//             this.key = key;
//             this.count = count;
//         }
//     }

//     HashMap<String, Integer> map;
//     PriorityQueue<Node> maxPQ;
//     PriorityQueue<Node> minPQ;

//     public AllOne() {
//         map = new HashMap<>();

//         maxPQ = new PriorityQueue<>((a, b) -> b.count - a.count); 
//         minPQ = new PriorityQueue<>((a, b) -> a.count - b.count);
//     }

//     public void inc(String key) {
//         int newCount = map.getOrDefault(key, 0) + 1;
//         map.put(key, newCount);

//         maxPQ.offer(new Node(key, newCount));
//         minPQ.offer(new Node(key, newCount));
//     }

//     public void dec(String key) {
//         int newCount = map.get(key) - 1;

//         if (newCount == 0) {
//             map.remove(key);
//         } else {
//             map.put(key, newCount);
//             maxPQ.offer(new Node(key, newCount));
//             minPQ.offer(new Node(key, newCount));
//         }
//     }

//     public String getMaxKey() {
//         while (!maxPQ.isEmpty()) {
//             Node top = maxPQ.peek();
//             if (!map.containsKey(top.key) || map.get(top.key) != top.count) {
//                 maxPQ.poll();
//             } else {
//                 return top.key;
//             }
//         }
//         return "";
//     }

//     public String getMinKey() {
//         while (!minPQ.isEmpty()) {
//             Node top = minPQ.peek();
//             if (!map.containsKey(top.key) || map.get(top.key) != top.count) {
//                 minPQ.poll();
//             } else {
//                 return top.key;
//             }
//         }
//         return "";
//     }
// }
