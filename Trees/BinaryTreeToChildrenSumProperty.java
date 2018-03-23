package TreeRevision;



// convert bTree to children Sum tree
public class BinaryTreeToChildrenSumProperty {
	
	// to convert tree to children sum tree.
	public static BinaryTree<Integer> convert(BinaryTree<Integer> root)
	{
		if(root==null)
			return root;

		// it is a leaf node then return.
		if(root.left==null && root.right==null)
			return root;

		// post order traversal first left child then right child
		root.left=convert(root.left);
		root.right=convert(root.right);

		// we find sum of left child and right child and find the diff between the root data and their children.
		int l=0;
		int r=0;
		if(root.left!=null)
			l=root.left.data;
		if(root.right!=null)
			r=root.right.data;
		int sum=l+r;
		int diff=sum-root.data;
		if(diff>=0)      // children sum is greater than root,means root ke data ko increase karo
		{
			root.data+=diff;
		}
		else
		{	// we need to increase data of children of root recursively.
			increment(root,-diff);
		}
		return root;

	}
	
	public static void increment(BinaryTree<Integer> root,int  diff)
	{
		
		// left null nahi hai to root ka data badake left child ke liye recursive call 
		// else right child ke liye recursive call.leaf node aa gayi to stop calls.
		if(root.left!=null)
		{
			root.left.data+=diff;
			increment(root.left,diff);
		}
		else if(root.right!=null)
		{
			root.right.data+=diff;
			increment(root.right,diff);
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> btree=BinaryTreeUse.takeInputLevelWise();
		btree=convert(btree);
		BinaryTreeUse.print(btree);
	}

}
