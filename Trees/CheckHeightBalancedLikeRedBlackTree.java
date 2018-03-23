package TreeRevision;

import org.omg.CORBA.INTERNAL;

class h
{
	int h;
}


public class CheckHeightBalancedLikeRedBlackTree {

	public static boolean  isBalanced(BinaryTree<Integer> root,h max,h min)
	{
		if(root==null)
		{
			max.h=0;
			min.h=0;
			return true;
		}
		
		int lmax = 0,lmin = 0;
		int rmax = 0,rmin = 0;
		
		if(isBalanced(root.left,max,min)==false)
			return false;
		if(isBalanced(root.right,max,min)==false)
			return false;
		
		max.h=Math.max(lmax,rmax)+1;
		min.h=Math.min(lmin, rmin) +1;
		
		if(max.h<=2*min.h)
			return true;
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		h max = null;
		h min = null;
		System.out.println(isBalanced(root,max,min));
	}

}
