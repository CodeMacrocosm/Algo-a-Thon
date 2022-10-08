

// This is node class. when an object of this class in created it has a value of 
// defined datatype and a reference variable pointing  to an object of 
// same ListNode type 

// This is for singleLinkedListNode
public class ListNode<T> {
    //the value 
       T val;
       ListNode<T> next;

       ListNode(T val){
             this.val =val;
             this.next = null;
       }
}
