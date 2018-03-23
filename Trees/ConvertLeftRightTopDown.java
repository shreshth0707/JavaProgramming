package TreeRevision;

public class ConvertLeftRightTopDown {

	
	// first convert child then root
	public static void convert(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;
		
		if(root.left==null)
		{
			root.left=root.right;
		}
		else
		{
			root.left.right=root.right;
		}
		root.right=null;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		convert(root);
		BinaryTreeUse.print(root);

	}

}
