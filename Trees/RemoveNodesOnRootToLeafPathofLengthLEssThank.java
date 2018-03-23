package TreeRevision;

public class RemoveNodesOnRootToLeafPathofLengthLEssThank {

/*
 * Given a Binary Tree and a number k, remove all nodes that lie only on root to leaf path(s) of length smaller than k. If a node X lies on multiple root-to-leaf paths and if any of the paths has path length >= k, then X is not deleted from Binary Tree. In other words a node is deleted if all paths going through it have lengths smaller than k.

Consider the following example Binary Tree

               1
           /      \
         2          3
      /     \         \
    4         5        6
  /                   /
 7                   8 
Input: Root of above Binary Tree
       k = 4

Output: The tree should be changed to following  
           1
        /     \
      2          3
     /             \
   4                 6
 /                  /
7                  8
There are 3 paths 
i) 1->2->4->7      path length = 4
ii) 1->2->5        path length = 3
iii) 1->3->6->8    path length = 4 
There is only one path " 1->2->5 " of length smaller than 4.  
The node 5 is the only node that lies only on this path, so 
node 5 is removed.
Nodes 2 and 1 are not removed as they are parts of other paths
of length 4 as well.

If k is 5 or greater than 5, then whole tree is deleted. 

If k is 3 or less than 3, then nothing is deleted.
 */
	
	public static int getHeight(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		
		return 1+ Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static BinaryTree<Integer> remove(BinaryTree<Integer> root,int clevel,int k)
	{
		if(root==null)
			return null;
		
		int lhalf=getHeight(root.left);
		int rhalf=getHeight(root.right);
		if(Math.max(lhalf, rhalf)+clevel<k)
		{
			return null;
		}
		
		root.left=remove(root.left, clevel+1, k);
		root.right=remove(root.right, clevel+1, k);
		
		return root;
	}
	
								// gfg approach(o(n)) bottom-up approach.
	// recursively call the left and right children
	// agar node is a leaf node and it is currently at level<k,then  jis bhi path mei vo hai it has to be removed.
	// apply that to all.
	
	public static BinaryTree<Integer> removegfg(BinaryTree<Integer> root,int currlevel,int k)
	{
		if(root==null)
			return null;
			
		root.left=removegfg(root.left, currlevel+1, k);
		root.right=removegfg(root.right, currlevel+1, k);
	
		if(root.left==null && root.right==null && currlevel<k)
			return null;
		
		return root;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		long i=System.currentTimeMillis();
		root=remove(root, 1, 4);
		BinaryTreeUse.print(root);
		long r=System.currentTimeMillis();
		r=r-i;
		System.out.println("Running time:"+ r);
		
		i=System.currentTimeMillis();
		root=removegfg(root, 1, 4);
		BinaryTreeUse.print(root);
		r=System.currentTimeMillis();
		r=r-i;
		System.out.println("runningtime:" + r);
		
	}

}
//
//1 2 3 4 5 -1  6 7 -1 -1 -1 8 -1 -1 -1 -1 -1 