package linkedlist;

public class MergeLinkedLists {
	private static Node merge(Node list1, Node list2) {
		
		if(list1 == null && list2 == null) {
			return null;
		}
		if(list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		if(list1.data < list2.data) {
			list1.next = merge(list1.next, list2);
			return list1;
		} else {
			list2.next = merge(list2.next, list1);
			return list2;
		}
	}
	
	private static Node mergeNonRecursive(Node list1, Node list2) {
		Node head = new Node();
		Node current = head;
		while(list1 != null || list2 != null) {
			if(list2 == null) {
				current.data = list1.data;
				current.next = list1.next;
				break;
			} else if(list1 == null) {
				current.data = list2.data;
				current.next = list2.next;
				break;
			} else {
				if(list1.data < list2.data) {
					current.data = list1.data;
					list1 = list1.next;
				} else {
					current.data = list2.data;
					list2 = list2.next;
				}
				current.next = new Node();
				current = current.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node list1 = Node.createLinkedList(new int[]{1,2,5,6,8});
		Node list2 = Node.createLinkedList(new int[] {3,4,7,9});
		Node merged = merge(list1, list2);
		merged.print();
		merged = mergeNonRecursive(Node.createLinkedList(new int[]{1,2,5,6,8}), Node.createLinkedList(new int[] {3,4,7,9}));
		System.out.println("Using non recursive approach");
		merged.print();
	}
}
