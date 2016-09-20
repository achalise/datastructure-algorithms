package linkedlist;

public class ReverseLinkedList {
	private static Node reverseListRecursive(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node remaining = head.next;
		head.next = null;//avoid cycle
		Node reversedHead = reverseListRecursive(remaining);//on first exit, we get the last node, store that as the head of the reversed list
		remaining.next = head; //now keep adding prev node at the end as we unroll from recursion
		return reversedHead;
	}
	
	
	private static Node reverseListIterative(Node head) {
		Node current, prev, next;
		current = head;
		prev = null;
		next = current.next;
		while(next != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
		}
		current.next = prev;
		return current;
	}
	
	public static void main(String[] args) {
		Node list1 = Node.createLinkedList(new int[]{1,2,5,6,8});
		Node reversed = reverseListRecursive(list1);
		reversed.print();
		reversed = reverseListIterative(Node.createLinkedList(new int[]{9,4,3,1,7}));
		reversed.print();
	}
}
