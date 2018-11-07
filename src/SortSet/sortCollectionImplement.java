package SortSet;

import interFace.sortCollection;

class sortCollectionImplement {
	private class sortCollectionImplementimp implements sortCollection {

		/*
		 * (non-Javadoc)
		 * 
		 * @see interFace.sortCollection#QuickSort(java.lang.Comparable[], int, int)
		 */
		/**
		 * @Description:����
		 * @CreateTime:20180711
		 * @param Array
		 *            ����������
		 * @param start
		 *            ��ʼλ��
		 * @param end
		 *            ����λ��
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
				while (j > i && Array[j].compareTo(key) >= 0) { // �ұ��ҳ���keyС��
					j--;
				}
				if (i < j) {
					Array[i] = Array[j];
					i++;
				}

				while (i < j && Array[i].compareTo(key) <= 0) { // ����ҳ���key���
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
		 * @Description: ð������
		 * @date 2018��7��11������5:11:50
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
		 * @Description: ð������(��a[]����des����)
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
		 * @Description: ѡ������
		 * @date 2018��11��7������5:58:22
		 * @return void
		 * @param a ��������
		 * @param b start location
		 * @param c	end location
		 * @param sortstyle "aes" or "des"
		 */
		private <T extends Comparable<? super T>> void SelectSort(T[] a,int b,int c,String sortstyle) {
			if (b >= c) {
				return;
			}
			int l = c-b;
			String selects = sortstyle.toLowerCase();
			if (selects==null || (!selects.equals("aes")) && (!selects.equals("des"))) {
				return;
			}
			for(int i=0;i<l-1;i++) {
				int min,max;
				if(selects.equals("aes")) {
					min = b;
					for(int j=i+1;j<l;j++) {
						
					}
				}
				else if (selects.equals("des")) {
					max = b;
				}
			}
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