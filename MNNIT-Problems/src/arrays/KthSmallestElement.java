package arrays;

public class KthSmallestElement {
	private int[] maxHeap;
	private int size;
	
	public int findkth(int[] a, int k)
	{
		maxHeap = new int[k];
		for(int i=0;i<k;i++)
			insertHeap(a[i]);
		for(int i=k;i<a.length;i++)
		{
			if(maxHeap()>a[i])
			{
				maxHeap[0] = a[i];
				heapify(0);
			}
		}
		return maxHeap();
	}
	
	private int maxHeap()
	{
		return maxHeap[0];
	}
	
	private void insertHeap(int i)
	{
		maxHeap[size++] = i;
		heapify(size-1);
		
	}
	
	public void heapify(int i)
	{
		int left = 2*i +1, right= 2*i+2, parent = (i-1)/2,largest = i;
		if(maxHeap[i]>maxHeap[parent]&&parent>=0)
			{
			exchange(i,parent);
			heapify(parent);
			}
		else {
			
			if(right<size&&maxHeap[largest]<maxHeap[right])
				largest = right;
			if(left<size&&maxHeap[largest]<maxHeap[left])
				largest = left;
			if(largest!=i)
			{
				exchange(i,largest);
				heapify(largest);
			}
				
		}
	}
	
	private void exchange(int i, int j)
	{
		int temp = maxHeap[i];
		maxHeap[i] = maxHeap[j];
		maxHeap[j] = temp;
	}

	public static void main(String[] args) 
	{
		int k = 3;
		int[] arr = { 1,2,4,5,-6,-9,7};
		KthSmallestElement kk = new KthSmallestElement();
		System.out.print(kk.findkth(arr, k));
		

	}

}
