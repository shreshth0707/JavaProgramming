package TreeRevision;

public class NoFullBinaryTreeProductChild {

	
	public static int calc(int arr[])
	{
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		// calculate max and min element of array for range
		for(int i:arr)
		{
			max=Math.max(max, i);
			min=Math.min(min,i);
		}
		
		//  mark will calculate if i is present in array or not.
		// value will store no of full bt with this value as root.
		int mark[]=new int[max+2];
		int value[]=new int[max+2];
		int ans=0;
		
		for(int i:arr)
		{
			mark[i]=1;
			value[i]=1;
		}
		
		for(int i=min;i<=max;i++)
		{
			if(mark[i]==1){
			// j/i<=i becoz jo case rhe gaye hai vo aage cover ho jaenge.
			for(int j=2*i;j<=max && j/i<=i;j=j+i)
			{
				if(mark[j]!=1)   // j is present
				continue;
				
				value[j]=value[j] +(value[i]*value[j/i]);
				
				// child are not same so can be swapped
				if(j/i!=i)
				{
					value[j]=value[j] +(value[i]*value[j/i]);
				}
			}
			}

			ans+=value[i];
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[]={2,3,4,6};
		 System.out.println(calc(arr));

	}

}
