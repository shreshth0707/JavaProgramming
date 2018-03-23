package TreeRevision;

class res
{
	int value;   // this value will store the value for max sum path between 2 leaves
}

public class MaxPathSumBetweenTwoLeaves {
	
	static int a=Integer.MIN_VALUE;    // this value will store the value for max sum path between 2 leaves
	// this function will return max root to leafpath sum
	public static int maxpath(BinaryTree<Integer> root,res r)
	{
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
		{
			return root.data;
		}
		
		int ls=maxpath(root.left, r);
		int rs=maxpath(root.right, r);
		
		
		if(root.left!=null && root.right!=null){
		// update maxpath sum between 2 leaves.
		//use a new object or static variable to pass primitives as reference.
	//	r.value=Math.max(r.value, ls+rs+root.data); 
		a=Math.max(a, ls+rs+root.data);
		
		// return max of the path.
		return Math.max(ls, rs)+root.data;
		}
		
		return root.left==null ?rs+root.data:ls+root.data;
	}
	
	// ex mei -1 hai tree mei but acc to our input function -1 means ki current node is null so  change it to -2 
	public static void main(String args[])
	{
		BinaryTree<Integer>  root=BinaryTreeUse.takeInputLevelWise();
		res r=new res();
		r.value=Integer.MIN_VALUE;
		int b=maxpath(root, r);
		System.out.println(r.value);
		System.out.println(a);
		
	}

//	-15 5 6  -8 1 3 9 2 6 -1 -1 -1 -1 -1 0 -1 -1 -1 -1 4 -2 -1 -1 10  -1 -1 -1 
	// ans should be 26 centered around 6.
}
