package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ExampleBST implements BST {
	private class Node {
		private String key;
		private Integer value;
		private int size;
		private Node left;
		private Node right;
		
		private Node(String key, Integer value) {
			this.key = key;
			this.value = value;
		}
		 @Override
		public String toString() {
			 String curr = "Key: " + key;
			 String l = left == null ? "" : left.key;
			 String r = right == null ? "" : right.key;
			 return curr + " Left: " + l + " Right: " + r; 
		}
	}
	
	private Node root;
	
	private Node getValue(Node node, String key) {
		if(node == null) {
			return null;
		}
		if(node.key.equals(key)) {
			return node;
		}
		if(key.compareTo(node.key) > 0) {
			return getValue(node.right, key);
		} else {
			return getValue(node.left, key);
		}
	}
	
	private void put(Node node, String key, Integer value) {
		int compare = key.compareTo(node.key);
		if(compare == 0) {
			node.value = value;
		} else if(compare < 0) {
			if(node.left == null) {
				node.left = new Node(key, value);
			} else {
				put(node.left, key, value);				
			}
		} else {
			if(node.right == null) {
				node.right = new Node(key, value);
			} else {
				put(node.right, key, value);				
			}
		}
	}
	
	public void put(String key, Integer value) {
		if(root == null) {
			root = new Node(key, value);
		} else {
			put(root, key, value);
		}
	}
	
	public Integer get(String key) {
		Node n =  getValue(root, key);
		if(n == null) {
			return null;
		} else {
			return n.value;
		}
	}
	
	public void remove(String key) {
		root = remove(root, key);
	}
	
	private Node remove(Node node, String key) {
		if(node == null) {return null;}
		int compare = key.compareTo(node.key);
		if(compare > 0) {
			node.right = remove(node.right, key);
		} else if (compare < 0) {
			node.left = remove(node.left, key);
		} else {
			if(node.left == null) {return node.right;}
			else if(node.right == null) {return node.left;}
			else {
				Node min = getValue(node.right, min(node.right));
				node.key = min.key;
				node.right = deleteMin(node.right);
			}
		}
		return node;
	}
	
	public String min() {		
		return min(root);
	}
	
	public int rank(String key) {
		Node n = getValue(root, key);
		if(n != null) {
			return n.size + 1;
		} else {
			return -1;
		}
	}
	
	public void populateSize() {
		populateSize(root);
	}
	
	private int populateSize(Node node) {
		if(node == null) {
			return 0;
		}
		node.size = 1 + populateSize(node.left) + populateSize(node.right);
		return node.size;
	}
	
	private String min(Node node) {
		if (node == null) {
			return null;
		} else if (node.left == null) {
			return node.key;
		} else {
			return min(node.left);
		}
	}
	
	public String max() {
		return max(root);
	}
	
	private String max(Node node) {
		if (node == null) {
			return null;
		} else if (node.right == null) {
			return node.key;
		} else {
			return max(node.right);
		}		
	}

	public void deleteMax() {
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node node) {
		if(node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		return node;
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node node) {
		if(node == null) {
			return null;
		}
		if(node.left == null) {
			return node.right;
		} else {
			node.left = deleteMin(node.left);
			return node;
		}
	}
	
	public String ceiling(String key) {
		return ceiling(root, key);
	}
	
	private String ceiling(Node node, String key) {
		if(node == null) {
			return null;
		}

		int compare = key.compareTo(node.key);
		if(compare == 0) {
			return node.key;
		}
		if(compare > 0) {
			return ceiling(node.right, key);
		} else {
			String t = ceiling(node.left, key);
			if(t == null) {
				return node.key;
			} else {
				return t;
			}
		}
	}
	
	
	public String floor(String key) {
		return floor(root, key);
	}
	
	private String floor(Node node, String key) {
		if(node == null) {
			return null;
		}
		if(key.compareTo(node.key) == 0) {
			return node.key;
		} else if(key.compareTo(node.key) < 0) {
			return floor(node.left, key);
		} else {
			String t = floor(node.right, key);
			if (t == null) {
				return node.key;
			} else {
				return t;
			}
		}
		
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public boolean check() {
		return check(root);
	}

	private boolean check(Node node) {
		if(node == null) return true;
		if(node.right != null && node.key.compareTo(node.right.key) > 0) {
			return false;
		} else if(node.left != null && node.key.compareTo(node.left.key) < 0) {
			return false;
		} else {
			return check(node.right) && check(node.left);
		}
	}
	
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	
	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}

	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}
	
	public void printLevelOrder() {
		Queue<Node> q = new LinkedList<>();
		Queue<Node> qLevel = new LinkedList<>();
		Node temp;
		q.add(root);
		int level = 0;
		while(!q.isEmpty()) {
			System.out.println("Level: " + level++);									
			while(!q.isEmpty()) {
				temp = q.poll();
				System.out.print(temp.key + " ");
				if(temp.left != null) qLevel.add(temp.left);
				if(temp.right != null) qLevel.add(temp.right);			
			}
			q = qLevel;
			qLevel = new LinkedList<>();
			System.out.println();
		}		
	}
	
	
	private void printInOrder(Node node) {
		if(node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.key + " ");		
		printInOrder(node.right);		
	}

	private void printPreOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.key + " ");		
		printInOrder(node.left);
		printInOrder(node.right);		
	}

	private void printPostOrder(Node node) {
		if(node == null) {
			return;
		}
		printInOrder(node.left);
		printInOrder(node.right);		
		System.out.print(node.key + " ");		
	}
}
