package TreeRevision;

import java.util.*;
import java.util.Stack;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;

import arraysRevision.QueueUsinLL;

public class RootToLeafPathInBT {
	
	public static void roottoleafpath(BinaryTree<Integer> root,ArrayList<BinaryTree<Integer>> pending)
	{
		if(root==null){
			print(pending);
			return;
		}
		
		
		pending.add(root);
		if(root.left==null && root.right==null)
		print(pending);
		if(root.left!=null)
		roottoleafpath(root.left, pending);
		if(root.right!=null)
		roottoleafpath(root.right, pending);
		pending.remove(pending.size()-1);
	}

	public static void roottoleaf(BinaryTree<Integer> root,ArrayList<BinaryTree<Integer>> pending)
	{
		if(root==null)
		{
			return;
		}

		pending.add(root);

		if(root.left==null && root.right==null)
		{
			print(pending);
			return;
		}

		if(root.left!=null)
			roottoleaf(root.left, pending);

		if(root.right!=null)
			roottoleaf(root.right, pending);

		ArrayList<BinaryTree<Integer>>nlist=new ArrayList<>();
		for(int i=0;i<pending.size()-1;i++)
			nlist.add(pending.get(i));

		pending=null;
		pending=nlist;


	}

	public static void print(ArrayList<BinaryTree<Integer>> queue)
	{
		for(int i=0;i<queue.size();i++)
		{
			System.out.print(queue.get(i).data+ " ");
		}
		System.out.println();
	}

	public static boolean hasPathSumToK(BinaryTree<Integer> root,int sum)
	{
		if(root==null)
			return(sum==0);

		int subsum=sum-root.data;
		if(subsum==0 && root.left==null && root.right==null)
			return true;

		boolean ans1=hasPathSumToK(root.left, subsum);
		boolean ans2=hasPathSumToK(root.right, subsum);

		return (ans1|| ans2);

	}

	
	public static void iteratvetraversal(BinaryTree<Integer> root)
	{

		Stack<BinaryTree<Integer>> stacks=new Stack<>();
		stacks.add(root);
		ArrayList<BinaryTree<Integer>> pending=new ArrayList<>();
		HashMap<BinaryTree<Integer>, BinaryTree<Integer>> parent=new HashMap<>();
		while(!stacks.isEmpty())
		{
			BinaryTree<Integer> curr=stacks.pop();
			pending.add(curr);
			if(curr.left==null && curr.right==null)  // it is a leaf node.
			{
				BinaryTree<Integer> temp=curr;
				while(parent.containsKey(temp)==true)
				{
					System.out.print(temp.data + " ");
					temp=parent.get(temp);
				}
				System.out.println(temp.data);
				
			}
				if(curr.right!=null){
					stacks.push(curr.right);
					parent.put(curr.right,curr);
				}
				if(curr.left!=null){
					stacks.push(curr.left);
					parent.put(curr.left,curr);
				}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		ArrayList<BinaryTree<Integer>> a=new ArrayList<>();
	//	roottoleafpath(root, a);
	//	HashMap<BinaryTree<Integer>,BinaryTree<Integer>> map=new HashMap<>();
	//	IterativeRootToLeaf(root,map);

//		System.out.println(hasPathSumToK(root, 3));
//		ArrayList<BinaryTree<Integer>> list=new ArrayList<>();
//		roottoleaf(root,list);
		iteratvetraversal(root);
	}

}

//  1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1 

