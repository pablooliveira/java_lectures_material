public class QSort {

  static void qsort(String l[], int from, int to) {
    if (from >= to) return;
    int i = partition(l,from,to);
    qsort(l, from, i-1);
    qsort(l, i+1, to);
  }

  static int partition(String l[],int from,int to) {
    String pivot = l[from];
    int left = from+1;
    int right = to;
    System.out.println("f:"+from+" t:"+to);
    while(true) {
	// find the next left item bigger than pivot
	while (left <= to && l[left].compareTo(pivot) <= 0)
	    left ++;
	// find the next right item smaller than pivot
	while (right > from && l[right].compareTo(pivot) >= 0)
	    right --;
	if (left >= right) break;
	exch(l,left,right);
    }
    exch(l,from,right);
    return right;
  }

  static void exch(String l[], int i, int j) {
    String tmp = l[i];
    System.out.println(l[i]+"<->"+l[j]);
    l[i] = l[j];
    l[j] = tmp;
  }

  public static void main(String args []){
      qsort(args, 0, args.length-1);
      for (int i = 0; i < args.length; i++) {
	  System.out.println(args[i]);
      }
  }
}
