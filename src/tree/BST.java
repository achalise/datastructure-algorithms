package tree;

public interface BST {
	public void put(String key, Integer value);
	public void remove(String key);
	public Integer get(String key);
	public String min();
	public String max();
	public int height();
	public int rank(String key);
	public String floor(String key);
	public String ceiling(String key);
	public void printInOrder();
	public void printPostOrder();
	public void printPreOrder();
	public void printLevelOrder();
	public void deleteMax();
	public void deleteMin();
}
