package TreeRevision;


/*
 * Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.

The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.

For example, in the following case, Tree1 is a subtree of Tree2.


        Tree1
          x 
        /    \
      a       b
       \
        c


        Tree2
              z
            /   \
          x      e
        /    \     \
      a       b      k
       \
        c
 * 
 * 
 * The idea is based on the fact that inorder and preorder/postorder uniquely identify a binary tree. Tree S is a subtree of T if both inorder and preorder traversals of S arew substrings of inorder and preorder traversals of T respectively.

Following are detailed steps.

1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].

2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].

3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.
 */
public class BinaryTreeSubsetOfAnotherBtree {

	
	public static boolean check(BinaryTree<Integer> t,BinaryTree<Integer> s)
	{
		StringBuffer tin=new StringBuffer("");
		inorder(t, tin);
		StringBuffer tpre=new StringBuffer("");
		preorder(t, tpre);
		
		StringBuffer sin=new StringBuffer("");
		inorder(s, sin);
		StringBuffer spre=new StringBuffer("");
		preorder(s, spre);
		
		if(tin.indexOf(sin.toString())!=-1 && tpre.indexOf(spre.toString())!=-1)
			return true;
			
		if(sin.indexOf(tin.toString())!=-1 && spre.indexOf(tpre.toString())!=-1)
			return true;
		
		else
			return false;
		
	}
	
	public static void preorder(BinaryTree<Integer> root,StringBuffer sb)
	{
		if(root==null)
			return;
		sb.append(""+root.data);
		preorder(root.left, sb);
		preorder(root.right, sb);
	}
	
	public static void inorder(BinaryTree<Integer> root,StringBuffer sb)
	{
		if(root==null)
			return ;
		inorder(root.left, sb);
		sb.append(""+root.data);
		inorder(root.right, sb);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> t=BinaryTreeUse.takeInputLevelWise();
		BinaryTree<Integer> s=BinaryTreeUse.takeInputLevelWise();
		System.out.println(check(t, s));

	}

}
