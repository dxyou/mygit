package SortSet;

import interFace.sortCollection;

public  class sortCollectionImplement implements sortCollection {
	/*
	 * (non-Javadoc)
	 * @see interFace.sortCollection#QuickSort(java.lang.Comparable[], int, int)
	 */
	public <T extends Comparable <?super T>> void QuickSort(T[] Array,int start,int end) {
		if(start>=end) {
			return;
		}
		int i = start;int j = end;
		T key = Array[i];
		while(i<j) {
			while(j>i && Array[j].compareTo(key) >= 0) { //右边找出比key小的
				j--;
			}
			if(i<j) {
				Array[i] = Array[j];
				i++;
			}
			
			while(i<j && Array[i].compareTo(key) <=0) { //左边找出比key大的
				i++;
			}
			if(i<j) {
				Array[j] = Array[i];
				j--;
			}
		}
		Array[i] = key;	//i==j
		
		this.QuickSort(Array, start, i-1);
		
		this.QuickSort(Array, i+1, end);
	}
	
	public static void main(String[] args) {
		Integer [] a = {19,4,2,56,4,93,10,3,8,48,38};
		int l = a.length;
//		System.out.print("l:"+l+"\n");
		int i=0;
		/*
		 * 快排测试
		 */
		sortCollectionImplement s= new sortCollectionImplement();
		s.QuickSort(a, 0, l-1);
		
		/*
		 * 
		 */
		while(i<l) {
			System.out.print(a[i]+" ");
			i++;
		}
	}
}
