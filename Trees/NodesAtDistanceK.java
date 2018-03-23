
package TreeRevision;

import java.sql.Array;
import java.util.ArrayList;

import org.omg.CORBA.INTERNAL;

import LinkListRevision.Node;


public class NodesAtDistanceK {
	
	public static void NodesAtdepthK(BinaryTree<Integer> root,int k)
	{
		if(root==null)
			return;
		if(k==0)
			System.out.println(root.data+ " , ");
		NodesAtdepthK(root.left, k-1);
		NodesAtdepthK(root.right, k-1);
		
	}

	public static void nodesAtK(BinaryTree<Integer> root,int k,BinaryTree<Integer> ele,ArrayList<BinaryTree<Integer>> ancestor)
	{
		if(root==null)
			return;
		
		if(root.data==ele.data)
		{
			NodesAtdepthK(root, k);
			while(!ancestor.isEmpty())
			{
				BinaryTree<Integer> smallroot=ancestor.remove(ancestor.size()-1);
				k=k-1;
				if(k==0)
					System.out.println(smallroot.data + ",");
				
				if(root==smallroot.left)
				{
					NodesAtdepthK(smallroot.right, k-1);
				}
				else if(root==smallroot.right)
				{
					NodesAtdepthK(smallroot.left, k-1);
				}
			}
		}
		else if(root.data<ele.data)
		{
			ancestor.add(root);
			nodesAtK(root.right, k, ele, ancestor);
		}
		else
		{
			ancestor.add(root);
			nodesAtK(root.left, k, ele, ancestor);
		}
	}
	
	
	// bst structure hai tree ka
	public static void find(BinaryTree<Integer> root,int k,ArrayList<BinaryTree<Integer>> list,
			BinaryTree<Integer> ele )
	{
		if(root==null)
			return;


		// root mil  gayi 
		if(root.data==ele.data){
			
			// print down nodes
			NodesAtdepthK(root, k);
			while(!list.isEmpty())
			{
				BinaryTree<Integer> parent=list.get(list.size()-1);
				k=k-1;
				if(k==0)
					System.out.println(parent.data);
				else{
				if(root==parent.left)
				{
					NodesAtdepthK(parent.right, k-1);
				}
				else if(root==parent.right)
				{
					NodesAtdepthK(parent.left, k-1);
				}
				}
				root=parent;
				list.remove(list.size()-1);
				
			}
		}
		else if(root.data<ele.data)
		{
			list.add(root);
			find(root.right, k, list, ele);
		}
		else
		{
			list.add(root);
			find(root.left, k, list, ele);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		BinaryTree<Integer> ele=new BinaryTree<>(8);
//     find(root, 2, new ArrayList<>(), ele);
		nodesAtK(root, 1, ele, new ArrayList<>());
		
	}
	
	
	
	
}
//20 8 22 4 12 -1 -1  -1 -1 10 14 -1 -1 -1 -1
