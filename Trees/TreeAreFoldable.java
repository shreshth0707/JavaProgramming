package TreeRevision;

public class TreeAreFoldable {

	public static boolean isFoldable(BinaryTree<Integer> root1,BinaryTree<Integer> root2)
	{
		if(root1==null && root2==null)
			return true;
		else if((root1!=null && root2==null)||(root1==null && root2!=null))
			return false;

		else
		{
		if((root1.left==null && root2.right!=null)||(root1.left!=null && root2.right==null)
   ||(root2.left==null && root1.right!=null)||(root2.left!=null && root1.right==null))
    return false;
			
		boolean ans1=isFoldable(root1.left, root2.right);
		boolean ans2=isFoldable(root1.right, root2.left);
		
		return (ans1 && ans2);
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(isFoldable(root.left, root.right));
	}

}
