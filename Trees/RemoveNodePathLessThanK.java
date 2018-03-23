package TreeRevision;

/*
 * Given a binary tree, a complete path is defined as a path from root to a leaf. The sum of all nodes on that path is defined as the sum of that path. Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.

Note: A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.

Consider the following Binary Tree
          1 
      /      \
     2        3
   /   \     /  \
  4     5   6    7
 / \    /       /
8   9  12      10
   / \           \
  13  14         11
      / 
     15 

For input k = 20, the tree should be changed to following
(Nodes with values 6 and 8 are deleted)
          1 
      /      \
     2        3
   /   \        \
  4     5        7
   \    /       /
    9  12      10
   / \           \
  13  14         11
      / 
     15 

For input k = 45, the tree should be changed to following.
      1 
    / 
   2   
  / 
 4  
  \   
   9    
    \   
     14 
     /
    15 
 * 
 */


public class RemoveNodePathLessThanK {

// remove nodes whose sum of path is less than k.
	public static BinaryTree<Integer> remove(BinaryTree<Integer> root,int sum,int k)
	{
		if(root==null)
			return null;
		sum+=root.data;
		
		if(root.left!=null)
		{
			root.left=remove(root.left, sum, k);
		}
		if(root.right!=null)
		{
			root.right=remove(root.right, sum, k);
		}
		
		if(root.left==null && root.right==null)
		{
			if(sum<k)
			{
				return null;
			}
		}
		return root;
	}
	
		
	public static BinaryTree<Integer> pathlessthanK(BinaryTree<Integer> root,int sum,int k)
	{
		if(root==null)
			return null;
		
		if(root.left==null && root.right==null)
		{
			sum+=root.data;
			if(sum<k)
				root=null;
			
			return root;
		}
		
		BinaryTree<Integer> templ=pathlessthanK(root.left, sum+root.data, k);
		BinaryTree<Integer>tempr=pathlessthanK(root.right, sum+root.data, k);
		
		
		// agar dono child null hai means ki delete ho  gaye hai child node,to check kar ki yahan tak ka sum k se chota hai kya
		// if yes then delete this node also.
		if(templ==null && tempr==null)   
		{
			if(sum<=k)
				root=null;
			
		}
		else
		{
			root.left=templ;
			root.right=tempr;
		}
		
		return root;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
	//	root=pathlessthanK(root, 0, 20);
	//	root=remove(root, 0	, 20);
		root=removeNodesPathLenLessThank(root, 4, 1);
		BinaryTreeUse.print(root);
	}
	
	public static BinaryTree<Integer> removeNodesPathLenLessThank(BinaryTree<Integer> root,int k,int pathlen)
	{
		if(root==null)
			return root;
		
		if(root.left!=null)
		{
			root.left=removeNodesPathLenLessThank(root.left, k, pathlen+1);
		}
		if(root.right!=null)
		{
			root.right=removeNodesPathLenLessThank(root.right, k, pathlen+1);
		}
		
		if(root.left==null && root.right==null)
		{
			if(pathlen<k)
			{
				return null;
			}
		}
		return root;
	}
	
	
	

}
  
// 1 2 3 4 5 6 7 8 9 12 -1 -1 -1 10 -1 -1 -1 13 14 -1 -1 -1 11 -1 -1 15 -1 -1 -1 -1 -1