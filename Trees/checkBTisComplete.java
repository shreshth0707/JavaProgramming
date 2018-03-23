package TreeRevision;

public class checkBTisComplete {

	public static int count(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		return 1+ count(root.left)+count(root.right);
	}
	
	public static boolean check(BinaryTree<Integer> root,int index,int count)
	{
		if(root==null)
			return true;
		if(index>=count)  //  indexing from 1.
			return false;
		return check(root.left,2*index+1,count) && check(root.right,2*index+2,count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		int count=count(root);
		System.out.println(check(root,0,count));
	}

}
