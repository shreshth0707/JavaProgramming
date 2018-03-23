package DynamicProgramming;

import java.util.ArrayList;

public class UglyNumbers {

	public static void ugly(int j)
	{
		int ugly[]=new int[j+1];
		ugly[0]=1;
		int i2=0,i3=0,i5=0;
		int next_2=ugly[i2]*2,next_3=ugly[i3]*3,next_5=ugly[i5]*5;
		
		for(int i=1;i<=j;i++)
		{
			int ans=Math.min(next_2, Math.min(next_3, next_5));
			ugly[i]=ans;
			if(ans==next_2)
			{
				i2++;
				next_2=ugly[i2]*2;
				
			}
			if(ans==next_3)
			{
				i3++;
				next_3=ugly[i3]*3;
			}
			if(ans==next_5)
			{
				i5++;
				next_5=ugly[i5]*5;
			}
			
		}
		
		System.out.println(ugly[j-1]);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ugly(150);
	}

}
