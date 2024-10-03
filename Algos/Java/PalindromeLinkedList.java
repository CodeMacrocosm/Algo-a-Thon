
/*Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.

Input: LinkedList: 1->2->1->1->2->1
Output: true

Input: LinkedList: 1->2->3->4
Output: false */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//structure of the node
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
//creating the linked list
public class PalindromeLinkedList {
	static Node insert(Node head, int data) {
		Node temp = new Node(data);
		if(head == null) {
			head = temp;
			return head;
		}
		else {
			Node t = head;
			while(t.next != null) {
				t = t.next;
			}
			t.next = temp;
		}
		return head;
	}
	//main function
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());  // t -> number of test cases
		while(t-- > 0) {
			Node head = null;
			String str[] = read.readLine().trim().split(" ");
			int listSize = str.length;
			for(int i = 0; i< listSize; i++) {
				head = insert(head, Integer.parseInt(str[i]));
			}
			boolean f = isPalindrome(head);
			System.out.println(f ? "true" : "false");
		}
	}
	//function to check the linked list is palindrome or not
	public static boolean isPalindrome(Node head) {
		Node slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node prev = null, curr = slow;
		while(curr != null) {
			Node nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		Node first = head, second = prev;
		while(second != null) {
			if(first.data != second.data) return false;
			first = first.next;
			second = second.next;
		}
		return true;
	}

}
