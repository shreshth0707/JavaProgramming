package TreeRevision;

public class FlipTree {

	public static BinaryTree<Integer> flip(BinaryTree<Integer> root)
	{
		if(root==null)
			return root;
		if(root.left==null && root.right==null)
		{
			return root;
		}
		// only need to flip leftmost nodes
		BinaryTree<Integer> flipped=flip(root.left);
		root.left.left=root.right;
		root.left.right=root;
		root.left=null;
		root.right=null;
		return flipped;     // return new flipped node
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		BinaryTreeUse.print(flip(root));
	}

}
