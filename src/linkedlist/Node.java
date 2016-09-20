package linkedlist;

public class Node {
	int data;
	Node next;
	public void print() {
		System.out.print(data + " ");
		if(next != null) {
			next.print();			
		} else {
			System.out.println();
		}
	}
	public static Node createLinkedList(int[] values) {
		Node head, current;
		head = new Node();
		current = head;
		int count = 0;
		for (int i : values) {
			current.data = i;
			if(count++ == values.length - 1) {
				current.next = null;
				break;
			} else {
				current.next = new Node();
				current = current.next;
			}
		}
		return head;
	}
}
