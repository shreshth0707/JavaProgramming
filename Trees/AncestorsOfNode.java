package TreeRevision;


public class AncestorsOfNode {

	public static boolean ancestors(BinaryTree<Integer> root,int node)
	{
		if(root==null)
			return false;
		if(root.data==node)
			return true;
		
		boolean ans1=ancestors(root.left, node);
		boolean ans2=ancestors(root.right, node);
		if(ans1==true)
		{
			System.out.println(root.data);
			return ans1;
		}
		
		if(ans2==true)
		{
			System.out.println(root.data);
			return ans2;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		ancestors(root, 7);
	}

}
