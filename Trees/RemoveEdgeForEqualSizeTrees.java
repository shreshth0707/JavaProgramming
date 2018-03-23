package TreeRevision;

public class RemoveEdgeForEqualSizeTrees {

	static int status=-1;
	static boolean ans=false;

	public static int check(BinaryTree<Integer> root,int count)
	{
		// if total no of nodes is odd ,then cant be divided into 2 parts.
		if(count%2!=0)
			return -1;

		if(root==null)
			return 0;

		if(root.left==null && root.right==null)
			return 1;

		// we get the size of left and right subtree and comapre if root along with left and right subree constitute 
		//half  nodes of ree.
		int left=check(root.left,count);
		int right=check(root.right,count);
		if(left+right+1==(count/2))
		{
			ans=true;
			status=0;
			return -1;
		}
		return left+right+1;
	}


	// get the count of all the nodes in the tree.
	public static int count(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		return 1+count(root.left)+count(root.right);
	}


	static class i
	{
		int ii;
	}

	public static boolean checkif(BinaryTree<Integer> root,int count,i val)
	{

		if(root==null)
			return false;

		if(root.left==null && root.right==null)
		{
			val.ii=1;
			return false;
		}

		i left=new i();
		i right=new i();

		left.ii=0;
		right.ii=0
				;

		boolean l=checkif(root.left, count, left);
		boolean r=checkif(root.right, count, right);


		if(l==true || r==true)
			return true;

		if(left.ii==count/2 || right.ii==count/2)
		{
			return  true;
		}

		val.ii=left.ii+ right.ii+1;
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		int c=count(root);
		System.out.println(checkif(root, c, new i()));

		//		int countc=count(root);
		//		check(root, countc);
		//		if(status==0)
		//			System.out.println(true);
		//		else
		//			System.out.println(false);
	}

}
