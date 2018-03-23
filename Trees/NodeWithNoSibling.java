package TreeRevision;

public class NodeWithNoSibling {

	public static void withoutsibling(BinaryTree<Integer> root)
	{
		if(root==null || (root.left==null && root.right==null))
			return ;
		
			if(root.left!=null && root.right==null)
			{
				System.out.println(root.left.data);
				withoutsibling(root.left);
			}
			else if(root.left==null && root.right!=null)
			{
				System.out.println(root.right.data);
				withoutsibling(root.right);
		}
		else
		{
		withoutsibling(root.left);
		withoutsibling(root.right);
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		withoutsibling(root);

	}

}
