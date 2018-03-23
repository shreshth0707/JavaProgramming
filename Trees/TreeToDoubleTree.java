package TreeRevision;

/*
 * Double Tree
Write a program that converts a given tree to its Double tree. 
To create Double tree of the given tree, create a new duplicate for each node, 
and insert the duplicate as the left child of the original node.

So the tree…

    2
   / \
  1   3
is changed to…

       2
      / \
     2   3
    /   /
   1   3
  /
 1
 */
public class TreeToDoubleTree {
	
	public static BinaryTree<Integer> dt(BinaryTree<Integer> root)
	{
		if(root==null)
			return null;
		
		BinaryTree<Integer> temp=root.left;
		BinaryTree<Integer> tt=new BinaryTree<Integer>(root.data);
		tt.left=temp;
		tt.right=null;
		root.left=tt;
		
		root.right=dt(root.right);
		root.left.left=dt(root.left.left);
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		root=dt(root);
		BinaryTreeUse.print(root);
	}

}
