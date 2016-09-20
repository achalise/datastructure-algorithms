package sort;

public class MergeSort {	
	
	private static void mergeSort(int[] a, int[] aux, int lo, int hi) {
		if(lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo)/2;
		System.out.println("LO HI MID " + lo + " " + hi + " " + mid);
		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		System.out.println("Merging between " + lo + " and " + hi);
		for(int counter = lo; counter <= hi; counter++) {
			aux[counter] = a[counter];
		}
		int i = lo, j = mid + 1, k = lo;
		while(k <= hi) {
			if		(i > mid) a[k] = aux[j++];
			else if	(j > hi) a[k] = aux[i++];
			else if (aux[i] < aux[j]) a[k] = aux[i++];
			else    a[k] = aux[j++];
			k++;
		}
		
	}
	
	private static void sort(int[] a) {
		int[] aux = new int[a.length];
		mergeSort(a, aux, 0, a.length - 1);
	}
	
	private static int[] sortUsingBitMap(int[] a) {
		int[] sorted = new int[10];
		for(int i : a) {
			sorted[i] = i;
		}
		return sorted;
	}
	
	private static void print(int[] a) {
		for(int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{3,8,1,4,2,9,1,5};
		sort(a);
		print(a);
		a = new int[]{3,8,1,4,2,9,1,5};
		int[] sorted = sortUsingBitMap(a);
		print(sorted);
	}
}
