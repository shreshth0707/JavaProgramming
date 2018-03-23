package TreeRevision;

import java.util.ArrayList;

public class DiagonalSumOfBtree {

	public static void diagonalSum(BinaryTree<Integer> root,int left,int right,int sum[])
	{
		if(root==null)
			return;
		
		sum[left]+=root.data;
		diagonalSum(root.left, left+1, right, sum);
		diagonalSum(root.right, left, right+1, sum);
	}
	
	public static void diagonalBetter(BinaryTree<Integer> root,ArrayList<Integer> list,int left)
	{
		if(root==null)
			return;
		
		if(list.size()<=left)
		{
			list.add(root.data);
		}
		else
		{
			int count=list.get(left);
			list.add(left,count+root.data);
			list.remove(left+1);
		}
		
		// ab surely left ke corresponding index exist karega.
		diagonalBetter(root.left, list, left+1);
		
		diagonalBetter(root.right, list, left);
	}
	
	
	public static void main(String[] args) {
	/*	
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		int h=BinaryTreeUse.height(root);
		int array[]=new int[h];
		diagonalSum(root, 0, 0, array);
	
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=0)
			System.out.println("diagonal" + i + " sum=" + array[i]);
			else 
				break;
		}
		*/
		

		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		ArrayList<Integer> array=new ArrayList<>();
		diagonalBetter(root, array, 0);
		for(int i=0;i<array.size();i++)
		{
			System.out.println("left" + i +" = " + array.get(i));
		}
		
	}

}
//  1 2 3 9 6 4 5 -1 10 11 -1 12 7 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1