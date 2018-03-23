package TreeRevision;

public class MirrorOfBT {
	
	public static BinaryTree<Integer> mirror(BinaryTree<Integer> root)
	{
		if(root==null)
			return root;
		
		BinaryTree<Integer> newroot=new BinaryTree<Integer>(root.data);
		if(root.left!=null)
			newroot.right=mirror(root.left);
		if(root.right!=null)
			newroot.left=mirror(root.right);
		
		return newroot;
	}
	
	public static void main(String[] args)
	{
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		root=mirror(root);
		BinaryTreeUse.print(root);
	}

}
