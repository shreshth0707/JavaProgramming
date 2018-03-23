package DynamicProgramming;

import java.util.ArrayList;

class Pairs{
	int weight;
	int value;
	public Pairs(int a,int b) {
		// TODO Auto-generated constructor stub
		weight=a;
		value=b;
	}
}

public class Zero1knapsackProblem {
	
	
	public static void knapsack(int w,ArrayList<Pairs> list)
	{
		int matrix[][]=new int[list.size()][w+1];
		for(int i=0;i<list.size();i++)
			matrix[i][0]=0;
		
		int i=0;
		for(i=1;i<list.get(0).weight;i++)
			matrix[0][i]=0;
		for(;i<=w;i++)
			matrix[0][i]=list.get(0).value;
		
		
		for(i=1;i<list.size();i++)
		{
			for(int j=1;j<=w;j++)
				if(j<list.get(i).weight)
				matrix[i][j]=matrix[i-1][j];
			
				else
				{
					matrix[i][j]=Math.max(matrix[i-1][j],list.get(i).value + matrix[i-1][j-list.get(i).weight]);
				}
		}
		
		
		
		System.out.println(matrix[list.size()-1][w]);
		ArrayList<Pairs> list1=new ArrayList<>();
		int jj=w;
		int W=w;
		int ii=list.size()-1;
		while(W>0)
		{
			while(matrix[ii][jj]==matrix[ii-1][jj])
			{
				ii--;
			}
			list1.add(list.get(ii));
			jj=W-list.get(ii).weight;
			W=W-list.get(ii).weight;
			ii--;
		}
		
		for(Pairs p:list1)
			System.out.println(p.weight + " " + p.value );
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pairs> list=new ArrayList<>();
		list.add(new Pairs(1, 1));
		list.add(new Pairs(3, 4));
		list.add(new Pairs(4, 5));
		list.add(new Pairs(5, 7));
		knapsack(7, list);
	}

}
