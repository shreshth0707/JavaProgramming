package TreeRevision;

public class LevelOfNodeinBT {

	public static int getlevel(BinaryTree<Integer> root,int level,int node)
	{
		if(root==null)
			return 0;
		
		if(root.data==node)
			return level;
		
		int left=getlevel(root.left, level+1, node);
		int right=getlevel(root.right, level+1, node);
		if(left!=0)
			return left;
		else if(right!=0)
		{
			return right;
		}
		else
			return 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(getlevel(root, 0, 3));
	}

}
