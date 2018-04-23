package StacksRevision;

import java.util.Stack;

import StacksRevision.stackfindmiddleelement.stack;

public class LargestRectAreaInHistogram {

	// our main concern is to keep track of right boundary for each array element
	public static void cal(int ht[])
	{
		int max=-1;
		Stack<Integer> stacks=new Stack<>();
		for(int i=0;i<ht.length;i++)
		{
			if(stacks.isEmpty())
				stacks.push(i);
			
			else if(ht[i]>ht[stacks.peek()])
				stacks.push(i);
			
			else 
			{
				while(!stacks.isEmpty() && ht[stacks.peek()]>ht[i])
				{
					int ele=stacks.pop();
					int rightbound=i;
					int leftbound=stacks.isEmpty()?-1:stacks.peek();
					System.out.println((rightbound-leftbound-1)*ht[ele] + 
							" for centre being " + ht[ele]);
					max=Math.max((rightbound-leftbound-1)*ht[ele],max);
				}
				
				stacks.push(i);
			}
		}
		
		// if some elements are left in the stack then length of array will be their right boundary.
		while(!stacks.isEmpty())
		{
			int ele=stacks.pop();
			int rightboundary=ht.length;
			int leftbound=stacks.isEmpty()?-1:stacks.peek();
			System.out.println((rightboundary-leftbound-1)*ht[ele] + 
					" for centre being " + ht[ele]);
			max=Math.max((rightboundary-leftbound-1)*ht[ele],max);
		}
		System.out.println("max element : " + max);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hist[]={6,2,5,4,5,1,6};
		cal(hist);
		largestAreaHistogram(hist);
		/*
		Stack<Integer> stacks=new Stack<>();
		int area=Integer.MIN_VALUE;
		for(int i=0;i<hist.length;i++)
		{
			if(stacks.isEmpty())
				stacks.push(i);
			else
			{
				if(hist[i]>=hist[stacks.peek()])
					stacks.push(i);
				else
				{
					while(!stacks.isEmpty() && hist[stacks.peek()]>hist[i])
					{
						int ele=stacks.pop();
						// i-stacks.peek()-1 becoz hum na hi left vale pillar ko 
						// include kar rahe ahi aur na hi right vale ko.
						int a=stacks.isEmpty()?i*hist[ele]:(i-stacks.peek()-1)*hist[ele];
						if(a>area)
							area=a;
					}
					stacks.push(i);
				}
			}
		}
		System.out.println(area);
		*/
	}
	
	
}
