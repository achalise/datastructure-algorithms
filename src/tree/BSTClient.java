package tree;

public class BSTClient {
	public static void main(String[] args) {
		BST table = new BST();
		String[] keys = "B S T S E A R C H D E M O W I T H S A M E V A L U E S".split("\\s");
		int i = 0;
		for(String key: keys) {
			table.put(key, i++);
		}
		table.printInOrder();
		table.printPreOrder();
		table.printPostOrder();
		System.out.println("The value of key A :  " + table.getValue("A"));
		Object min = table.min();
		System.out.println("The min value: "  + min);
		System.out.println("The max value: " + table.max());
		System.out.println("Floor for G: " + table.floor("G"));
		System.out.println("Floor for Q: " + table.floor("Q"));		
		System.out.println("Is valid BST :" + table.check());
		
		System.out.println("Delete max");
		table.deleteMax();
		table.printInOrder();
		
	}
}
