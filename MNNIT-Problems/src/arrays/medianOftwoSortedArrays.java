package arrays;

public class medianOftwoSortedArrays {

	public static void main(String[] args)
	{
		 int ar1[] = {1, 2, 3, 6};
		    int ar2[] = {4, 6, 8, 10};
		    System.out.print(getMedian(ar1,ar2,0,0,4));

	}

	private static int getMedian(int[] a, int[] b, int starta,int startb,int n) 
	{
		if(n==1)
			return (a[starta]+b[startb])/2;
		int meda, medb;
		meda = a[(starta+n)/2];
		medb = b[(startb+n)/2];
		
		if(meda>medb)
			return getMedian(a,b,starta,startb+n/2,n/2);
		else
			return getMedian(a,b,startb+n/2,startb,n/2);
	}

}
