package TreeRevision;

class ii 
{
    int postindex = 0;
}
public class BSTfromPostOrder {

	
					// o(n^2)
	public static BinaryTree<Integer> construct(int a[],int s,int e)
	{
		if(s>e)
			return null;
		if(s==e)
			return new BinaryTree<>(a[s]);
		
		BinaryTree<Integer> root=new BinaryTree<>(a[e]);
		
		int i=0;
		for(i=s;i<e;i++)
		{
			if(a[i]>=a[e])
			{
				break;
			}
		}
		
		root.left=construct(a, s, i-1);
		root.right=construct(a, i, e-1);
		
		return root;
	}
	
					// o(n)
	
	 
	
	   // A recursive function to construct BST from post[]. 
	    // postii is used to keep track of index in post[].
	public static BinaryTree<Integer> constructTreeUtil(int post[], ii postii,
	            int key, int min, int max, int size) 
	    {
	        // Base case
	        if (postii.postindex < 0)
	            return null;
	 
	        BinaryTree<Integer> root = null;
	 
	        // If current element of post[] is in range, then
	        // only it is part of current subtree
	        if (key > min && key < max) 
	        {
	            // Allocate memory for root of this subtree and decrement
	            // *postii
	            root = new BinaryTree<Integer>(key);
	            postii.postindex = postii.postindex - 1;
	 
	            if (postii.postindex > 0) 
	            {
	                // All nodes which are in range {key..max} will go in 
	                // right subtree, and first such node will be root of right
	                // subtree
	                root.right = constructTreeUtil(post, postii, 
	                        post[postii.postindex],key, max, size);
	 
	                // Contruct the subtree under root
	                // All nodes which are in range {min .. key} will go in left
	                // subtree, and first such node will be root of left subtree.
	                root.left = constructTreeUtil(post, postii, 
	                        post[postii.postindex],min, key, size);
	            }
	        }
	        return root;
	    }
	 
	    // The main function to construct BST from given postorder
	    // traversal. This function mainly uses constructTreeUtil()
	   public static  BinaryTree<Integer> constructTree(int post[], int size) 
	    {
	        ii index = new ii();
	        index.postindex = size - 1;
	        return constructTreeUtil(post, index, post[index.postindex],
	                Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	    }
	 
	
	
	   public static BinaryTree<Integer> cons(int post[],Index ii,int key,int min,int max,)
	   
	   
	   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1, 7, 5, 50, 40, 10};
		BinaryTreeUse.print(constructTree(a, a.length));

	}

}
