package TreeRevision;

class info
{
	int min;
	int max;
	boolean isbst;
	int size;     // size of the tree
	int ans;     // size of largest bst subtree
	
	public info(int min,int max,boolean isbst,int size,int ans)
	{
		this.min=min;
		this.max=max;
		this.size=size;
		this.ans=ans;
		this.isbst=isbst;
	}
	public info()
	{
		
	}

}

public class LargestBStSubtree {
	
	public static info Lbst(BinaryTree<Integer> root)
	{ 
		// if root is null,it will be a bst subtree with size 0.
		if(root==null)
		{
			return new info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
		}
		// leaf node will be a subtree with 1 node
		if(root.left==null && root.right==null)
		{
			return new info(root.data, root.data, true, 1, 1);
		}
		
		
		info l=Lbst(root.left);   // recur for left subtree
		info r=Lbst(root.right);	// recur for right subtree.
		
		info ans=new info();
		
		if(root.data<r.min && root.data>l.max && l.isbst && r.isbst)
		{
			ans.min=Math.min(l.min, Math.min(r.min,root.data));   // select min element for this subtree
			ans.max=Math.max(l.max, Math.max(r.max, root.data));	// select max element for this subree
		
			ans.isbst=true; // this is bst
			ans.size=l.size+r.size+1;  // size=size of left subtree + right subtree + 1(for root)
			ans.ans=ans.size;
			return ans;
		}
		
		// not a bst with current root 
		// so no need to set min and max as no ancestor can act as root of subtree
		ans.isbst=false;
		ans.size=l.size+r.size+1;
		ans.ans=Math.max(l.ans, r.ans);
		
		return ans;
	}
	
	public static void main(String args[])
	{
		BinaryTree<Integer> r=BinaryTreeUse.takeInputLevelWise();
		info a=Lbst(r);
		System.out.println("size : " + a.ans);
	}

}

//5 2 4 1 3 -1 -1 -1 -1 -1 -1   size:3
//50 30 60 5 20 45 70 -1 -1 -1 -1 -1 -1   65 80 -1 -1 -1 -1   size:5