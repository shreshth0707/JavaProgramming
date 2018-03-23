package DynamicProgramming;

public class TiltingProblem {

	public static int tilt(int n)
	{
		int array[]=new int[n+1];
		array[0]=0;
		array[1]=1;
		array[2]=2;
		for(int i=3;i<=n;i++)
			array[i]=array[i-1]+array[i-2];
		
		return array[n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tilt(4));
	}

}
