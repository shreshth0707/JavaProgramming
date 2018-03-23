package DynamicProgramming;

public class EggDroppingProblem {

	public static void eggDroppingProblem(int eggs,int floors)
	{
		int matrix[][]=new int[eggs+1][floors+1];
		for(int i=1;i<=floors;i++)
		{
			matrix[1][i]=i;
		}

		//i denotes the no of eggs.
		for(int i=2;i<=eggs;i++)
		{
			// j denotes the number of floors.
			for(int j=1;j<=floors;j++)
			{
				// eggs>floor copy the previous row entry
				if(i>j){
					int no=matrix[i-1][j];
					matrix[i][j]=no;
				}
					else{
					int min=Integer.MAX_VALUE;
					for(int k=1;k<=j;k++)           // kth floor se drop kiya hai.
					{
						int no=1 + Math.max(matrix[i-1][k-1], matrix[i][j-k]);
						if(no<min)
							min=no;
					}
					matrix[i][j]=min;
				}

			}
		}

		System.out.println( matrix[eggs][floors]);;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eggDroppingProblem(2, 10);
	}

}

