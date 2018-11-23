package interFace;

public interface sortCollection {
	public <T extends Comparable<? super T>> void QuickSort(T[] Array,int start,int end);
	public <T extends Comparable<? super T>> void PopSort(T[] a,int b,int c,String Popstyle);
	public <T extends Comparable<? super T>> void PopSort(T[] a);
	public <T extends Comparable<? super T>> void SelectSort(T[] a,int b,int c,String sortstyle);
	public <T extends Comparable<? super T>> void SelectSort(T[] a);
	public <T extends Comparable<? super T>> void InsertionSort(T[] a,int b,int c,String sortstyle);
	public <T extends Comparable<? super T>> void InsertionSort(T[] a);
	public <T extends Comparable<? super T>> void ShellSort(T[] a,int b,int c, String sortstyle);
	public <T extends Comparable<? super T>> void ShellSort(T[] a);
}
