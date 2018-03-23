package TreeRevision;

public class MaximumSumNoAdjacentNode {

	public static int summax(BinaryTree<Integer> root)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		
		// leaf node hai so include as no left subtree or right subtree.
		if(root.left==null && root.right==null)
			return root.data;
		
		// find max element from left subtree,max element from right subtree ,either return their sum
		// or root.data whichever is greater.
		int left=summax(root.left);
		int right=summax(root.right);
		
		return Math.max(left+right, root.data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(summax(root));
	}

}
