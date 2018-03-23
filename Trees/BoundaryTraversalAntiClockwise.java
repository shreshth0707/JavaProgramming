package TreeRevision;

import org.omg.CORBA.INTERNAL;

public class BoundaryTraversalAntiClockwise {

	
	

	
	
	// last vali leaf node print nahi karani for boundarytraversal,left view mei karani hai.
	public static void leftboundary(BinaryTree<Integer> root)
	{
		if(root==null)
			return;
		
		if(root.left!=null)
		{
			System.out.println(root.data);
			leftboundary(root.left);
		}
		else if(root.right!=null)
		{
			System.out.println(root.data);
			leftboundary(root.right);
		}
		
	}
	
	// all leaves use preorder traversal
	public static void printleaves(BinaryTree<Integer> root)
	{
		if(root==null)
			return;
		
		if(root.left==null && root.right==null)
			System.out.println(root.data);
		
		printleaves(root.left);
		printleaves(root.right);		
	}

	// leaf node print nahi karani hai for boundary traversal, right traversal mei karani hai.
	public static void rightBoundary(BinaryTree<Integer> root,BinaryTree<Integer> temp)
	{
		if(root==null)
			return;
		
		if(root.right!=null)
		{
			rightBoundary(root.right,temp);
			if(root!=temp)      // to avoid duplicacy of root
			System.out.println(root.data);
		}
		else if(root.left!=null)	
		{
			rightBoundary(root.left,temp);
			if(root!=temp)
			System.out.println(root.data);
		}
		
	}
	
	// whole left boundary
	public static void leftB(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;
		
		if(root.left!=null)
		{
			System.out.println(root.data);
			leftB(root.left);
		}
		else if(root.right!=null)
		{
			System.out.println(root.data);
			leftB(root.right);
		}
		// this has to be omitted in boundary traversal to avoid leaf nodes double printed.
		else 
		{
			System.out.println(root.data);
		}
	}
	
	
	// whole right boundary
	public static void rightB(BinaryTree<Integer> root,BinaryTree<Integer> t)
	{
		if(root==null)
			return ;
		
		if(root.right!=null)
		{
			rightB(root.right,t);
			// make sure root is not repeated  and leaf nodes should not be printed
			if(root!=t  && (root.left!=null || root.right!=null))    // omit this for right traversal
				System.out.println(root.data);
		}
		else if(root.left!=null)
		{
			rightB(root.left, t);
			if(root!=t  && (root.left!=null || root.right!=null))    // omit this for right traversal
				System.out.println(root.data);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		leftboundary(root);
//		System.out.println();
//		printleaves(root);
//		System.out.println();
//		rightBoundary(root,root);
	
//		leftB(root);
//		rightB(root, root);
	
//   	lb(root);
	}
	
	public static void lb(BinaryTree<Integer> root)
	{
		if(root==null)
			return;
		
		System.out.println(root.data);
		if(root.right!=null)
		{
			lb(root.right);
		}
		
		else if(root.left!=null)
		{
			lb(root.left);
		}
		 
	}
	
	
}
