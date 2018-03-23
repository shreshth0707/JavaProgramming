package TreeRevision;

public class SubtreeWithGivenSum {

	static boolean ans=false;
	public static int sum(BinaryTree<Integer> root,int sum)
	{
		if(ans==true)
		return Integer.MIN_VALUE;
			
		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null)
			return root.data;
		
		int left=sum(root.left,sum);
		int right=sum(root.right,sum);
		
		if(left+right+root.data==sum)
		{
			System.out.println("true");
			ans=true;
		}
		
		return left+right+root.data;
		
	}
	 
	// 8 5 4 9 7 -1 11 -1 -1 1 12 3 -1 -1 -1 2 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		sum(root, 15);	
		if(ans==false)
			System.out.println("false");
	}

}
