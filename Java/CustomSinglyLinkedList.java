

// This class is to show the implementation of Linked List in java
// it requires t ocreate an object of ListNode class (which is the unit of Linked List);

// in simple words linked list is a chain of objects linked(linked means having
// access to other or next object ) by refernce variable
public class CustomSinglyLinkedList<T> {
    // the first object of this chain of object. we refer it as
    ListNode <T> head;
    //    so head is like linkedlist[0] ?
    // the answer is no . its value is null. Just a separate pointer
    // (i mean ListNode obj)  whose value is zero or null but has refernce to the first
    // object of that list

    int length;
    //    do we need length ? is it fixed?
    // we can have length(thats why its customLinkedList)
    // having length certainly helps us  and length is not fixed
    // we can add as many nodes we want.

    // Now operations

    // 1st: Constructors


    // deafult one just to initilize the head;
    CustomSinglyLinkedList(){
        this.head=null;
    }
    // we can make other construtors as well like to add elements when
    // create this list


    // 2nd: methods

    // ADDITION OF A NODE:
    //   Now we can add at three places(in the start==head, in the end== tail,
    // in the middle anywhere)
    // lol but you have to do it not user.



    // to add at the end
    void add(T val){

        // Step 1: Create new object(of ListNode) obviously
        ListNode<T> newNode  = new ListNode<>(val);
        //    what ListNode can have constructor?
        //  YES, you can check ListNode.java File(custom file)


        // Checking if list is empty
        // and assigning new value to head node
        if(this.head==null){
            head=newNode;
        }

        // if list is present then
        else {



            //    a tempNode to go to the end
            ListNode<T> temp = head;

            // we need to go till end to get the last node
            while (temp.next != null) {
                temp = temp.next;
            }

            // Adding new node to the last
            temp.next = newNode;
            newNode.next=null;
        }

        // we have length also
        length++;
    }

    //    to any postion in the middle of the list
    void add(int position, T val)
    {
        //    if invalid positon
        if(position > length + 1 ||position <0){
            System.out.println("Invalid Position ");
            return;
        }

        // we can separately check id position if head i.e==0 but we can merge
        // it with anywhere in the code.


        //    a tempNode to go to the end
        ListNode<T> temp = head;
        // a prev node beacuse we need to reconnect the prev one with newNode
        ListNode<T> prev  = head;



        // going to the position
        while (position> 0) {
            // assigning previous node to the current temp node
            prev = temp;
            // increasing the  next node
            temp = temp.next;
            // decreasing position counter
            position--;
        }
        // previous node now points to new value
        prev.next = new ListNode<T>(val);



        // new value now points to former current node
        prev.next.next = temp;

        // we have to increase  length also
        length++;
    }

    // DETETION OF A NODE:
    //  we can have deletion by value, but it can become somewhat complicated
    // (it can be done) but just to show implementation i have used here delete  by index;

    T delete (int index){


        //    a tempNode to go to the end
        ListNode<T> temp = head;
        // a prev node beacuse we need to reconnect the prev one with newNode
        ListNode<T> prev  = head;

        //  reaching that point
        while(index>0){
            prev=temp;
            temp=temp.next;
            index--;
        }
        //    change the refernce variable of prev to next one
        prev.next=temp.next;
        temp.next=null;
        //   decearse in length
        length--;
        return temp.val;
    }

    //   to delete entire linked list
    void deleteAll(){
        head=null;
        length=0;
    }

    // to check if list is empty;
    boolean isEmpty(){
        if(head==null){
            return true;
        }
        else{
            return false;
        }
    }

    // to get length
    int length(){
        return this.length;
    }

    // to display LinkedList
    void displayList(){
        String s = "[";
        ListNode temp  =head;
     while(temp!=null){
         if(temp.next==null){
             s+= temp.val;
             break;
         }
         s += temp.val+", ";
         temp = temp.next;

     }
            s +="]";
        System.out.println(s);
     }

    
}
