package TreeRevision;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RootToLeafPathWithGivenSum {

	// preorder traversal
	public static void sum(BinaryTree<Integer> root,int sum,ArrayList<BinaryTree<Integer>> list,int s)
	{
		if(root==null)
			return ;
		if(root.left==null && root.right==null)
		{
			list.add(root);
			s+=root.data;
			if(sum==s)
			{
				for(BinaryTree<Integer> b:list)
					System.out.print(b.data+ " ");
				System.out.println();
			}
			s=s-root.data;
			list.remove(list.size()-1);
			return;
		}
		else{
		s+=root.data;
		list.add(root);
		// path but not a leaf node so dont do .
//		if(sum==s)
//		{
//			for(BinaryTree<Integer> b:list)
//				System.out.print(b.data+ " ");
//			System.out.println();
//		}
		sum(root.left,sum,list,s);
		sum(root.right,sum,list,s);
		s=s-root.data;
		list.remove(list.size()-1);
		}
	}
	

// 1 20 3 -1 -1 4 15 6 7 8 9 -1 -1 -1 -1 -1 -1 -1 -1

	// multiple paths
//	10 28 13 -1 -1 14 15 21 22 23 24 -1 -1 -1 -1 -1 -1 -1 -1	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		ArrayList<BinaryTree<Integer>> list=new ArrayList<>();
		sum(root, 23, list, 0);
	}

}
