package TreeRevision;

public class ConstructBSTformPostOrderTraversal {

	// bst mei nodes in left subtree is less than root, and nodes in right subtree is greater than root,
	// last index will always be the root
	// so search for  the first index in array which is greater than the root.
	// recur for left and right subtree
	
	public static BinaryTree<Integer> construct(int array[],int s,int e)
	{
		// no element in array
		if(s>e)
			return null;
		// only 1 element return it
		else if(s==e)
			return new BinaryTree<>(array[s]);
		
		int i=s;
		BinaryTree<Integer> bt=new BinaryTree<>(array[e]);
		
		int ls=s;
		int re=e-1;
		int le;
		int rs;
		
		// find the first index with value greater than root.this is begining of right subtree.
		// recur for left and right subtree.
		while(i<e && array[i]<array[e])
		{
			i++;
		}
		
			le=i-1;
			rs=i;
			
		bt.left=construct(array, ls, le);
		bt.right=construct(array, rs, re);
		return bt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={1, 7, 5, 50, 40, 10};
		BinaryTreeUse.print(construct(array, 0, array.length-1));
	}

}
