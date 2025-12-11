class LFUCache {
    class Node{
        int key;
        int value;
        int freq;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            freq=1;
        }
    }
    int capacity=0;
    int minFreq=0;
    HashMap<Integer,Node> map;
    HashMap<Integer,LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFreq=0;
        map=new HashMap<>();
        freqMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            updateFreq(node);
            return;
        }
        if(map.size()==capacity){
            LinkedHashSet<Integer> set=freqMap.get(minFreq);
            int lruKey=set.iterator().next();
            set.remove(lruKey);
            map.remove(lruKey);
        }
        Node node=new Node(key,value);
        map.put(key,node);
        minFreq=1;
        freqMap.computeIfAbsent(1,x->new LinkedHashSet<>()).add(key);

    }
    private void updateFreq(Node node){
        int oldFreq=node.freq;
        int newFreq=oldFreq+1;
        freqMap.get(oldFreq).remove(node.key);
        if(oldFreq==minFreq && freqMap.get(oldFreq).isEmpty()){
            minFreq++;
        }
        node.freq=newFreq;
        freqMap.computeIfAbsent(newFreq,x-> new LinkedHashSet<>()).add(node.key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */