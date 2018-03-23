package TreeRevision;

public class mergeTwoBST {

	public static void merge(BinaryTree<Integer> root,BinaryTree<Integer> root2)
	{
		if(root==null && root2==null)
		{
			return;
		}
		if(root!=null && root2==null)
		{
			TreeUse.inorderIteratively(root);
			return;
		}
		else if(root==null && root2!=null)
		{
			TreeUse.inorderIteratively(root2);
			return;
		}
		else  // both are not null
		{
			merge(root.left, root2.left);
			
			if(root.data<root2.data)
				System.out.print(root.data + " " + root2.data + " ");
			
			else
			{
				System.out.print(root2.data + " " + root.data +" ");
				
			}
			
			merge(root.right, root2.right);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> t1=BinaryTreeUse.takeInputLevelWise();
		BinaryTree<Integer> t2=BinaryTreeUse.takeInputLevelWise();
		
		merge(t1, t2);

	// 8 2 10  1 -1 -1 -1 -1 -1			
	//5 3 -1 0 -1 -1 -1
	}

}
