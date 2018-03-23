package TreeRevision;

public class ExpressionTreeEvaluation {

	/*
	-2:addition
	-3:sub
	-4:mul
	-5:division
	*/
	
	// if root is an operator ,find first operand from left subtree,2nd operand from right subtree
	// and return the ans after applying the operator.
	
	// if root is operand return it.
	public static int solve(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		
		if(root.data<0)
		{
			int a=solve(root.left);
			int b=solve(root.right);
			
			if(root.data==-2)
				return a+b;
			else if(root.data==-3)
				return a-b;
			else if(root.data==-4)
				return a*b;
			else
				return a/b;
		}
		return root.data;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		int ans=solve(root);
		System.out.println(ans);
	} 
}
