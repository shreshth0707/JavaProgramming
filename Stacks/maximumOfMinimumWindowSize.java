package StacksRevision;

import java.util.*;
import java.util.Arrays;
 
public class maximumOfMinimumWindowSize {
 
	public static void main(String[] args) {	
		int[] A = {10, 20, 30, 50, 10, 70, 30};
		maximumofminimumOfAllWindow(A);
	}
 
	public static int[] maximumofminimumOfAllWindow(int[] A)
	{
		int n = A.length;
		int[] left = new int[n];	// previous smaller element   -1  if not valid
		int[] right = new int[n];       //Largest Element such that element is less than arr[i]. length if not valid.
 
		
		// calculating previous smaller(nearest smallest element on the left side)
		Stack<Integer> S = new Stack<Integer>();
		for(int i = 0 ;i < n ;i++)
		{	
			while(!S.isEmpty() && A[S.peek()] >= A[i])
				S.pop();
			if(S.isEmpty())
				left[i] = -1;
			else
				left[i] = S.peek();
			S.push(i);
		}
		while(!S.isEmpty())
			S.pop();
		
		// calculating next smaller
		for(int i = n-1;i >=0 ;i--)
		{
			while(!S.isEmpty() && A[S.peek()] >= A[i])
				S.pop();
			if(S.isEmpty())
				right[i] = n;
			else
				right[i] = S.peek();
			S.push(i);
		}
		System.out.println("Left Array : ");
		printArr(left);
		System.out.println("Right Array : ");
		printArr(right);
 
		int[] len = new int[left.length];
 
		for(int i = 0 ;i < A.length ;i++)
			len[i] = right[i] - left[i] - 1;
		System.out.println("Length which indicates the length that index i is smallest in.");
		printArr(len);
		int[] ans = new int[n+1];
 
		for(int i = n-1; i >= 0 ; i--)
			ans[len[i]] = Math.max(ans[len[i]], A[i]);
 
		for(int i = n-1 ; i >=0; i--)
			ans[i] = Math.max(ans[i], ans[i+1]);
 
		System.out.println("Array which is the answer : ");
		printArr(Arrays.copyOfRange(ans, 1, ans.length));
 
		return Arrays.copyOfRange(ans, 1, ans.length);
	}
 
	public static void printArr(int[] A)
	{
		for(int i =0; i < A.length ;i++)
			System.out.print(A[i] +" ");
		System.out.println();
	}
}

 