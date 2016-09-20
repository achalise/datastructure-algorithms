package sort;

public class QuickSort {
	
	private static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(int[] a, int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		System.out.println("Partitionaing at: " + j);
		sort(a, lo, j);
		sort(a, j+1, hi);
	}
	
	private static int partition(int[] a, int lo, int hi) {
		int pivot = a[lo];
		int i = lo, j = hi;
		while(true) {
			while(a[++i] <= pivot) {
				if(i == hi) {
					break;
				}
			}
			while(a[j] >= pivot) {
				j--;
				if(j == lo) {
					break;
				}
			}
			if(i>=j) {
				break;
			}			
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void print(int[] a) {
		for(int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{9,2,8,4,1,8,3,5,0,1};
		sort(a);
		print(a);
	}
}
