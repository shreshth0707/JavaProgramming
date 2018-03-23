package TreeRevision;

public class SumLeftLeaf {

	static int sum=0;
	
	// ek boolean rakh liya batane ke liye ki left child hai ye ya right.left hai and leaf bhi hai to add iska data.
	public static void sum(BinaryTree<Integer> root,boolean ans)
	{
		if(root==null)
			return;
		
		if(root.left==null && root.right==null)
		{
			if(ans==true)
				sum+=root.data;
		}
		
		sum(root.left, true);
		sum(root.right,false);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> r=BinaryTreeUse.takeInputLevelWise();
		sum(r,true);
		System.out.println(sum);
	}

}
