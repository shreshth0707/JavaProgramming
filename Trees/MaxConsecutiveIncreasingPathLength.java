package TreeRevision;

public class MaxConsecutiveIncreasingPathLength {

	public static int find(BinaryTree<Integer> root,int prev,int prevlen)
	{
		// root is null so it cant be part of the sequence .Return the prev length.
		if(root==null)
			return prevlen;
		
		// if root is a part of increasing sequence,then make prev len=prevlen+1 and return prevlen +1 
		// +max of leftsubtree,rightsubtree.
		if(root.data==prev+1)
		{
			return Math.max(find(root.left, root.data, prevlen+1), find(root.right, root.data, prevlen+1));
		}
		
		// else a new sequence start from root with len 1
		// so return 1+max leftsubtree,rightsubtree.
		int newpathlen=Math.max(find(root.left, root.data, 1), find(root.right, root.data, 1));
		return Math.max(newpathlen, prevlen);
		
	}
	public static void main(String[] arg1s) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		if(root==null)
			System.out.println(0);
		
		// root is not null so it can be part of sequence beg form it.
		// so prevlen=0;
		System.out.println(find(root, root.data-1, 0));
	}
	
	
	
	
	

}
