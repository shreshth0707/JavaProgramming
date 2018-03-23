package TreeRevision;


class ht
{
	int h;
}

public class Density {

	static double size=0;
	static double height=0;
	
	// in one traversal
	public static int density(BinaryTree<Integer> root,int level)
	{
		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null)
		{
			if(level>height)
				height=level;
			return 1;
		}
		int l=density(root.left, level+1);
		int r=density(root.right,level+1);
		
		if(l+r+1>size)
			size=l+r+1;
		return l+r+1;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
	//	density(root, 1	);
	//	System.out.println(size/height);
	
		ht h=new ht();
		h.h=0;
		int size=d(root, h);
		System.out.println(size/h.h);
		 
}

}
