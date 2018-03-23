package TreeRevision;

public class CheckAndConvertSumTree {
	
	// i want to return 2 things from the function.
	static class sum
	{
		int v;
		
		public sum(int v)
		{
			this.v=v;
		}
	}
	
	static class mypair
	{
		boolean issum;
		int sumval;
		
		public mypair()
		{
			
		}
		
		public mypair(boolean b,int i)
		{
			this.issum=b;
			this.sumval=i;
		}
		
	}
	
	
	public static mypair checksum(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			return new mypair(true,0);
		}
		else if(root.left==null && root.right==null)
		{
			return new mypair(true,root.data);
		}
		else
		{
			mypair ltree=checksum(root.left);
			mypair rtree=checksum(root.right);
			if(ltree.issum==true && rtree.issum==true && ltree.sumval+rtree.sumval==root.data)
			{
				return new mypair(true,ltree.sumval+rtree.sumval+root.data);
			}
			else
				return new mypair(false,-1);
		}
		
	}
	
	
	
	public static boolean check(BinaryTree<Integer> root,sum s)
	{
		if(root==null){
			s.v=0;
			return true;
		}
		else if(root.left==null &&root.right==null)
			{
				s.v=root.data;
				return true;
			}	
		
		sum l=new sum(0);
		sum r=new sum(0);
		
		boolean left=check(root.left, l);// l will contain value of left subtree
		boolean right=check(root.right, r); // r will contain value of right subtree.
		
		
		if(l.v + r.v==root.data) // modified value is sum of all the children.
		{
			s.v=l.v + r.v+ root.data;
			return true;
		}
		
		else
			return false;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer>  root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(check(root, new sum(root.data)));
		System.out.println(checksum(root).issum);
		
	}

}
