package interFace;

public interface sortCollection {
	public <T extends Comparable <?super T>> void QuickSort(T[] Array,int start,int end);
	public <T extends Comparable <?super T>> void PopSort(T[] a,int b,int c,String Popstyle);
	public <T extends Comparable <?super T>> void PopSort(T[] a);
}
