/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int size(ListNode head){
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null){
            return headB;
        }
        if(headB==null){
            return headA;
        }
        int size1=size(headA);
        int size2=size(headB);
        int d=Math.abs(size1-size2);
        ListNode temp1=headA;
        ListNode temp2=headB;
        if(size1>size2){
            while(d>0){
                temp1=temp1.next;
                d--;
            }
        }else{
            while(d>0){
                temp2=temp2.next;
                d--;
            }
        }

        while(temp1!=null && temp2!=null){
            if(temp1==temp2){
                return temp1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }

        return null;
    }
}

// public class Solution {
//     public int size(ListNode head){
//         int size=0;
//         ListNode temp=head;
//         while(temp!=null){
//             size++;
//             temp=temp.next;
//         }
//         return size;
//     }
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         int lenA=size(headA);
//         int lenB=size(headB);
//         ListNode temp1=headA;
//         ListNode temp2=headB;

//         int d=Math.abs(lenA-lenB);
//         if(lenA>lenB){
//             while(d>0){
//                 temp1=temp1.next;
//                 d--;
//             }
//         }
//         if(lenA<lenB){
//             while(d>0){
//                 temp2=temp2.next;
//                 d--;
//             }
//         }
        
//         while(temp1!=null && temp2!=null){
//             if(temp1==temp2){
//                 return temp1;
//             }
//             temp1=temp1.next;
//             temp2=temp2.next;
//         }
//         return null;

//     }
// }