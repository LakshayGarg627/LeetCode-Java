class LRUCache {
    class Node{
        Node next;
        Node prev;
        int key;
        int value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int limit=0;
    HashMap<Integer,Node> map=new HashMap<>();

    public void addNode(Node newNode){
        Node oldNode=head.next;
        head.next=newNode;
        newNode.prev=head;
        newNode.next=oldNode;
        oldNode.prev=newNode;
    }

    public void deleteNode(Node oldNode){
        Node oldPrev=oldNode.prev;
        Node oldNext=oldNode.next;
        oldPrev.next=oldNext;
        oldNext.prev=oldPrev;
    }
    
    public LRUCache(int capacity) {
        limit=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int ans=map.get(key).value;
        Node ansNode=map.get(key);
        deleteNode(ansNode);
        addNode(ansNode);

        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode=map.get(key);
            deleteNode(oldNode);
            map.remove(key);
        }
        if(map.size()==limit){
            Node oldNode=tail.prev;
            deleteNode(oldNode);
            map.remove(oldNode.key);
        }
        Node newNode=new Node(key,value);
        addNode(newNode);
        map.put(key,newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */