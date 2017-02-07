package heap;

public class MaxHeap {
	private int N;
	private int[] pq;
	private int n;
	
	public MaxHeap(int capacity) {
		pq = new int[capacity + 1];
		this.N = capacity;
	}


	public void insert(int value) {
		pq[++n] = value;
		swim(n);
	}

	public int deleteMax() {
		int max = pq[1];
		pq[1] = pq[n--];
		pq[n + 1] = 0;
		sink(1);
		return max;
	}

	private void sink(int k) {
		while(2*k < n) {
			int j = 2*k;
			if(j < n && isLess(j + 1, j )) {swap(j, j+1);}
			j++;
			if(isLess(k, j)) {
				swap(k, j);
				k = j;
			} else {
				break;
			}
		}
	}

	private void swim(int k) {
		while(k > 1 && isLess(k/2, k)) {
			swap(k, k/2);
			k = k/2;
		}
	}

	private boolean isLess(int i, int j) {
		return pq[i] < pq[j];
	}
	private void swap(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	private boolean isMaxHeap() {
		return isMaxHeap(1);
	}

	// is subtree of pq[1..n] rooted at k a max heap?
	private boolean isMaxHeap(int k) {
		if (k > n) return true;
		int left = 2*k;
		int right = 2*k + 1;
		if (left  <= n && isLess(k, left))  return false;
		if (right <= n && isLess(k, right)) return false;
		return isMaxHeap(left) && isMaxHeap(right);
	}

	private void print() {
		for(int i : pq) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(10);
		heap.insert(10);
		heap.print();
		heap.insert(8);
		heap.print();
		heap.insert(12);
		heap.print();
		heap.insert(7);
		heap.print();
		heap.insert(9);
		heap.print();
		heap.insert(3);
		heap.print();
		heap.insert(18);
		heap.print();
		System.out.println("is Max heap " + heap.isMaxHeap());
		System.out.println("Get max: " + heap.deleteMax());
		heap.print();
		System.out.println("Get max: " + heap.deleteMax());
		heap.print();
		System.out.println("is Max heap " + heap.isMaxHeap());
	}

}
