package TreeRevision;

public class SwapKthLevel {

	public static BinaryTree<Integer> swap(BinaryTree<Integer> root,int level,int k)
	{
		if(root==null)
			return null;
		if(root.left==null && root.right==null)
			return root;
		
		// next is the kth level so swap left and right child
		if(level%k==k-1)
		{
			BinaryTree<Integer> r=root.left;
			root.left=root.right;
			root.right=r;
		}
		
		// recur for left and right child by increasing the level;
		root.left=swap(root.left, (level+1)%k, k);
		root.right=swap(root.right, (level+1)%k, k);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		BinaryTreeUse.print(swap(root, 1, 1));
	}

}
