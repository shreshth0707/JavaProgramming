package arraysRevision;

public class NoOfFBTwithNodeProduct {
//  Given an array of n integers, each integer is greater than 1. 
//	The task is to find the number of Full binary tree from the given integers,
//	such that each non-node leaf node value is the product of its children value. 
//	Given that, each integer can be used multiple times in a full binary tree.
	
	
	public static void main(String[] args) {
		int array[]={2,3,4,6};
		int n=array.length;
		int maximum=Integer.MIN_VALUE;
		int minimum=Integer.MAX_VALUE;
		for(int i:array)
		{
			if(i>maximum)
				maximum=i;
			if(i<minimum)
				minimum=i;
		}
		
		int mark[]=new int[maximum+2];
		int value[]=new int[maximum+2];
		for(int i=0;i<n;i++)
		{
			mark[array[i]]=1;     // marking ki exist karta hai no need to search in the array.
			value[array[i]]=1;    //har value se ek fbt to banega hi (1 node ka)
		}
		int ans=0;
		for(int i=minimum;i<=maximum;i++){
			if(mark[i]==1)  //  element is present in the array.// we have found the first factor now find 2nd factor.
			{
		//  find the multiples of arr[i] which are less than max value and also less than its square
			for(int j=i+i ;j<=maximum && j/i<=i;j=j+i)
			{
				if(mark[j]==1  && mark[j/i]==1)   // i is the first factor and j/i is the 2nd factor.j is the product that serves as root.
				{
					// value =all combination of left child with right child.
					value[j]=value[j] + (value[i] * value[j/i]);
					
					// if the 2 child are not same then one more orientation.
					if(i!=(j/i))
						value[j]=value[j] + (value[i] * value[j/i]);
				}
			}
			}
			ans=ans+value[i];
		}
		System.out.println(ans);
	}

}
