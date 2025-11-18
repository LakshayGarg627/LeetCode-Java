/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newNode=new ListNode(-1);
        ListNode temp1=newNode;
        ListNode temp=head;
        int i=1;
        while(i<left){
            temp1.next=temp;
            temp1=temp1.next;
            temp=temp.next;
            i++;
        }
        ListNode revHead=null;
        ListNode revTail=null;
        while(i<=right){
            if(revHead==null){
                revHead=temp;
            }
            revTail=temp;
            temp=temp.next;
            i++;
        }
        revTail.next=null;
        ListNode curr=revHead;
        ListNode prev=null;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        temp1.next=prev;
        while(temp1.next!=null){
            temp1=temp1.next;
        }
        temp1.next=temp;

        return newNode.next;
        

    }
}