package TreeRevision;

public class MaxRootToLeafPath {

	static int maxsum=0;
	static BinaryTree<Integer> leaf=null;
	public static void path(BinaryTree<Integer> root,int currsum)
	{
		currsum+=root.data;
		
		if(root.left==null && root.right==null)
		{
			if(currsum>maxsum)
			{
				maxsum=currsum;
				leaf=root;
			}
			return;
		}
		
		path(root.left, currsum);
		path(root.right,currsum);
		currsum-=root.data;
		
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		path(root, 0);
		System.out.println("sum="+ maxsum + " and leaf:" + leaf.data);
	}

}
