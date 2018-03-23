package TreeRevision;

public class SymmetricTree {

	public static boolean check(BinaryTree<Integer> root)
	{
		if(root==null)
			return true;
		
		if(root.left==null || root.right==null)
			return false;
		
		return checked(root.left,root.right);
		
	}
	
	private static boolean checked(BinaryTree<Integer> r1,BinaryTree<Integer> r2)
	{
		if(r1==null && r2==null)
			return true;
		
		if(r1.data!=r2.data)
			return false;
		if((r1.left==null && r2.right!=null) || (r1.right==null  && r2.left!=null)
			|| (r2.left==null && r1.right!=null) || (r2.right==null  && r1.left!=null))
		return false;
		
			
		if(r1.left!=null && r1.left.data!=r2.right.data)
			return false;
		
		if(r1.right!=null && r1.right.data!=r2.left.data)
			return false;
		
		
		return checked(r1.left,r2.right) && checked(r1.right,r2.left);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(check(root));
		
	}

}
