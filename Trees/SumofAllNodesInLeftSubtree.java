package TreeRevision;

/*
 * Change a Binary Tree so that every node stores sum of all nodes in left subtree
Given a Binary Tree, change the value in each node to sum of all the values in the nodes in the left subtree including its own.

Example

Input : 
     1
   /   \
 2      3

Output :
    3
  /   \
 2     3


Input
       1
      / \
     2   3
    / \   \
   4   5   6
Output:
      12
     / \
    6   3
   / \   \
  4   5   6
 * 
 */


public class SumofAllNodesInLeftSubtree {

	
	public static int  convert(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		
		// no children so just return data of root
		if(root.left==null || root.right==null)
			return root.data;
		
		// calculate sum of left and right subtree.
		int leftsum=convert(root.left);
		int rightsum=convert(root.right);
		
		// modify root.data to include the sum of left subtree in it.
		int r=root.data;
		root.data+=leftsum;
		
		// return sum of left and right subtree + root as it will behave as left subtree for the parent.
		return r+leftsum+rightsum;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		convert(root);
		BinaryTreeUse.print(root);
	}

}
