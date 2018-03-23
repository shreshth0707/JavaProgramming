package TreeRevision;

public class CousinsOfANode {

	
	// to find the level of the required node and its parent
	static BinaryTree<Integer> parent=null;
	public static int level(BinaryTree<Integer> root,int level,int k)
	{
		if(root==null)
			return -1;
		if(root.data==k)
			return level;
		
		if(root.left!=null)
		{
			if(root.left.data==k)
				parent=root;
		}
		if(root.right!=null)
		{
			if(root.right.data==k)
				parent=root;
		}
		
		int left=level(root.left,level+1,k);
		if(left!=-1)
			return left;
		
		int right=level(root.right,level+1,k);
			return right;
		
	}
	
	// we need to find cousin of k
	public static void cousin(BinaryTree<Integer> root,int level,int req,int k)
	{
		if(root==null)
			return;
		
		
		if(level==req)
		{
			// root is k
			if(root.data!=k)
			{
				// ye sibling hai ya cousin hai.sibling means same parent.
				if(parent.left!=root && parent.right!=root)
				{
					System.out.println(root.data);
				}
			}
		}
		
		cousin(root.left, level+1, req, k);
		cousin(root.right, level+1, req, k);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		int k=5;
		int level=level(root,0,k);
		System.out.println(parent.data);
		cousin(root, 0, level, k);
	}

}
