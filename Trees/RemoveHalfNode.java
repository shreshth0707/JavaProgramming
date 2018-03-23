package TreeRevision;

public class RemoveHalfNode {

	public static BinaryTree<Integer> remove2(BinaryTree<Integer> root)
	{
		if(root==null)
			return null;

		root.left=remove2(root.left);
		root.right=remove2(root.right);

		if(root.left==null && root.right!=null)
		{
			return root.right;
		}
		else if(root.left!=null && root.right==null)
			return root.left;

		else
			return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		root=remove2(root);
		BinaryTreeUse.print(root);
	}
}
