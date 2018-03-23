package TreeRevision;

class mBT
{
	int data;
	mBT left;
	mBT right;
	mBT nextright;

	public mBT(int d) {
		// TODO Auto-generated constructor stub
		this.data=d;
		left=null;
		right=null;
		nextright=null;
	}
}

public class ConnectNodeAtSameLevel {

	public static mBT connectNodes(mBT root)
	{
		if(root==null)
			return null;
		
		if(root.nextright!=null)
			connectNodes(root.nextright);
		
		if(root.left!=null)
		{
			if(root.right!=null)
			{
				root.left.nextright=root.right;
				root.right.nextright=getNextRight(root);
			}
			else
			root.left.nextright=getNextRight(root);
			
			// current ke liye pura,call for the child
			connectNodes(root.left);
		}
		else if(root.right!=null)
		{
			root.right.nextright=getNextRight(root);
			// current ke liye pura ho gaya,call for the child
			connectNodes(root.right);
		}
		else  // no child left unprocessed ,so move to nextright for its traversal.
		{
			connectNodes(root.nextright);
		}
		return root;
	}
	
	
	
	// return children of node at same level as that of root.
	public static mBT getNextRight(mBT root)
	{
		mBT temp=root.nextright;
		while(temp!=null)
		{
			if(temp.left!=null)
				return temp.left;
			else if(temp.right!=null)
				return temp.right;

			// is node ke pass no child so move to next node at same level as root and return its children.
			temp=temp.nextright;
		}
		return null;
	}

	public static void connect(mBT root)
	{
		if(root==null)
			return;	

		// sabse pehle traverse next_right,then left child and then right child and then root.
		if(root.nextright!=null)
		{
			connect(root.nextright);
		}

		// nextright is null so set it
		if(root.left!=null)
		{
			if(root.right!=null)
			{
				root.left.nextright=root.right;
				root.right.nextright=getNextRight(root);
			}
			else
			{
				root.left.nextright=getNextRight(root);
			}
			connect(root.left);
		}

		else if(root.right!=null)
		{
			root.right.nextright=getNextRight(root);
			connect(root.right);
		}
		else
		{
			connect(getNextRight(root));
		}
	}
	
	

	
	
							// BEST METHOD
							// iterative using constant space.
	public static void Connect(mBT p)
	{
		 if (p == null)
	            return;
	  
	        // Set nextRight for root(pehle level ke right mei kuch nahi hai)
	        p.nextright = null;
	  
	        // set nextRight of all levels one by one
	        while (p != null) 
	        {
	            mBT q = p;
	  
	            /* Connect all childrem nodes of p and children nodes of all other
	               nodes at same level as p */
	            while (q != null) 
	            {
	                // Set the nextRight pointer for p's left child
	                if (q.left != null) 
	                {
	                    // If q has right child, then right child is nextRight of
	                    // p and we also need to set nextRight of right child
	                    if (q.right != null)
	                        q.left.nextright = q.right;
	                    else
	                        q.left.nextright = getNextRight(q);
	                }
	  
	                if (q.right != null)
	                    q.right.nextright = getNextRight(q);
	  
	                // leaf node hai.Same level ki bachi hui ko traverse kar aage.
	                q = q.nextright;
	            }
	  
	            // start from the first node of next level
	            if (p.left != null)
	                p = p.left;
	            else if (p.right != null)
	                p = p.right;
	            else // dono child null so if any nephew on lower level move to that.
	                p = getNextRight(p);
	        }
	            return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mBT root=new mBT(10);
		root.left = new mBT(8);
		root.right = new mBT(2);
		root.left.left = new mBT(3);
		root.right.right = new mBT(90);

	//	connect(root);
	//	connectNodes(root);
	//	Connect(root);
		connectREV(root);
		
		int a = root.nextright != null ? 
				root.nextright.data : -1;
		int b = root.left.nextright != null ? 
				root.left.nextright.data : -1;
		int c = root.right.nextright != null ?
				root.right.nextright.data : -1;
		int d = root.left.left.nextright != null ?
				root.left.left.nextright.data : -1;
		int e = root.right.right.nextright != null ? 
				root.right.right.nextright.data : -1;

		// Now lets print the values
		System.out.println("Following are populated nextright pointers in "
				+ " the tree(-1 is printed if there is no nextright)");
		System.out.println("nextright of " + root.data + " is " + a);
		System.out.println("nextright of " + root.left.data + " is " + b);
		System.out.println("nextright of " + root.right.data + " is " + c);
		System.out.println("nextright of " + root.left.left.data + 
				" is " + d);
		System.out.println("nextright of " + root.right.right.data + 
				" is " + e);
	}

	public static void connectREV(mBT root)
	{
		if(root==null)
			return;
		
		root.nextright=null;  // no other node at the same level as that of root.
		
		while(root!=null)
		{
			mBT q=root;
			// join children of p with children of other nodes at present at the same level  as that of p.
			while(q!=null)
			{
				if(q.left!=null)
				{
					if(q.right!=null)
					{
						q.left.nextright=q.right;
					}
					else{
					q.left.nextright=getNextRight(q);
					}
				}
			
				else if(q.right!=null)
					q.right.nextright=getNextRight(q);
				
				q=q.nextright;
			}
			//done for one level.Proceed with the others
			if(root.left!=null)
				root=root.left;
			else if(root.right!=null)
				root=root.right;
			else
				root=root.nextright;
			
		}
		
		
	}
	
}
