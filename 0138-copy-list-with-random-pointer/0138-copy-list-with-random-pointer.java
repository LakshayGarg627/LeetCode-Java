/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        HashMap<Node,Node> map=new HashMap<>();
        Node newHead=new Node(head.val);
        Node oldTemp=head.next;
        Node newTemp=newHead;
        map.put(head,newHead);
        while(oldTemp!=null){
            Node newNode=new Node(oldTemp.val);
            map.put(oldTemp,newNode);
            newTemp.next=newNode;
            newTemp=newTemp.next;
            oldTemp=oldTemp.next;
        }
        oldTemp=head;
        newTemp=newHead;
        while(oldTemp!=null){
            newTemp.random=map.get(oldTemp.random);
            oldTemp=oldTemp.next;
            newTemp=newTemp.next;
        }
        return newHead;
    }
}