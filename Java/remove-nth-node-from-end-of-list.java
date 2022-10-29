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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;
            ListNode p=head,q=head;
            int len=0;
            while(p!=null)
            {
                len=len+1;
                p=p.next;
            }
            int pos=len-n+1,i=1;
            if(pos==1)
            head=head.next;
            else{
            while(i<pos-1)
            {
                q=q.next;
                i++;
            }
            q.next=q.next.next;
            }
            return head;

        
    }
}
