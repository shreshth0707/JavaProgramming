package TreeRevision;

/*
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

Example:

Input: Root of below tree
       1
      / \
     2   3
Output: 6

See below diagram for another example.
1+2+3
tree



For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child
 */
public class MaximumSumPath {

	static int max=0;  // to maintain max so far
	
	public static int max(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		
		if(root.left==null || root.right==null)
			return root.data;
		int left=max(root.left);
		int right=max(root.right);
		
		int a=Math.max(max, Math.max(root.data, Math.max(root.data+left,root.data+ right)));
		int b=root.data+left+right;
		max=Math.max(max, Math.max(a, b));
		
		// return sum without including the value of(l+r+root.data) otherwise some nodes will be repeated.
		return a;
	}
	
	
	
	// o(n)
	public static int maxSum(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return root.data;
		
		// consider 4 conditions.
		int a=root.data;
		int b=a+maxSum(root.left);
		int c=a+maxSum(root.right);
		int d=b+c-a;  //root 2 bar count ho gyi hai isliye subtract it once
		
		max=Math.max(a, Math.max(b, Math.max(c, Math.max(max, d))));
		// jab return karenge then sirf 3 cases:root,root+ max(left child) or root+max(right child).
		// if we return root+max(left) + max(right)then ek root ko multiple times include kar lenge.
		return Math.max(a, Math.max(b, c));
	}
	
	public static void main(String args[])
	{
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
	//	System.out.println(maxSum(root));
		max(root);
		System.out.println(max);
	}
}
