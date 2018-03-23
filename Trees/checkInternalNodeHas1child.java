package TreeRevision;

public class checkInternalNodeHas1child {

	
	public static boolean check(int arr[])
	{
		if(arr.length<=1)
			return true;
		
		int max=Math.max(arr.length-1, arr.length-2);
		int min=Math.min(arr.length-1, arr.length-2);
		
		for(int i=arr.length-3;i>=0;i--)
		{
			if(arr[i]>min || arr[i]<max)
			{
				return false;
			}
			max=Math.max(max, arr[i]);
			min=Math.min(min, arr[i]);
		}
		return true;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {20, 10, 11, 13, 12};
		System.out.println(check(arr));
		
	}

}
