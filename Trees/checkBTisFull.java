package TreeRevision;

public class checkBTisFull {

	public static boolean check(BinaryTree<Integer> root)
	{
		if(root==null)
			return true;
		
		boolean ans1=check(root.left);
		boolean ans2=check(root.right);
		
		if(root.left==null && root.right==null)
			return true;
		if(root.left==null || root.right==null)
			return false;
		
		
		return (ans1 && ans2);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(check(root));
		
		
	}

}
