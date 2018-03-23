package TreeRevision;

public class LargestIdenticalSubtree {

	static int max=-1;
	static BinaryTree<Integer> node=null;

	static String left="";
	static String right="";
	static String str="";
	
	public static int  find(BinaryTree<Integer> root,String str)
	{
		if(root==null)
			return 0;
		
		int ls=find(root.left, left);
		int rs=find(root.right,right);
		
		int size=ls+rs+1;
		if(left.compareTo(right)==0)
		{
			if(size>max)
			{
				max=size;
				node=root;
			}
		}
		str=str+"|" + left + "|";
		str=str+"|" + Integer.toString(root.data)+ "|";
		str=str+"|"+ right+"|";
		
		return size;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		find(root, str);
		BinaryTreeUse.print(root);
		System.out.println(node.data);
	}

}
