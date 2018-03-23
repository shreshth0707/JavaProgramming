package TreeRevision;


public class BTtoDLL {
	 static BinaryTree<Integer> pre=null;
	
	public static void fixleftptr(BinaryTree<Integer> root)
	{
	
		if(root!=null)
		{
			fixleftptr(root.left);
			root.left=pre;
			pre=root;
			fixleftptr(root.right);
		}
	}
	
	public static BinaryTree<Integer> fixrightptr(BinaryTree<Integer> root)
	{
			BinaryTree<Integer> pre=null;
			
			// reach the rightmost node;
			while(root!=null && root.right!=null)
				root=root.right;
			
			// left subtree ko arrange karo
			while(root!=null && root.left!=null)
			{
				pre=root;
				root=root.left;    
				root.right=pre;
			}
			
			return (root);
	}
	
	
	
	
			// method 2 simplest of all 
	
	static BinaryTree<Integer> prev=null;     // static becoz it is varying
	static BinaryTree<Integer> head=null;
	public static void converttodll(BinaryTree<Integer> root)    // inorder traversal hi hoga
	{ 
		if(root==null)
			return;
		
		converttodll(root.left); // inorder traversal 
		if(prev==null)
			{
			head=root;
			prev=root;
			}
		else
		{
			root.left=prev;
			prev.right=root;
			prev=root;
			
		}
		converttodll(root.right);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
/*
		fixleftptr(root);
		root=fixrightptr(root);
		
		while(root!=null){
			System.out.println(root.data);
			root=root.right;
		}
*/
	//	convert(root);
		converttodll(root);
		BTtoDLL bd=new BTtoDLL();
		BinaryTree<Integer> node=bd.head;
		while(head!=null)
		{
			System.out.println(head.data);
			head=head.right;
		}
	}

}

