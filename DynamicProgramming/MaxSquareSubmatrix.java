package DynamicProgramming;

public class MaxSquareSubmatrix {

	public static void maxSquareSubMatrix(int matrix[][],int row,int column)
	{
		int result[][]=new int[row+1][column+1];
		for(int i=0;i<=column;i++)
			result[0][i]=0;
		for(int i=0;i<=row;i++)
			result[i][0]=0;
		
		int max=0;
		for(int i=1;i<=row;i++)
		{
			for(int j=1;j<=column;j++)
			{
				if(matrix[i-1][j-1]==1){
					int ans=Math.min(result[i-1][j], Math.min(result[i][j-1], result[i-1][j-1]))+1;
					result[i][j]=ans;
					if(ans>max)
						max=ans;
				}
			}
		}
		
		System.out.println(max);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m[][]=new int[][]{{0,1,1,0,1}
						 ,{1,1,0,1,0}
						 ,{0,1,1,1,0}
						 ,{1,1,1,1,0}
						 ,{1,1,1,1,1}
						 ,{0,0,0,0,0}
		                 };
		                 maxSquareSubMatrix(m, 6, 5);
	}

}
