package TreeRevision;

/*
 * Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than keys in left and right children, construct the Binary Tree and return root.

Examples:

Input: inorder[] = {5, 10, 40, 30, 28}
Output: root of following tree
         40
       /   \
      10     30
     /         \
    5          28 

Input: inorder[] = {1, 5, 10, 40, 30, 
                    15, 28, 20}
Output: root of following tree
          40
        /   \
       10     30
      /         \
     5          28
    /          /  \
   1         15    20
 */

public class specialTreeFromInorder {
	
	// inorder means ki pehle left child then root and then right child;
	// root is greater than all its child (similar to max heap);
	// find the index jiske left side mei sare usse chote and right side mei sare usse chote
	// use this index as root and recur for left ans right child using left and right half of array
	
	
	
	public static BinaryTree<Integer> special(int array[],int s,int e)
	{	
		int i=0;
		if(s>e)   // start>end then return null as no element left to traverse.
			return null;
		if(s==e)  // only 1 element so return it as individial root.
			return new BinaryTree<>(array[s]);
		
		// find index with max value in the array whose left and right elements are smaller
		for(i=s;i<e;i++)
		{
			if(array[i]>array[i+1])
				break;
			
		}
		// use this as current root
		BinaryTree<Integer> root=new BinaryTree<>(array[i]);
		// recur for left and right child using left ans right half of array
		root.left=special(array, s, i-1);
		root.right=special(array, i+1, e);
		return root;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1, 5, 10, 40, 30, 
                15, 28, 20};
		BinaryTree<Integer> root=special(a, 0, a.length-1);
		BinaryTreeUse.print(root);
	}

}

