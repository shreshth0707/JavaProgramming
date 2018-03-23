package DynamicProgramming;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {

	
	public static void lis(int array[])      //o(n^2)
	{
		int value[]=new int[array.length];
		for(int i=0;i<array.length;i++)
			value[i]=1;
		
		int i=1,j=0;
		for(i=1;i<value.length;i++)
		{
			for(j=0;j<array.length;j++)
			{
			if(array[j]<array[i])
			{
				value[i]=Math.max(value[i], value[j]+1);
			}
			}
		}
		int max=-1;
		for(int ii:value)
			if(ii>max)
			max=ii;
		
		System.out.println(max);
	}
	
	
	public static void lisBest(int array[])
	{
		int len=1;
		int s[]=new int[array.length];
		s[0]=array[0];
		
		for(int i=1;i<array.length;i++)
		{
			if(array[i]<s[0])
			{// do nothing
			}
			else if(array[i]>s[len-1])
			{
				s[len]=array[i];
				len++;
			}
			
			else 
			{
				int index=BSear(s,0,len-1,array[i]);
				s[index]=array[i];
			}	
		}
		
		System.out.println(len);
	}
	
	public static int BSear(int s[],int start,int end,int ele)
	{
		if(start>end)
			return  -1;
		else if(start==end)
			return start;
		
		else
		{
			while(start<end)
			{
				int m=start+((end-start)/2);
				if(s[m]<ele)
					start=m+1;
				else if(s[m]>ele && s[m-1]<ele)
				{
					return m;
				}
				else
				{
					end=m-1;
				}
			}
		}
		return start;
	}
	
	
	
	
	
	
	
	
	
	// basically a binary search.
	// left end is -1 and right end is len-1 in the start.
	static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)    //  impt...
        {
            int m = l + (r - l)/2;   // middle
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
 
    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
        
        for(int i=0;i<len;i++)
        	System.out.println(tailTable[i]);
        return len;
    }
 
 
    
    
    // Driver program to test above function
    public static void main(String[] args)
    {
    	int A[]={3,4,-1,5,8,2,3,12,7,9,10};
      //  int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
    	lisBest(A);
    	/*
        int n = A.length;
        System.out.println("L"
        		+ "length of Longest Increasing Subsequence is "+
                            LongestIncreasingSubsequenceLength(A, n));
                            */
    }
}
