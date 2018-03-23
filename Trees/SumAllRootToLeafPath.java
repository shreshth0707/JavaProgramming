package TreeRevision;

public class SumAllRootToLeafPath {

	
	
	public static int sum(BinaryTree<Integer> root,int val)
	{
		if(root==null)
			return 0;
		
		val=val*10 + root.data;
		if(root.left==null && root.right==null)
			return val;
		
		return sum(root.left, val)+ sum(root.right, val);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(sum(root, 0));
	}

}
