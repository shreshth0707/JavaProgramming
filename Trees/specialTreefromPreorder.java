package TreeRevision;

/*
 * Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary tree where every node has either 0 or 2 children. One more array ‘preLN[]’ is given which has only two possible values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]’ indicates that the corresponding node in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node is non-leaf node. Write a function to construct the tree from the given two arrays.

Source: Amazon Interview Question

Example:

Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
Output: Root of following tree
          10
         /  \
        30   15
       /  \
      20   5
 */

import java.nio.channels.Pipe;

import org.omg.CORBA.INTERNAL;

class Index
{
	int index=0;
}

public class specialTreefromPreorder
{
    BinaryTree<Integer> root;
    Index myindex = new Index();
  
    /* A recursive function to create a Binary Tree from given pre[]
       preLN[] arrays. The function returns root of tree. index_ptr is used
       to update index values in recursive calls. index must be initially
       passed as 0 */
    BinaryTree<Integer> constructTreeUtil(int pre[], char preLN[], Index index_ptr, 
                                                     int n, BinaryTree<Integer> temp)
    {
        // store the current value of index in pre[]
        int index = index_ptr.index; 
  
        // Base Case: All nodes are constructed
        if (index == n)
            return null;
  
        // Allocate memory for this BinaryTree<Integer> and increment index for
        // subsequent recursive calls
        temp = new BinaryTree<Integer>(pre[index]);
        (index_ptr.index)++;
  
        // If this is an internal BinaryTree<Integer>, construct left and right subtrees 
        // and link the subtrees
        if (preLN[index] == 'N') 
        {
            temp.left = constructTreeUtil(pre, preLN, index_ptr, n, 
                                                               temp.left);
            temp.right = constructTreeUtil(pre, preLN, index_ptr, n, 
                                                               temp.right);
        }
  
        return temp;
    }
  
    // A wrapper over constructTreeUtil()
    BinaryTree<Integer> constructTree(int pre[], char preLN[], int n, BinaryTree<Integer> node) 
    {
        // Initialize index as 0. Value of index is used in recursion to
        // maintain the current index in pre[] and preLN[] arrays.
        int index = 0;
  
        return constructTreeUtil(pre, preLN, myindex, n, node);
    }
  
    /* This function is used only for testing */
    void printInorder(BinaryTree<Integer> node) 
    {
        if (node == null)
            return;
  
        /* first recur on left child */
        printInorder(node.left);
  
        /* then print the data of BinaryTree<Integer> */
        System.out.print(node.data + " ");
  
        /* now recur on right child */
        printInorder(node.right);
    }
  

    
    
    
    									// my solution
    // idea:if preLN[index]=='L' means ki leaf node hai,directly create karo and return 
    // if 'N',means 2 child hai uske ,index increment karo and recur for left child,index increment karo 
    //and recur for right child.
    // static index so as to reflect its value at every recursive call.
    static int index=0;
    public static BinaryTree<Integer> constructspecialTree(BinaryTree<Integer> root,int pre[],char preLN[])
    {
    	// limit is reached,all nodes traversed return root.
    	if(index>=pre.length)
    		return root;
    	
    	// root create karo with current value of index.
    	root=new BinaryTree<>(pre[index]);
    	// leaf node hai to directly root return kardo.
    	if(preLN[index]=='L')
    		return root;
    	// non leaf node with 2 child.so increment index and recur for left half.Then recur for right half
    	else
    	{	index++;
    		root.left=constructspecialTree(root.left, pre, preLN);
    		index++;
    		if(index<pre.length) // hamesha hoga becoz quesn mei given that non leaf node will have 2 child.
    			root.right=constructspecialTree(root.right, pre, preLN);
    	}
    	return root;
    }
    
    static int in=0;
    public static BinaryTree<Integer> cons(int p[],char s[],BinaryTree<Integer> curr)
    {
    	if(in==p.length)
    		return null;
    	
    	curr=new BinaryTree<>(p[index]);
    	if(s[in]=='L')
    	{
    		return curr;
    	}
    	else
    	{
    		in++;
    		curr.left=cons(p, s, curr.left);
    		in++;
    		in++;
    		if(in<p.length)
    		curr.right=cons(p, s, curr.right);
    	}
    	return curr;
    }
    
    
    
    /*
     * class GfG
{
    static boolean valid=false;
	boolean isCompleteBT(Node root)
    {
        if(root==null)    
        return true;
        
        if(root.left==null && root.right==null)
        return true;
        
        if(root.left==null && root.right==null)
        {
            return false;
        }
        
        if(valid==true && (root.left!=null || root.right!=null))
        {
            return false;
        }
        if(root.left==null && root.right!=null)
        valid=true;
        
        return isCompleteBT(root.left) && isCompleteBT(root.right);
        
	} 
}
     * 
     * 
     */
    
    						// remember this solution only.
    // ****************************************************************************************************//
    
    static int c=0;     // static counter .
    public static BinaryTree<Integer> construct(BinaryTree<Integer> root,int pre[],char prei[])
    {
    	if(c>=pre.length)
    		return root;
    	
    	root=new BinaryTree<>(pre[c]);
    	if(prei[c]=='L')     // it is a leaf node
    		return root;
    	
    	else     // not  a  leaf so recur for left and right child.
    	{
    		c++;
    		root.left=construct(root.left, pre, prei);
    		
    		c++;
    		root.right=construct(root.right, pre, prei);
    	}
    	return root;
    }
    
    
    
    // driver function to test the above functions
    public static void main(String args[]) 
    {
        specialTreefromPreorder tree = new specialTreefromPreorder();
        int pre[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        int n = pre.length;
        BinaryTree<Integer> root=new BinaryTree<>();
 //     BinaryTreeUse.print(constructspecialTree(root, pre, preLN));
        BinaryTreeUse.print(construct(root, pre, preLN));
        
        
        
        // construct the above tree
    //    BinaryTree<Integer> mynode = tree.constructTree(pre, preLN, n, tree.root);
  
        // Test the constructed tree
      //  System.out.println("Following is Inorder Traversal of the" 
     //                                 + "Constructed Binary Tree: ");
      //  tree.printInorder(mynode);
    }
    
   
    
    
    
}