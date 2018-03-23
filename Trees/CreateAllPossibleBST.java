package TreeRevision;

import java.util.ArrayList;

public class CreateAllPossibleBST {

	// idea:har ek index ko ek bar root banao,left and right subtree create karo and combination banake select kro nodes
	// dono subtrees se.

	public static ArrayList<BinaryTree<Integer>> construct(int start,int end)
	{
		ArrayList<BinaryTree<Integer>> list=new ArrayList<>();

		// no element left in range
		if(start>end)
		{
			list.add(null);
			return list;
		}

		for(int i=start;i<=end;i++){

			// calculate all possible subtree for given range
			ArrayList<BinaryTree<Integer>> leftsubtree=construct(start, i-1); 
			ArrayList<BinaryTree<Integer>> rightsubtree=construct(i+1, end);
			
			for(int j=0;j<leftsubtree.size();j++)
			{
				BinaryTree<Integer> left=leftsubtree.get(j);
				for(int k=0;k<rightsubtree.size();k++)
				{
					BinaryTree<Integer> right=rightsubtree.get(k);
					// create the root
					BinaryTree<Integer> root=new BinaryTree<>(i);
					root.left=left;
					root.right=right;
					list.add(root);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BinaryTree<Integer>> list=new ArrayList<>();
		list=construct(0, 3);
		for(BinaryTree<Integer> b:list)
		BinaryTreeUse.print(b);
		
	}

}
