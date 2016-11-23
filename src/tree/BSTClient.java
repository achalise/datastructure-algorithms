package tree;

public class BSTClient {
	public static void main(String[] args) {
		ExampleBST table = new ExampleBST();
		String[] keys = "K G P A T C O R Z D Y B".split("\\s");
		int i = 0;
		for(String key: keys) {
			table.put(key, i++);
		}
		System.out.println("In Order");
		table.printInOrder();
		System.out.println("Pre Order");
		table.printPreOrder();
		System.out.println("Post Order");		
		table.printPostOrder();
		System.out.println("Level Order");
		table.printLevelOrder();
		
		System.out.println("The value of key A :  " + table.get("A"));
		Object min = table.min();
		System.out.println("The min value: "  + min);
		System.out.println("The max value: " + table.max());
		System.out.println("Floor for G: " + table.floor("G"));
		System.out.println("Floor for Q: " + table.floor("Q"));	
		System.out.println("Ceiling for W: " + table.ceiling("W"));
		System.out.println("Ceiling for E: " + table.ceiling("E"));
		System.out.println("Height of tree: " + table.height());
		System.out.println("Is valid BST :" + table.check());
		
		System.out.println("Delete max");
		table.deleteMax();
		table.printInOrder();
		System.out.println("Delete min");
		table.deleteMin();
		table.printInOrder();
		
		table.populateSize();
		System.out.println("Rank of key P: " + table.rank("P"));		
		System.out.println("Rank of key B: " + table.rank("B"));
		System.out.println("Rank of key A: " + table.rank("A"));		
		
		System.out.println("Remove key O "); 
		table.remove("O");
		table.printInOrder();		
	}
}
