package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeProblem {

	
	public static void coinchange(int total,int coins[])
	{
		int array[][]=new int[coins.length][total+1];
		for(int i=0;i<coins.length;i++)
			array[i][0]=1;
		
		for(int i=0;i<=total;i++)
			array[0][i]=1;
		
		for(int i=1;i<coins.length;i++)
		{
			for(int j=1;j<=total;j++)
			{
				if(j>=coins[i])
				{
					array[i][j]=array[i-1][j] + array[i][j-coins[i]];
				}
				else
					array[i][j]=array[i-1][j];
			}
		}
		System.out.println(array[coins.length-1][total]);
	}
	
	
	
	// better solution o(n) extra space
	public static int changeoptimal(int total,int coins[])
	{
		int matrix[]=new int[total+1];
		for(int i=0;i<matrix.length;i++)
		{
			matrix[i]=0;
		}
		matrix[0]=1;
		
		for(int i=0;i<coins.length;i++)
		{
			for(int j=coins[i];j<matrix.length;j++)
				matrix[j]+=matrix[j-coins[i]];
		}
		return matrix[matrix.length-1];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int coins[]=new int[m];
		for(int i=0;i<m;i++)
			coins[i]=s.nextInt();
		Arrays.sort(coins);
		System.out.println(changeoptimal(n, coins));
	}
}
