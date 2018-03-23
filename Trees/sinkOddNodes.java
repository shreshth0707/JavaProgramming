package TreeRevision;

import org.omg.CORBA.INTERNAL;

public class sinkOddNodes {

	
	// post order traversal ie::bottom up approach
	public static void sink(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;
		
		if(root.left==null && root.right==null)
			return ;
		
		sink(root.left);
		sink(root.right);
		
		if(root.data%2==1)
			sinknode(root);
	}
	
	public static void sinknode(BinaryTree<Integer> root)
	{
		if(root==null || (root.left==null && root.right==null))
			return;
		
		if(root.left!=null && root.left.data%2==0)
		{
			int temp=root.data;
			root.data=root.left.data;
			root.left.data=temp;
			sink(root.left);
		}
		
		else if(root.right!=null && root.right.data%2==0)
		{
			int temp=root.data;
			root.data=root.right.data;
			root.right.data=temp;
			sink(root.right);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		sink(root);
		BinaryTreeUse.print(root);
	}

}
