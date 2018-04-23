package StacksRevision;

import java.util.Stack;

import javax.xml.soap.SAAJResult;

public class MergeOverlapingIntervals {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int first[]={1,2,5,6};
		int second[]={3,4,7,8};
		Stack<Integer> stacks=new Stack<>();
		for(int i=0;i<first.length;i++)
		{	
			if(stacks.isEmpty() || stacks.peek()<first[i])
				stacks.push(first[i]);
			else
			{
				while(!stacks.isEmpty() && stacks.peek()>first[i])
				{
					stacks.pop();
				}
			}
			
			if(stacks.isEmpty() || stacks.peek()<second[i])
				stacks.push(second[i]);
			else
			{
				while(!stacks.isEmpty() && stacks.peek()>second[i])
				{
					stacks.pop();
				}
			}
		}
		while(!stacks.isEmpty())
		{
			int seconds=stacks.pop();
			int firsts=stacks.pop();
			System.out.println(firsts+","+ seconds);
		}
	}

}
