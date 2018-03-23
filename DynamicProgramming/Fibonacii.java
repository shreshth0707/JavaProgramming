package DynamicProgramming;


import java.util.*;
public class Fibonacii {
	
	
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int array[]=new int[n+1];
		array[1]=0;
		array[2]=1;
		for(int i=3;i<=n;i++)
			array[i]=array[i-1] + array[i-2];
		
		System.out.println(array[n]);
	}

}
