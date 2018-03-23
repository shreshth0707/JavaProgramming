package TreeRevision;

public class TripletInBST {

	
	static BinaryTree<Integer> prev=null;     // static becoz it is varying
	static BinaryTree<Integer> head=null;
	public static void converttodll(BinaryTree<Integer> root)    // inorder traversal hi hoga
	{ 
		if(root==null)
			return;
		
		converttodll(root.left);
		if(prev==null)
			head=root;
		else
		{
			root.left=prev;
			prev.right=root;
		}
		prev=root;
		
		converttodll(root.right);
		
	}
	
	public static void triplet(BinaryTree<Integer> root,int target)
	{
		converttodll(root);    // converted to dll.head is the head of dll.prev is the end of dll
		
		// after getting the dll.problem is reduces to find triplet in dll ~ triplet in array.
		BinaryTree<Integer> start=head;
		while(start.right!=null){
			int diff=target-start.data;
			BinaryTree<Integer> s=start.right;
			BinaryTree<Integer> e=prev;
			while(s!=e)
			{
				if(s.data +e.data==diff)
				{
					System.out.println(start.data +" " + s.data +" " + e.data);
					return;
				}
				else if(s.data +e.data<diff)
				{
					if(s.right!=e)
					s=s.right;
					else
						return;
				}
				else
				{
					if(e.left!=s)
						e=e.left;
				}
			}
			start=start.right;
		} 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		triplet(root, 0);
		
	}

}
