package TreeRevision;

public class BinaryTreeToSumTree {

	
	// apni value store karo and child ke liye recursion.
	// khudko child ke sum se replace karo and child plus apni original data ko aage bhejo.
	public static int toSumTree(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		
		int oldvalue=root.data;
		
		root.data=toSumTree(root.left)+toSumTree(root.right);
		
		return root.data+oldvalue;
		
	}
	
	
	public static int conv(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		
		int data=root.data;
		root.data=conv(root.left)+ conv(root.right);
		return root.data+ data;
		
	}

	public static boolean isleaf(BinaryTree<Integer> root)
	{
		if(root==null || (root.left==null && root.right==null))
			return true;
		return false;
	}
	
	
	public static boolean checkSumTree(BinaryTree<Integer> root)
	{
		if(root==null || (root.left==null && root.right==null))
			return true;
		
		boolean ansl=checkSumTree(root.left);
		boolean ansr=checkSumTree(root.right);
		
		int sumchild=0;
		if(root.left!=null)
			sumchild+=root.left.data;
		if(root.right!=null)
			sumchild+=root.right.data;
		
		if(isleaf(root.left) && isleaf(root.right))
		{
			if(root.data==sumchild)
				return ansl&& ansr;
			return false;
		}
		else
		{
			if(root.data==2*sumchild)
				return ansl && ansr;
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		int a=conv(root);
		BinaryTreeUse.print(root);
	//	System.out.println(checkSumTree(root));
	}

}

//10 -2 6 8 -4 7 5 -1 -1 -1 -1 -1 -1 -1 -1
// 26 10 3 4 6 -1 3 -1 -1 -1 -1 -1 -1