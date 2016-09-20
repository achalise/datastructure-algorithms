package tree;

public class BST {
	private class Node {
		private String key;
		private Integer value;
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
	
	public Object getValue(String key) {
		Node n =  getValue(root, key);
		if(n == null) {
			return null;
		} else {
			return n.value;
		}
	}
	
	public Object min() {		
		return min(root);
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
	
	public Object max() {
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
	
	public Node deleteMax(Node node) {
		if(node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		return node;
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
