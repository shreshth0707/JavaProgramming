package StacksRevision;

import java.util.*;
public class ArrayRepresentPreOrderTraversal {

	public static void main(String[] args) {
		
		int pre[]={40, 30, 35,80, 100};
		System.out.println(check(pre));
		
		// basically ek root ke liye check karan hai,small value aa rhi hai to root change nahi karni,
	//	jaise hi badi value aayi,aage koi bhi root se choti value na aa sake.
		
		int root=Integer.MIN_VALUE;
		Stack<Integer> stacks=new Stack<>();
		stacks.push(Integer.MIN_VALUE);
		for(int i=0;i<pre.length;i++)
		{
			if(pre[i]<root)   // next greater ke bad choti value aa gayi then not a val
			{
				System.out.println("false");
				return;
			}
			while(!stacks.isEmpty() && stacks.peek()<pre[i])
			{
				root=stacks.pop();
			}
			
			stacks.push(pre[i]);	
		}
		System.out.println("true");
		
	}

	
	public static boolean check(int arr[])
	{
		int root=Integer.MIN_VALUE;
		Stack<Integer> s=new Stack<>();
		s.push(Integer.MIN_VALUE);
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<root)
				return false;
			
			while(!s.isEmpty() && s.peek()<arr[i])
			{
				root=s.pop();
			}
			s.push(arr[i]);
		}
		
		return true;
	}
	
}
