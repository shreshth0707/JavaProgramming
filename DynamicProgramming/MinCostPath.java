package DynamicProgramming;

public class MinCostPath {


	public static void minCostPath(int matrix[][],int row,int column)
	{
		int temp[][]=new int[row][column];
		temp[0][0]=matrix[0][0];
		for(int i=1;i<column;i++)
		temp[0][i]=temp[0][i-1]+matrix[0][i];
		
		for(int i=1;i<row;i++)
			temp[i][0]=temp[i-1][0] + matrix[i][0];
		
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<column;j++)
			{
				int c=Math.min(temp[i-1][j-1], Math.min(temp[i][j-1], temp[i-1][j]));
				temp[i][j]=matrix[i][j] + c;
			}
		}
		
		System.out.println(temp[row-1][column-1]);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		minCostPath(cost, 3, 3);

	}

}
