package TreeRevision;

public class ExtractLeafToDLL {
	static BinaryTree<Integer> head=null;
	static BinaryTree<Integer> temp=null;

	 // post order traversal becoz leaf node ke left right pointers modify ho rahe hain,agar left and right ko bad 
	//	 mei access kiya to next leaf pe chala jaega.
			// many other ways to do this quesn.
	public static void ex(BinaryTree<Integer> root)
	{
		if(root.left!=null)
			ex(root.left);
		if(root.right!=null)
			ex(root.right);
		
		if(root.left==null  && root.right== null)   // it is leaf node.
		{
			if(head==null)
			{
				head=root;
				temp=root;
			}
			else
			{
				temp.right=root;
				root.left=temp;
				temp=temp.right;
			}
		}
	}
	
	public static void extract(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;
		if(root.left==null && root.right==null)  // leaf node ,add to the list
		{
			if(head==null)
			{
				head=root;
				temp=root;
			}
			else
			{
				temp.right=root;
				root.left=temp;
				temp=temp.right;
			}
		}
		else
		{
		extract(root.left);
		extract(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		ex(root);
		while(head!=null)
		{
			System.out.println(head.data);
			head=head.right;
		}
	}

}
