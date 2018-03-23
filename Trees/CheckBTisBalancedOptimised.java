package TreeRevision;

//   it is defined in other ques so omitted here.
class Height
{
	int h;
}


public class CheckBTisBalancedOptimised {

			// optimised
	public static boolean balanced(BinaryTree<Integer> root,Height height)
	{
		if(root==null || (root.left==null && root.right==null))
		{
			height.h=0;
			return true;
		}
		Height left=new Height();
		Height right=new Height();
		left.h++;
		right.h++;
		
		boolean ansleft=balanced(root.left,left);
		boolean ansright=balanced(root.right,right);
		
		height.h=Math.max(left.h, right.h)+1;
		if(Math.abs(left.h-right.h)>1)
			return false;
		
		else
		{
			return ansleft && ansright;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		Height h=new Height();
		System.out.println(balanced(root, h));
	}

}
