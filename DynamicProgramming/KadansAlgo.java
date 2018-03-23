package DynamicProgramming;

public class KadansAlgo {

	public static int maxSumSubarray(int array[])
	{
		int max_so_far=array[0];
		int max_index=array[0];
		
		for(int i=1;i<array.length;i++)
			{
			max_index=Math.max(array[i], max_index+array[i]);
			max_so_far=Math.max(max_index, max_so_far);
			}
				
		return max_so_far;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={-2,-3,	4,-1,-2,1,5,-3};
		System.out.println(maxSumSubarray(array));
		
	}

}
