package arraysRevision;

import java.util.Scanner;

public class CountSubarrayMaxElementGreaterThanK {

	public static void main (String[] args)
	{
		Scanner  s=new Scanner(System.in);
		int test=s.nextInt();
		while(test>0)
		{
			int n=s.nextInt();
			int k=s.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();

			int count=0;
			int i=0;
			while(i<arr.length)
			{
				
				if(arr[i]>k)
				{
					i++;
				}
				else
				{
					int c=0;
					while(i<n && arr[i]<=k)
					{
						c++;
						i++;
					}
					count+=(c*(c+1))/2;
				}
			}
			int val=(arr.length*(arr.length+1))/2 -count;
			System.out.println(val);
			test--;
		}

	}

}
