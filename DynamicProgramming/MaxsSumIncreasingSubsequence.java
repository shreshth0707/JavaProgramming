package DynamicProgramming;

import java.awt.List;
import java.lang.reflect.Array;
import java.net.NetworkInterface;
import java.util.ArrayList;

public class MaxsSumIncreasingSubsequence {

	public static void maxSumIncSubseq(int array[])
	{
		int maxvalue[]=new int[array.length];
		for(int i=0;i<maxvalue.length;i++)
			maxvalue[i]=array[i];
		
		int actualseq[]=new int[array.length];
		for(int i=0;i<actualseq.length;i++)
		actualseq[i]=i;
		
		for(int i=1;i<array.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				//if a increasing subsequence exist with sum greater than current,then replace.
				if(array[j]<array[i])
				{
					if(maxvalue[i]<maxvalue[j] + array[i]){
					maxvalue[i]=maxvalue[j]+array[i];
					actualseq[i]=j;     // actual sequence will store from where it is coming.
					}					
				}
			}
		}
		ArrayList<Integer> ll=new ArrayList<>();
	
	
		
		int max=Integer.MIN_VALUE;
		int index=-1;
		for(int i=0;i<array.length;i++)
			if(maxvalue[i]>max){
				max=maxvalue[i];
				index=i;
			}
		
		System.out.println(max);
		
		System.out.println(array[index]);
		max-=array[index];
		while(max>0)
		{
			int nindex=actualseq[index];
			System.out.println(array[nindex]);
			max=max-array[nindex];
			index=nindex;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={4,6,1,3,8,4,6};
		maxSumIncSubseq(array);
	}

}
