package TreeRevision;



public class LCAinBT {

	public static BinaryTree<Integer> lca(BinaryTree<Integer> root,BinaryTree<Integer> root1,BinaryTree<Integer> root2)
	{
		if(root==null)
			return null;
		
		if(root.data==root1.data || root.data==root2.data)
			return root;
		
		BinaryTree<Integer> lr=lca(root.left, root1, root2);
		BinaryTree<Integer> rr=lca(root.right, root1, root2);
		
		if(lr!=null && rr!=null)
			return root;
		
		if(lr!=null)
			return lr;
		else
			return rr;
	}
	
	public static int distance(BinaryTree<Integer> root,int a,int level)
	{
		if(root==null)
			return -1;
		
		if(root.data==a)
			return level;
		
		int ll=distance(root.left, a, level+1);
		int rl=distance(root.right, a, level+1);
		
		if(ll!=-1)
			return ll;
		
		else if(rl!=-1)
			return rl;
		else
			return -1;
		
		
	}
	
	
			// lca in o(n)
	
	static boolean a1=false;
	static boolean a2=false;
	
	// will return the lca
	public static BinaryTree<Integer> lcaBetter(BinaryTree<Integer> root,int n1,int n2)
	{
		// tree is empty so return null
		if(root==null)
			return root;
		
		
		// if root is the first key then lca cant be further low
		if(root.data==n1)
		{
			a1=true;
			return root;
		}
		
		// if root is the second key,then lca cannot be further low.return the root.
		if(root.data==n2)
		{
			a2=true;
			return root;
		}
		
		// root is neither first or second key
		// so search in left and right subtree
		
		
		BinaryTree<Integer> lchild=lcaBetter(root.left, n1, n2);
		BinaryTree<Integer> rchild=lcaBetter(root.right, n1, n2);
		
		//both are not null means one is in left child adnd other in right child,so this is lca
		if(lchild!=null && rchild!=null)
			return root;
		
		
		// left side has both the keys
		if(lchild!=null)
			return lchild;
		
		else   // right side has both the keys.
			return rchild;
 		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> r=BinaryTreeUse.takeInputLevelWise();
		int a1=3;
		int a2=5;
		
		System.out.println(lcaBetter(r, a1, a2).data);
		
		/*
		int d1=distance(r, a1, 0);
		int d2=distance(r, a2, 0);
		BinaryTree<Integer> lcaroot=lca(r, new BinaryTree<>(a1), new BinaryTree<>(a2));
		System.out.println(d1 +d2  + distance(r, lcaroot.data, 0));
		*/
	}

}
