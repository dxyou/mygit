package SortSet;

import interFace.sortCollection;

class sortCollectionImplement {
	private class sortCollectionImplementimp implements sortCollection {

		
		/**
		 * @Description:快排
		 * @CreateTime:20180711
		 * @param Array
		 *            待排序数组
		 * @param start
		 *            开始位置
		 * @param end
		 *            结束位置
		 * @return
		 */
		public <T extends Comparable<? super T>> void QuickSort(T[] Array, int start, int end) {
			if (start >= end) {
				return;
			}
			int i = start;
			int j = end;
			T key = Array[i];
			while (i < j) {
				while (j > i && Array[j].compareTo(key) >= 0) { // 右边找出比key小的
					j--;
				}
				if (i < j) {
					Array[i] = Array[j];
					i++;
				}

				while (i < j && Array[i].compareTo(key) <= 0) { // 左边找出比key大的
					i++;
				}
				if (i < j) {
					Array[j] = Array[i];
					j--;
				}
			}
			Array[i] = key; // i==j

			this.QuickSort(Array, start, i - 1);

			this.QuickSort(Array, i + 1, end);
		}

		/**
		 * 
		 * @Description: 冒泡排序
		 * @date 2018年7月11日下午5:11:50
		 * @return void
		 * @param a
		 *            a[]
		 * @param b
		 *            start
		 * @param c
		 *            end
		 * @param Popstyle
		 *            aes,des
		 */
		public <T extends Comparable<? super T>> void PopSort(T[] a, int b, int c, String Popstyle) {
			if (b >= c) {
				return;
			}
			int l = c - b;
			String Pop = Popstyle.toLowerCase();
			if (Pop == null || (!Pop.equals("aes") && !Pop.equals("des"))) {
				return;
			}
			for (int i = 0; i < l; i++) {
				int count = 0;
				for (int j = 0; j < l - i; j++) {
					if (Pop.equals("des")) {
						if (a[b + j].compareTo(a[b + j + 1]) < 0) {
							T temp;
							temp = a[b + j];
							a[b + j] = a[b + j + 1];
							a[b + j + 1] = temp;
							count++;
						}
					} else if (Pop.equals("aes")) {
						if (a[b + j].compareTo(a[b + j + 1]) > 0) {
							T temp;
							temp = a[b + j];
							a[b + j] = a[b + j + 1];
							a[b + j + 1] = temp;
							count++;
						}
					}
				}
				if (count == 0) {
					return;
				}
			}
		}

		/**
		 * @Description: 冒泡排序(对a[]进行des排序)
		 * @return void
		 * @param  a[]
		 * @param  des
		 */
		@Override
		public <T extends Comparable<? super T>> void PopSort(T[] a) {
			String tp = "des";
			PopSort(a, 0, a.length - 1, tp);
		}

		/**
		 * 
		 * @Description: 选择排序
		 * @date 2018年11月7日下午5:58:22
		 * @return void
		 * @param a 待排内容
		 * @param b start location
		 * @param c	end location
		 * @param sortstyle "aes" or "des"
		 */
		public <T extends Comparable<? super T>> void SelectSort(T[] a,int b,int c,String sortstyle) {
			if (b >= c) {
				return;
			}
			int l = c-b;
			String selects = sortstyle.toLowerCase();
			if (selects==null || (!selects.equals("aes")) && (!selects.equals("des"))) {
				return;
			}
			int min,max;
			for(int i=0;i<l;i++) {
				if(selects.equals("aes")) {
					min = b+i;
					for(int j=i+1;j<=l;j++) {
						if(a[b+j].compareTo(a[min])<0) {
							min = b+j;
						}
					}
					if(min != b+i) {
						Swap(a, min, b+i);
					}
				}
				else if (selects.equals("des")) {
					max = b+i;
					for(int j=i+1;j<=l;j++) {
						if(a[b+j].compareTo(a[max])>0) {
							max = b+j;
						}
					}
					if(max != b+i) {
						Swap(a, max, b+i);
					}
				}
			}
		}
		
		/**
		 * @Description: 选择排序(des)
		 * @param a 待排内容
		 * 
		 */
		public <T extends Comparable<? super T>> void SelectSort(T[] a) {
			String tp = "des";
			SelectSort(a, 0, a.length - 1, tp);
		}
		
		
		/**
		 * @Description: 插入排序
		 * @return void
		 * @param a 待排内容
		 * @param b start location
		 * @param c	end location
		 * @param sortstyle "aes" or "des"
		 */
		public <T extends Comparable<? super T>> void InsertionSort(T[] a,int b,int c,String sortstyle) {
			if (b >= c) {
				return;
			}
			int l = c-b;
			String inserts = sortstyle.toLowerCase();
			if (inserts==null || (!inserts.equals("aes")) && (!inserts.equals("des"))) {
				return;
			}
			if(inserts.equals("aes")) {
				for(int i=1;i<=l;i++) { 
					T get = a[b+i];//新获取的数据
					int j = i-1;
					while(j>=0 && (get.compareTo(a[b+j])<0)) {//与已排好序的内容作比较，如果小于将原排好序的那个数据右移一个
						a[b+j+1] = a[b+j];
						j--;//左移进行下个比较
					}
					a[b+j+1] = get;
				}
			}else if(inserts.equals("des")) {
				for(int i=1;i<=l;i++) {
					T get = a[b+i];
					int j = i-1;
					while(j>=0 && (get.compareTo(a[b+j])>0)) {
						a[b+j+1] = a[b+j];
						j--;
					}
					a[b+j+1]= get;
				}
			}
		}
		
		/**
		 * @Description: 插入排序(des)
		 * @param a 待排内容
		 */
		@Override
		public <T extends Comparable<? super T>> void InsertionSort(T[] a) {
			String tp = "des";
			InsertionSort(a, 0, a.length - 1, tp);
		}

		/**
		 * 
		 * @Description: Shell排序
		 * @date 2018年11月23日下午3:20:47
		 * @return void
		 * @param a []待排内容
		 * @param b start location
		 * @param c end location
		 * @param shellmod "aes"or"des"
		 */
		public <T extends Comparable<? super T>> void ShellSort(T[] a, int b,int c,String shellmod) {
			if (b >= c) {
				return;
			}
			int l = c-b;
			String shells = shellmod.toLowerCase();
			if (shells==null || (!shells.equals("aes")) && (!shells.equals("des"))) {
				return;
			}
			int ins = 0;
			while(ins<=l) {
				ins = ins*3+1;//设置步长
			}
			while(ins>=1) {
//				System.out.println("\nins = "+ins+" bengin\n");
				for(int i=b+ins;i<=b+l;i++) {//从ins+b开始进行插入排序，顺序为第一组第一个，第二组第一个，。。。
					int j=i-ins;
					T get = a[i];
					if (shells.equals("aes")) {
						while (j >= b && a[j].compareTo(get) > 0) {
							a[j + ins] = a[j];//右移步长个单位
							j = j - ins;
						}
					} else if (shells.equals("des")) {
						while (j >= b && a[j].compareTo(get) < 0) {
							a[j + ins] = a[j];
							j = j - ins;
						}
					}
					a[j+ins] = get;
//					排序顺序
//					System.out.println("\nin ins \n");
//					for(int k = 0;k<=l;k++) {
//						System.out.print(a[b+k]+" ");
//					}
//					System.out.println("\n");
				}
//				相应步长进行一次排序后的结果
//				System.out.println("\nins = "+ins+" end\n");
//				for(int k = 0;k<=l;k++) {
//					System.out.print(a[b+k]+" ");
//				}
				ins=(ins-1)/3;
			}
		}
		
		/**
		 * @Description: Shell排序(des)
		 * @param a 待排内容
		 */
		@Override
		public <T extends Comparable<? super T>> void ShellSort(T[] a) {
			String tp = "des";
			ShellSort(a, 0, a.length - 1, tp);
		}
		
		
		<T extends Comparable<? super T>> void Swap(T[] a,int i,int j) {
			T temp;
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	
	sortCollectionImplementimp newSortCollection() {
		return new sortCollectionImplementimp();
	}
}