package StacksRevision;

import java.util.Stack;

public class stockSpanProblem {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[]={100,80,60,70,60,75,85};
		int span[]=new int[prices.length];
		Stack<Integer> stacks=new Stack<>();
		span[0]=1;
		stacks.push(0);
		for(int i=1;i<prices.length;i++)
		{
			if(stacks.isEmpty())
			{
				span[i]=1;
			}
			else{
			while(!stacks.isEmpty() && prices[stacks.peek()]<prices[i])
			{
				stacks.pop();
			}
			span[i]=i-stacks.peek();
			stacks.push(i);
			}
		}
		
		for(int i:span)
			System.out.print(i + " ");
			
	}
}
