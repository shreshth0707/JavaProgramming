package TreeRevision;

class bt
{
	int data;
	bt left,right,parent;
	
	public bt (int data)
	{
		this.data=data;
		this.left=null;
		right=null;
		parent=null;
	}
}






// inorder means node left child and right child
public class InorderNonThreadedTreeTraversal {
	
	public static void nonthreaded(bt root)
	{
		if(root==null)
			return ;
		
		while(root!=null)
		{
			boolean lefttraversed=false;
			if(root.left!=null)
			{
				while(root.left!=null)
					root=root.left;
			}
			System.out.println(root.data);
			lefttraversed=true;
			
			if(root.right!=null)
			{
				root=root.right;
				lefttraversed=false;
			}
			else if(root.parent!=null)
			{
				while(root.parent!=null && root.parent.right==root)
					root=root.parent;
				
				if(root.parent==null)
					return;
				
				else
				{
					root=root.parent;
				}
			}
			
		}
	}
	
	
	

	public static void traversal(bt root)
	{
		if(root==null)
			return ;
		
		
		while(root!=null)
		{
			// wheather left child is traversed or not
			boolean lefttraversed=false;
			
			// move to ledftmost node if the left subtree have not been traversed.
			if(!lefttraversed)
			{
				while(root.left!=null)
				{
					root=root.left;
				}
			}
			
			// left child is null so print root data.
			System.out.println(root.data);
			lefttraversed=true;     // now left subtree is traversed.
			
			// traverse right child now if it is not null
			if(root.right!=null)
			{
				root=root.right;
				// again do same treating the right child as root.
				lefttraversed=false;
			}
			
			// right child is null .we will move up to the parent and continue traversal.
			else if(root.parent!=null)
			{
				// agar root is the right child of parent it means cureent subtree is fully traversed.MOve upward
				while(root.parent!=null &&
						root.parent.right==root
						)
				{
					root=root.parent;
				}
				if(root.parent==null)
					return;
				
				// current node is left child of parent.
				else
				{
					root=root.parent;
				}
			}
				
			
		}
	}
	public static bt insert(bt node, int key) 
    {
        /* If the tree is empty, return a new node */
        if (node == null) 
            return new bt(key);
  
        /* Otherwise, recur down the tree */
        if (key < node.data) 
        {
            node.left = insert(node.left, key);
            node.left.parent = node;
        } 
        else if (key > node.data) 
        {
            node.right = insert(node.right, key);
            node.right.parent = node;
        }
          
        /* return the (unchanged) node pointer */
        return node;
    }
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		bt tree = null;
        tree = insert(tree, 24);
        tree = insert(tree, 27);
        tree=insert(tree, 29);
        tree=insert(tree, 34);
        tree=insert(tree, 14);
        tree=insert(tree, 4);
        tree=insert(tree, 10);
        tree=insert(tree, 22);
        tree=insert(tree, 13);
        tree=insert(tree, 3);
        tree=insert(tree, 2);
        tree=insert(tree, 6);
       traversal(tree);
		
	}
	

	

}
