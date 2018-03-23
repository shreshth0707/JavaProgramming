package TreeRevision;

import java.util.Arrays;


public class DiameterOfTree {


static class hh
{
	int h;
	public hh(int i)
	{
		h=i;
	}
	public hh()
	{
		
	}
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	BinaryTree<Integer> bt=BinaryTreeUse.takeInputLevelWise();
	//	System.out.println(diameter(bt));
	//	hh h=new hh();
	//	System.out.println(diameteroptimised(bt, h));
	//	Tree<Integer> root=TreeUse.takeinput();
	//	System.out.println(dia(root, h));
		System.out.println(diameterD(bt).selfdia);
	}

	

	static class val
	{
		int data;
		
		public val(int d) {
			this.data=d;
		}
	}
	
	
		
	
	
	// not optimised.
	public static int diameterbad(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		int hl=BinaryTreeUse.height(root.left);
		int hr=BinaryTreeUse.height(root.right);
		int hroot=hl+hr+1;

		int ldia=diameterbad(root.left);
		int rdia=diameterbad(root.right);
		return Math.max(ldia, Math.max(rdia, hroot));
	}

	
	
	
	// optimised
	public static int diameteroptimised(BinaryTree<Integer> root,hh height)
	{
		if(root==null)
		{
			height.h=0;	
			return 0;
		}
		
		hh left=new hh();
		hh right=new hh();
		
		left.h++;
		right.h++;
		int ldiameter=diameteroptimised(root.left, left);
		int rdiameter=diameteroptimised(root.right, right);
		
		height.h=Math.max(left.h, right.h)+1;
		
		return Math.max(left.h + right.h+1, Math.max(ldiameter, rdiameter));
	}
	
	// n-ary tree
	public static int dia(Tree<Integer> root,hh h)
	{
		if(root==null)
		{
			h.h=0;    // is root ki height is 0.
			return 0;
		}
		
		hh child[]=new hh[root.children.size()];   //  har child ki ek height
		Arrays.fill(child,new hh(1));
		
		int dia[]=new int[child.length];
		int maxchild=0;
		int max1=0;
		int max2=0;
		for(int i=0;i<dia.length;i++)
		{
			dia[i]=dia(root.children.get(i), child[i]);
			maxchild=Math.max(maxchild, dia[i]);
			//  find the two largest paths from the current node that will form the diameter.
			if(child[i].h>max1)
			{
				max2=max1;
				max1=child[i].h;
			}
			else if(child[i].h<max1)
			{
				max2=child[i].h;
			}
		}
		h.h=max1+max2+1;
		return Math.max(maxchild, 1+max1+max2);
	}



	// Diameter of a BT optimised
	static class myclass
	{
		int selfdia;
		int size;
		public myclass(int c,int s)
		{
			this.selfdia=c;
			this.size=s;
		}
	}

	public static myclass diameterD(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			return new myclass(0, 0);
		}
		else if(root.left==null && root.right==null)
		{
			return new myclass(1, 1);
		}
		else
		{
			myclass left=diameterD(root.left);
			myclass right=diameterD(root.right);
			
			myclass rval=new myclass(0, 0);
			rval.selfdia=Math.max(1+left.size + right.size, Math.max(left.selfdia, right.selfdia));
			rval.size=Math.max(left.size+1, right.size+1);
			return rval;
		}
	}



}


