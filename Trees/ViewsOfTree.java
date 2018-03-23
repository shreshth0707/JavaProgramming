package TreeRevision;

import java.util.HashSet;
import java.util.Queue;

public class ViewsOfTree {
	
	static int maxlevel=-1;
	
	//display first entry at each level
	public static void leftView(BinaryTree<Integer> root,int currlevel)
	{
		if(root==null)
			return;
		
		if(currlevel>maxlevel)
		{
			System.out.println(root.data);
			maxlevel=currlevel;
		}
		
		if(root.left!=null)
			leftView(root.left, currlevel+1);
		if(root.right!=null)
			leftView(root.right, currlevel+1);
		
	}
	
	// display the last entry at each level.Just call right child before left.
	public static void rightView(BinaryTree<Integer> root,int currlevel)
	{
		if(root==null)
			return ;
		if(currlevel>maxlevel)
		{
			System.out.println(root.data);
			maxlevel=currlevel;
		}
		if(root.right!=null)
		{
			rightView(root.right, currlevel+1);
		}
		if(root.left!=null)
		{
			rightView(root.left, currlevel+1);
		}
	}
	
	
	    
//	4 5 2 -1 -1 3 1 6 7 -1 -1 -1 -1 -1 -1 
	
	// consider 2 values one for left extreme and one for right extreme
	static int maxleft=0;
	static int maxright=-1;  // to avoid root being printed twice.
	public static void topview(BinaryTree<Integer> root,int curr)
	{
		if(root==null)
			return ;
		if(curr<maxleft)
		{
			maxleft=curr;
			System.out.println(root.data);
		}
		
		else if(curr>maxright)
		{
			maxright=curr;
			System.out.println(root.data);
		}
		
		if(root.left!=null)
		{
			topview(root.left, curr-1);
		}
		if(root.right!=null)
		{
			topview(root.right, curr+1);
		}
	}
	
	
	
	static class dll
	{
		int data;
		dll left;
		dll right;
		
	}
	public static void bottomView(BinaryTree<Integer> root,dll head)
	{
		if(root==null)
			return;
		
		head.data=root.data;
		if(root.left!=null)
		{
			if(head.left==null)
			{
				head.left=new dll();
				head.left.right=head;
			}
			bottomView(root.left, head.left);
		}
		if(root.right!=null)
		{
			if(head.right==null)
			{
				head.right=new dll();
				head.right.left=head;
			}
			bottomView(root.right, head.right);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		leftView(root, 0);
		System.out.println();
		maxlevel=-1;
		System.out.println();
		rightView(root, 0);
		System.out.println();
		topview(root, 0);
		System.out.println();
		dll head=new dll();
		head.data=0;
		bottomView(root, head);
		dll temp=head;
		while(temp.left!=null)
			temp=temp.left;
		
		while(temp!=null)
		{
			System.out.print(temp.data+ " ");
			temp=temp.right;
		}
	}

}
