package SortSet;

//import interFace.sortCollection;

public  class sortCollectionImplement2 {
	private static void QuickSort(int [] Array,int start,int end) {
		if(start>=end) {
			return;
		}
		int i = start;
		int	j = end;
		int key = Array[i];
		while(i<j) {
			while(j>i && Array[j]>=key) {
				j--;
			}
			if(i<j) {
				Array[i] = Array[j];
				i++;
			}
			
			while(i<j && Array[i]<=key) {
				i++;
			}
			if(i<j) {
				Array[j] = Array[i];
				j--;
			}
		}
		Array[i] = key;	//i==j
		
		QuickSort(Array, start, i-1);
		
		QuickSort(Array, i+1, end);
	}
	
	public static void main(String[] args) {
		int [] a = {19,4,2,56,4,93,10,3,8,48,38};
		int l = a.length;
//		System.out.print("l:"+l+"\n");
		int i=0;
		QuickSort(a, 0, l-1);
		while(i<l) {
			System.out.print(a[i]+" ");
			i++;
		}
	}
}
