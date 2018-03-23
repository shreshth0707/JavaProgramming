package TreeRevision;

import java.util.ArrayList;

class height
{
	int h;
	
	public height(int a)
	{
		h=a;
	}
	
}

class d
{
	int data;
	d next;
	d prev;
	
	public d(int d)
	{
		data=d;
		next=null;
		prev=null;
	}
}

public class rough {

	
	public static int dia(BinaryTree<Integer> root,height h)
	{
		if(root==null){
			h.h=0;
			return h.h;
		}
		
		height left=new height(0);
		height right=new height(0);
		
		left.h++;
		right.h++;
		
		
		int ldia=dia(root.left, left);
		int  rdia=dia(root.right,right);
		
		h.h=Math.max(left.h, right.h)+1;    //height of child +1 is the current child.
		return Math.max(left.h+right.h+1, Math.max(ldia, rdia));
	}
	

	public static boolean check(BinaryTree<Integer> root,height h)
	{
		if(root==null){
			h.h=0;
			return true;
		}
		
		height left=new height(0);
		height right=new height(0);
		
		left.h++;
		right.h++;
		
		
		boolean l=check(root.left, left);
		boolean  r=check(root.right,right);
		
		if(Math.abs(left.h-right.h)>1)
			return false;
		
		h.h=Math.max(left.h, right.h)+1;    //height of child +1 is the current child.
		return  l && r;
	}
	
	
	// height ke andar sum store ho rha hai
	public static int maxsumpath(BinaryTree<Integer> root,height h)
	{
		if(root==null){
			h.h=0;
			return h.h;
		}
		
		height left=new height(0);
		height right=new height(0);
		
		left.h=(root.left==null)?0:root.left.data;
		right.h=(root.right==null)?0:root.right.data;
		
		
		int l=maxsumpath(root.left, left);
		int r=maxsumpath(root.right,right);
		
		
		h.h=Math.max(left.h, right.h)+root.data;    //height of child +1 is the current child.
		return Math.max(left.h+right.h +root.data, Math.max(l,Math.max(r, root.data)));
	}
	
	public static d  verticalsum(BinaryTree<Integer> root,d node)
	{
		if(root==null)
			return null;
		
		node.data+=root.data;
		
		if(root.left!=null)
		{
			if(node.prev==null){
				node.prev=new d(0);
				node.prev.next=node;
			}
			node.prev=verticalsum(root.left, node.prev);
		}
		if(root.right!=null)
		{
			if(node.next==null){
			node.next=new d(0);
			node.next.prev=node;
			}
			node.next=verticalsum(root.right, node.next);
		}
		return node;
	}
	
	public static int sumtree(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null)
		{
			int a=root.data;
			root.data=0;
			return a;
		}
		
		int data=root.data;
		
		int left=sumtree(root.left);
		int right=sumtree(root.right);
		
		root.data=left+right;
		return root.data+data;	
	}
	
	
	static BinaryTree<Integer> pre=null;
	static BinaryTree<Integer> curr=null;
	public static BinaryTree<Integer> bttodll(BinaryTree<Integer> root)
	{
		if(root==null)
			return null;
		
		if(root.left!=null)
		{
			bttodll(root.left);
		}
		curr=root;
		
		if(pre==null)
		{
			pre=curr;
		}
		else
		{
			curr.left=pre;
			pre.right=curr;
			pre=curr;
		}
		
		if(root.right!=null)
		{
			bttodll(root.right);
		}
		
		return root;
	}
	
	
	// remove all nodes sum less than k
	public static BinaryTree<Integer> removeallnodes(BinaryTree<Integer> root,int sum,int curr)
	{
		if(root==null)
			return null;
		
		root.left=removeallnodes(root.left, sum, curr+root.data);
		root.right=removeallnodes(root.right, sum, curr+root.data);
		
		int currsum=curr+root.data;
		if(root.left==null && root.right==null)
		{
			if(currsum<sum)
			{
				root=null;
			}
		}
		return root;
	}
	
public static BinaryTree<Integer> pathlenlessthank(BinaryTree<Integer> root,int k,int curr)
{
	if(root==null)
		return null;
	
	
	// update left and right child acc to the condition
	root.left=pathlenlessthank(root.left, k, curr+1);
	root.right=pathlenlessthank(root.right, k, curr+1);
	
	if(root.left==null && root.right==null)
	{
		if(curr+1<k)
		{
			root=null;
		}
	}
	return root;
}
	
	public static void main(String args[])
	{
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		
		/*
		sumtree(root);
		BinaryTreeUse.print(root);
//		System.out.println(maxsumpath(root, new height(1)));
		d node=new d(0);
		node=verticalsum(root, node);
		while(node.prev!=null)
			node=node.prev;
		
		while(node!=null)
		{
			System.out.println(node.data);
			node=node.next;
		}
		
		
		BinaryTree<Integer> key=bttodll(root);
		while(key.left!=null)
		{
			key=key.left;
		}
		while(key!=null)
		{
			System.out.println(key.data);
			key=key.right;
		}
		*/
	//	root=removeallnodes(root, 45,0);
		pathlenlessthank(root, 4, 0);
		BinaryTreeUse.print(root);
		
	} 
}	
