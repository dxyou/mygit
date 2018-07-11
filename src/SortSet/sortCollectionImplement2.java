package SortSet;

//import interFace.sortCollection;

public  class sortCollectionImplement2 {
	/**
	 * @Description: 快排
	 * @param Array
	 * @param start
	 * @param end
	 */
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
	
	/**
	 * @Description: 冒泡
	 * @param a int[]
	 * @param b start
	 * @param c	end
	 * @param Popstyle aes,des
	 */
	public static void PopSort(int [] a,int b,int c,String Popstyle) {
		if(b>=c) {
			return;
		}
		int l = c-b;
		String Pop = Popstyle.toLowerCase();
//		System.out.print(Pop+"\n");
		if(Pop == null || (!Pop.equals("aes") && !Pop.equals("des"))) {
			return;
		}
		for(int i=0;i<l;i++) {
			int count = 0;
			for(int j=0;j<l-i;j++) {
				if(Pop.equals("des")) {
					if(a[b+j]<a[b+j+1]) {
						int temp;
						temp = a[b+j];
						a[b+j] = a[b+j+1];
						a[b+j+1] = temp;
						count++;
					}
				} else if (Pop.equals("aes")) {
					if(a[b+j]>a[b+j+1]) {
						int temp;
						temp = a[b+j];
						a[b+j] = a[b+j+1];
						a[b+j+1] = temp;
						count++;
					}
				}
			}
			System.out.println("count: "+count);
			if(count == 0) {
				return;
			}
		}
	}
	
	/**
	 * 
	 * @Description: TODO
	 * @date 2018年7月11日下午5:10:48
	 * @return void
	 * @param a
	 */
	public static void PopSort(int [] a) {
		String tp = "des";
		PopSort(a,0,a.length-1,tp);
	}
	
	public static void main(String[] args) {
//		int [] a = {19,4,2,56,4,93,10,3,8,48,38};
		int [] a = {100,2,3,4,5,46,17,18,28,48,68};
		int l = a.length;
//		System.out.print("l:"+l+"\n");
		int i=0;
//		QuickSort(a, 0, l-1);
//		PopSort(a);
		PopSort(a, 0, l-1,"AES");
		while(i<l) {
			System.out.print(a[i]+" ");
			i++;
		}
	}
}
