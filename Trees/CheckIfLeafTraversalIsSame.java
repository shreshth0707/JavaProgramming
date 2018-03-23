package TreeRevision;

import java.util.*;

public class CheckIfLeafTraversalIsSame{
	
	public static boolean isLeaf(BinaryTree<Integer> root)
	{
		return (root.left==null && root.right==null);
	}
	
	// using iterative preorder traversal.
	 public static boolean isSame(BinaryTree<Integer> root1, BinaryTree<Integer> root2)
	   {
	      // Create empty stacks.  These stacks are going
	      // to be used for iterative traversals.
	      Stack<BinaryTree<Integer>> s1 = new Stack<BinaryTree<Integer>>();
	      Stack<BinaryTree<Integer>> s2 = new Stack<BinaryTree<Integer>>();
	 
	      s1.push(root1);
	      s2.push(root2);
	 
	      // Loop until either of two stacks is not empty
	      while (!s1.empty() || !s2.empty())
	      {
	         // If one of the stacks is empty means other
	         // stack has extra leaves so return false
	         if (s1.empty() || s2.empty())
	            return false;
	 
	         BinaryTree<Integer> temp1 = s1.pop();
	         while (temp1!=null && !isLeaf(temp1))
	         {
	            // Push right and left children of temp1.
	            // Note that right child is inserted 
	            // before left
	            if (temp1.right != null)
	               s1.push(temp1. right);
	            if (temp1.left != null)
	               s1.push(temp1.left);
	            temp1 = s1.pop();
	         }
	 
	         // same for tree2
	         BinaryTree<Integer> temp2 = s2.pop();
	         while (temp2!=null && !isLeaf(temp2))
	         {
	            if (temp2.right != null)
	               s2.push(temp2.right);
	            if (temp2.left != null)
	               s2.push(temp2.left);
	            temp2 = s2.pop();
	         }
	 
	         // If one is null and other is not, then 
	         // return false
	         if (temp1==null && temp2!=null)
	            return false;
	         if (temp1!=null && temp2==null)
	            return false;
	 
	         // If both are not null and data is not 
	         // same return false
	         if (temp1!=null && temp2!=null)
	         {
	            if (temp1.data != temp2.data)
	               return false;
	         }
	      }
	 
	      // If control reaches this point, all leaves 
	      // are matched
	      return true;
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		BinaryTree<Integer> root1=BinaryTreeUse.takeInputLevelWise();
		BinaryTree<Integer> root2=BinaryTreeUse.takeInputLevelWise();
		System.out.println(isSame(root1, root2))
		;
	}

}
//1 2 3 4 -1 6 7 -1 -1 -1 -1 -1 -1
//0 5 8 -1 4 6 7 -1 -1 -1 -1 -1 -1