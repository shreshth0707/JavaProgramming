package TreeRevision;

public class DeepestLeftLeafNode {

	static int deeplevel=0;
	static BinaryTree<Integer> ans=null;
	public static void find(BinaryTree<Integer> root,int level)
	{
		if(root==null)
			return;
		
		if(root.left!=null)
		{
			if(level+1>deeplevel)
			{
				deeplevel=level+1;
				ans=root.left;
			}
			find(root.left, level+1);
		}
		
		find(root.right, level+1);
	}
	
	public static int findFromPreorder(String str,int i)
	{
		if(i>=str.length() || str.charAt(i)=='l')
			return 0;
		
		int left=findFromPreorder(str, i+1);
		int right=findFromPreorder(str, i+2);
		
		return Math.max(left,right)+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
//		BinaryTree<Integer> temp=null;
//		find(root, 0);
//		System.out.println(ans.data);
	
		System.out.println(findFromPreorder("nlnnlll", 0));
	}

}
