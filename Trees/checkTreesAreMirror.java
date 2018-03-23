package TreeRevision;

public class checkTreesAreMirror {

	public static boolean check(BinaryTree<Integer> r,BinaryTree<Integer> s)
	{
		if(r==null && s==null)
			return true;
		if(r==null || s==null)
			return false;
		
			
		
		if(r.data!=s.data)
			return false;
		else{
		boolean ans1=check(r.left, s.right);
		boolean ans2=check(r.right, s.left);
		
		return ans1 && ans2;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> r=BinaryTreeUse.takeInputLevelWise();
		BinaryTree<Integer> s=BinaryTreeUse.takeInputLevelWise();
		
		System.out.println(check(r,s));
		
	}

}
