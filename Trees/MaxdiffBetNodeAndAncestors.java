package TreeRevision;

public class MaxdiffBetNodeAndAncestors {

	// static as constantly changing
	static int maxdiff=Integer.MIN_VALUE;
	public static int maxdiff(BinaryTree<Integer> root)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		if(root.left==null && root.right==null)
			return root.data;
		
		// find min value in the left and right subtree to get maxdiff.
		int minsubtree=Math.min(maxdiff(root.left),maxdiff(root.right));
		maxdiff=Math.max(maxdiff, root.data-minsubtree);
		
		// return min value from subtree or root data
		return Math.min(minsubtree,root.data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> bt=BinaryTreeUse.takeInputLevelWise();
		int r=maxdiff(bt);
		System.out.println(maxdiff);
	
		
	}


}
