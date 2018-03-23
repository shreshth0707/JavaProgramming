package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WaysToConstructBuilding {

	public static ArrayList<String> waysToConsruct(double n,ArrayList<String> list)
	{

		if(n==0)
			return list;
		else
		{
			ArrayList<String> list1=new ArrayList<>();
			for(String s:list)
			{
				if(s.charAt(0)=='B')
				{
					String s1="S" + s;
					list1.add(s1);
				}
				else
				{
					String s1="S" +s;
					String s2="B" +s;
					list1.add(s1);
					list1.add(s2);
				}
			}
		return waysToConsruct(n-1, list1);
		}
		
	}
	
						// dp
	public static int count(int n)
	{
		// first row means ending with bricks.
		// second row means ending with space.
		int dp[][]=new int[2][n+1];
		dp[0][1]=1;
		dp[1][1]=1;
		
		for(int i=2;i<=n;i++)
		{
			dp[1][i]=dp[1][i-1]+dp[0][i-1];
			dp[0][i]=dp[1][i-1];
		}
		
		return (dp[0][n]+dp[1][n])*(dp[0][n]+dp[1][n]);
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> list=new ArrayList<>();
//		list.add("S");
//		list.add("B");
//		list=waysToConsruct(3-1, list);
//		
//		for(String s:list)
//			System.out.println(s + "");
//		
//		System.out.println(Math.pow(list.size(),2));
		
		
		System.out.println(count(3));
	}

}
