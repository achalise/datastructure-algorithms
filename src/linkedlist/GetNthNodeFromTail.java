package linkedlist;

public class GetNthNodeFromTail {
	private static int count = 0;

	private static Node retrieveNthFromTail(Node list, int index) {
		if(list.next == null) {
			return list;
		}
		list = list.next;
		Node theVal = retrieveNthFromTail(list, index);
		if(index == count++) {
			theVal = list;
		}
		return theVal;
	}
	public static void main(String[] args) {
		Node list = Node.createLinkedList(new int[]{1,2,3,4,5});
		//list.print();
		Node nth = retrieveNthFromTail(list, 2);
		nth.print();
	}
}
