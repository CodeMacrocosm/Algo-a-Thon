/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true
Example 2:

Input: head = [1,2]
Output: false 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        ListNode mid = middle(head);
        ListNode rev = reverse(mid);
        while(rev!=null){
            if(head.val!=rev.val){
                return false;
            }
            head=head.next;
            rev=rev.next;
            
        }
        return true;
        
    }
    public static ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }
    public static ListNode reverse (ListNode head){
        if(head==null)return head;
        ListNode prev=null;
        while(head!=null){
            ListNode temp = head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}
