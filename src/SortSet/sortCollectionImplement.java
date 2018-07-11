package SortSet;

import interFace.sortCollection;

public  class sortCollectionImplement implements sortCollection {
	
	
	/*
	 * (non-Javadoc)
	 * @see interFace.sortCollection#QuickSort(java.lang.Comparable[], int, int)
	 */
	/**
	 * @Description:快排
	 * @CreateTime:20180711
	 * @param Array 待排序数组
	 * @param start 开始位置
	 * @param end 	结束位置
	 * @return
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
	
	/**
	 * 
	 * @Description: 冒泡排序
	 * @date 2018年7月11日下午5:11:50
	 * @return void
	 * @param a a[]
	 * @param b start
	 * @param c end
	 * @param Popstyle aes,des
	 */
	public <T extends Comparable <?super T>> void PopSort(T[] a,int b,int c,String Popstyle) {
		if(b>=c) {
			return;
		}
		int l = c-b;
		String Pop = Popstyle.toLowerCase();
		if(Pop == null || (!Pop.equals("aes") && !Pop.equals("des"))) {
			return;
		}
		for(int i=0;i<l;i++) {
			int count = 0;
			for(int j=0;j<l-i;j++) {
				if(Pop.equals("des")) {
					if(a[b+j].compareTo(a[b+j+1])<0) {
						T temp;
						temp = a[b+j];
						a[b+j] = a[b+j+1];
						a[b+j+1] = temp;
						count++;
					}
				} else if (Pop.equals("aes")) {
					if(a[b+j].compareTo(a[b+j+1])>0) {
						T temp;
						temp = a[b+j];
						a[b+j] = a[b+j+1];
						a[b+j+1] = temp;
						count++;
					}
				}
			}
			if(count == 0) {
				return;
			}
		}
	}
	
	@Override
	public <T extends Comparable <?super T>> void PopSort(T[] a) {
		String tp = "des";
		PopSort(a,0,a.length-1,tp);
	}
	
	public static void main(String[] args) {
		Integer [] a = {19,4,2,56,4,93,10,3,8,48,38};
		int l = a.length;
//		System.out.print("l:"+l+"\n");
		int i=0;
		sortCollectionImplement s= new sortCollectionImplement();
		while(i<l) {
			System.out.print(a[i]+" ");
			i++;
		}
		/*
		 * 快排测试
		 */
		System.out.println("\nquickSort:");
		s.QuickSort(a, 0, l-1);
		i=0;
		while(i<l) {
			System.out.print(a[i]+" ");
			i++;
		}
		System.out.print("\n------------------------------------------------------");
		
		/*
		 * 冒泡测试
		 */
		System.out.println("\ndes popSort:");
		s.PopSort(a, 0, l-1, "des");
		i=0;
		while(i<l) {
			System.out.print(a[i]+" ");
			i++;
		}
		System.out.print("\n------------------------------------------------------");
		
		System.out.println("\naes popSort:");
		s.PopSort(a, 0, l-1, "aes");
		i=0;
		while(i<l) {
			System.out.print(a[i]+" ");
			i++;
		}
		System.out.println("\n------------------------------------------------------");
		
	}
}
