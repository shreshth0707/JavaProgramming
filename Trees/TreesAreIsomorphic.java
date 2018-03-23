package TreeRevision;

public class TreesAreIsomorphic {

	public static boolean areIsomorphic(BinaryTree<Integer> r1,BinaryTree<Integer> r2)
	{
		if(r1==null && r2==null)
			return true;
		if(r1==null || r2==null)
			return false;
		else
		{
			boolean ans1=(r1.data==r2.data);
			boolean ans2=(areIsomorphic(r1.left, r2.left) && areIsomorphic(r1.right, r2.right)) ||
					(areIsomorphic(r1.left, r2.right) && areIsomorphic(r1.right, r2.left));
			
			return(ans1 && ans2);		
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> r1=BinaryTreeUse.takeInputLevelWise();
		BinaryTree<Integer> r2=BinaryTreeUse.takeInputLevelWise();
		System.out.println(areIsomorphic(r1, r2));
	}

}
