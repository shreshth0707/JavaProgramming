package TreeRevision;

public class NodesWithKLeaves {
	public static int leaves(BinaryTree<Integer> root,int k)
	{
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		
		// count leaves in leftsubtree and leaves in rightsubtree.if they sum to k,print root
		int left=leaves(root.left,k);
		int right=leaves(root.right,k);
		if(left+right==k)
			System.out.println(root.data);
		// return total leaves till now.
		return left+right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		leaves(root, 3);
	}

}
