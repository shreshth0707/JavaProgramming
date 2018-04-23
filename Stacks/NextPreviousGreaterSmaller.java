package StacksRevision;

import java.util.Arrays;
import java.util.Stack;

import StacksRevision.stackfindmiddleelement.stack;

public class NextPreviousGreaterSmaller {

	public static void nextGreater(int array[])
	{
		int left[]=new int[array.length];
		Arrays.fill(left, -1);
		
		Stack<Integer> stacks=new Stack<>();
		stacks.push(0);
		
		for(int i=1;i<array.length;i++)
		{
			while(!stacks.isEmpty() && array[stacks.peek()]<array[i])
			{
				left[stacks.peek()]=i;
				stacks.pop();
			}
			
			stacks.push(i);
		}
		left[left.length-1]=-1;
		
		
		for(int i=0;i<left.length;i++)
		{
			System.out.print(left[i] + " ");
		}
		
	}
	
	public static void nextSmaller(int array[])
	{
		int right[]=new int[array.length];
		Arrays.fill(right, -1);
		
		Stack<Integer> stacks=new Stack<>();
		stacks.push(1);
		
		for(int i=1;i<array.length;i++)
		{
			while(!stacks.isEmpty() &&  array[stacks.peek()]>array[i])
			{
				right[stacks.peek()]=i;
				stacks.pop();
			}
			
			stacks.push(i);
		}
		
		for(int i=0;i<right.length;i++)
		{		
			System.out.print(right[i] +" ");
		}
		
	}
	
	public static void previousGreater(int array[])
	{
		
		int left[]=new int[array.length];
		Arrays.fill(left, -1);
		
		Stack<Integer> stacks=new Stack<>();
		stacks.push(array.length-1);
		
		for(int i=array.length-2;i>=0;i--)
		{
			while(!stacks.isEmpty() && array[stacks.peek()]<array[i])
			{
				left[stacks.peek()]=i;
				stacks.pop();
			}
			
			stacks.push(i);
		}
	//	left[left.length-1]=-1;
		
		
		for(int i=0;i<left.length;i++)
		{
			System.out.print(left[i] + " ");
		}
		
	}
	
	public static void previousSmaller(int array[])
	{
		int right[]=new int[array.length];
		Arrays.fill(right, -1);
		
		Stack<Integer> stacks=new Stack<>();
		stacks.push(array.length-1);
		
		for(int i=array.length-1;i>=0;i--)
		{
			while(!stacks.isEmpty() &&  array[stacks.peek()]>array[i])
			{
				right[stacks.peek()]=i;
				stacks.pop();
			}
			
			stacks.push(i);
		}
		
		for(int i=0;i<right.length;i++)
		{
				
			System.out.print(right[i] +" ");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={10,20,30,50,10,70,30};
		nextGreater(array);
		System.out.println();
		nextSmaller(array);
		System.out.println();
		previousGreater(array);
		System.out.println();
		previousSmaller(array);
	}

}
