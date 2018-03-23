package TreeRevision;

public class checkForIdenticalBST {
	
	
	public static boolean check(int a[],int  b[],int i1,int i2,int n,int min,int max)
	{
		int j,k;
		
		// find the first key in range for first array
		for(j=i1;j<n;j++)
		{
			if(a[j]>min && a[j]<max)
				break;
		}
		// find the first key in range for second array.
		for(k=i2;k<n;k++)
		{
			if(b[k]>min && b[k]<max)
				break;
		}
		
		// no element in range for both ie:both will be null
		if(k==n && j==n)
			return true;
		
		// either key in one of the array is null or key is not same
		if (((j==n)^(k==n)) || a[j]!=b[k])
		       return false;
		 
		
		return check(a, b, j+1, k+1, n, min, a[j]) &&     // for the lefy subtree
				check(a, b, j+1, k+1, n, a[j], max);		// for the right subtree
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		   int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
		   System.out.println(check(a, b, 0, 0, a.length, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

}
