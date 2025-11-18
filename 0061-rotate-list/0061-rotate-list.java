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
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        k=k%size;
        while(k>0){
            ListNode temp1=head;
            ListNode last=null;
            while(temp1.next.next!=null){
                temp1=temp1.next;
            }
            last=temp1.next;
            temp1.next=null;

            last.next=head;
            head=last;
            k--;
        }
        return head;
        
    }
}