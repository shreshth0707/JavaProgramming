package TreeRevision;

public class BTtoChildrenSumProp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(checkChildrenSum(root));
		convert(root);
		BinaryTreeUse.printAtDifferentLines(root);
		System.out.println(checkChildrenSum(root));
	}
	
	public static boolean checkChildrenSum(BinaryTree<Integer> root)
	{
		if(root==null || (root.left==null && root.right==null))
			return true;
		
		int child=0;
		boolean lc=false;
		boolean rc=false;
		if(root.left!=null)
		{
			child+=root.left.data;
		}
		if(root.right!=null)
		{
			child+=root.right.data;
		}
		
		if(child!=root.data)
		return false;
		
		lc=checkChildrenSum(root.left);
		rc=checkChildrenSum(root.right);
		
		return (lc && rc);
		
	}

	
	public static void convert(BinaryTree<Integer> root)
	{
		
		if(root==null || (root.left==null && root.right==null))
			return ;
		
		
		// post order
		convert(root.left);
		convert(root.right);
		
		// find diff between root data and its children.
		int rdata=root.data;
		int child=0;
		if(root.left!=null)
			child+=root.left.data;
		if(root.right!=null)
			child+=root.right.data;
		
		int diff=rdata-child;
	    
		// sum of child is greater than root
		if(diff<0)
			root.data+=-diff;
		else if(diff>0)
		{
			increment(root,diff);
		}
	}
	
	public static void increment(BinaryTree<Integer> root,int diff)
	{
		if(root.left!=null)
		{
			root.left.data+=diff;
			increment(root.left, diff);
		}
		else if(root.right!=null)
		{
			root.right.data+=diff;
			increment(root.right, diff);
		}
	}

}

