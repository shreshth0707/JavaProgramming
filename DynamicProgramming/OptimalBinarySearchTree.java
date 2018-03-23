package DynamicProgramming;

public class OptimalBinarySearchTree {

	public static void optimlbst(int keys[],int frequency[])
	{
		int matrix[][]=new int[keys.length][keys.length];
		for(int i=0;i<keys.length;i++)
			matrix[i][i]=frequency[i];                         // length 1
		
		for(int i=2;i<=keys.length;i++)
		{
			int cost=0;
			int min=Integer.MAX_VALUE;
			for(int j=0;j+i-1<keys.length;j++)
			{
				min=Integer.MAX_VALUE;
				cost=0;
				for(int k=0;k<i;k++)
					cost+=frequency[j+k];
				
				int end=j+i-1;
				for(int k=j;k<=end;k++)
				{
					int value=Integer.MAX_VALUE;
					if(k>j && k<end)
					value=matrix[j][k-1] + matrix[k+1][end];
					else if(k==j)
						value=matrix[k+1][end];
					else
						value=matrix[j][k-1];
					
					if(value<min)
						min=value;
				}
				matrix[j][j+i-1]=min + cost;
			}
			
		}
		System.out.println(matrix[0][keys.length-1]);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[]={10,12,16,21};
		int array[]={4,2,6,3};
		optimlbst(array1, array);

}
	
}
