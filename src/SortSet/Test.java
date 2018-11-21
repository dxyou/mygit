package SortSet;

import interFace.sortCollection;

public class Test {

	public static void main(String[] args) {
		Integer[] a = { 19, 4, 2, 56, 4, 93, 10, 3, 8, 48, 38 };
		int l = a.length;
		// System.out.print("l:"+l+"\n");
		int i = 0;
		sortCollectionImplement si = new sortCollectionImplement();
		sortCollection s = si.newSortCollection();
		while (i < l) {
			System.out.print(a[i] + " ");
			i++;
		}
		/*
		 * ¿ìÅÅ²âÊÔ
		 */
		System.out.println("\nquickSort:");
		s.QuickSort(a, 0, l - 1);
		i = 0;
		while (i < l) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.print("\n------------------------------------------------------");

		/*
		 * Ã°ÅÝ²âÊÔ
		 */
		System.out.println("\n\ndes popSort:");
		s.PopSort(a, 0, l - 1, "des");
		i = 0;
		while (i < l) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.print("\n------------------------------------------------------");

		System.out.println("\naes popSort:");
		s.PopSort(a, 0, l - 1, "aes");
		i = 0;
		while (i < l) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.println("\n------------------------------------------------------");

		/*
		 * Ñ¡ÔñÅÅÐò
		 */
		System.out.println("\ndes selectSort:");
		s.SelectSort(a, 0, l-1, "des");
		i=0;
		while(i<l) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.print("\n------------------------------------------------------");
		
		System.out.println("\naes selectSort:");
		s.SelectSort(a, 0, l - 1, "aes");
		i = 0;
		while (i < l) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.println("\n------------------------------------------------------");
		
		/*
		 * ²åÈëÅÅÐò
		 */
		System.out.println("\ndes InsertionSort:");
		s.InsertionSort(a, 0, l-1, "des");
		i=0;
		while(i<l) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.print("\n------------------------------------------------------");
		
		System.out.println("\naes InsertionSort:");
		s.InsertionSort(a, 0, l - 1, "aes");
		i = 0;
		while (i < l) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.println("\n------------------------------------------------------");
	}

}
