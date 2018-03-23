package DynamicProgramming;

import java.util.ArrayList;

class spair
{
	int lpart;
	int profit;
	
	public spair(int lpart,int profit) {
		// TODO Auto-generated constructor stub
		this.lpart=lpart;
		this.profit=profit;
	}
}

public class CutRodProblem {

	public static void cutRod(int length,ArrayList<spair> list)
	{
		int matrix[][]=new int[list.size()][length+1];
		for(int i=0;i<=length;i++)
		{
			if(list.get(0).lpart > i)
				matrix[0][i]=0;
			else
			{
				int no=i/list.get(0).lpart;
				matrix[0][i]=no*list.get(0).profit;
			}
		}
		
		for(int i=1;i<list.size();i++)
		{
			for(int j=1;j<=length;j++)
			{
				if(list.get(i).lpart>j)
					matrix[i][j]=matrix[i-1][j];
				else
				{
					matrix[i][j]=Math.max(matrix[i-1][j], list.get(i).profit + matrix[i][j-list.get(i).lpart]);
				}
				
			}
		}
		System.out.println(matrix[list.size()-1][length]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<spair> pair=new ArrayList<>();
		pair.add(new spair(1, 1));
		pair.add(new spair(2, 5));
		pair.add(new spair(3, 8));
		pair.add(new spair(4, 9));
		pair.add(new spair(5, 10));
		pair.add(new spair(6, 17));
		pair.add(new spair(7, 17));
		pair.add(new spair(8, 20));
		
		cutRod(8, pair);
	}

}
