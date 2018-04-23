package StacksRevision;

import java.util.*;

import StacksRevision.stackfindmiddleelement.stack;
import arraysRevision.Node;
public class ancestorsOfBinaryTreeItera {

	// idea is postorder traversal.
	public static void Ancestors(BinaryTreeNode root,int key)
	{
		Stack<BinaryTreeNode> stacks=new Stack<>();
		while(true)
		{
			// root agar null nahi hai and key bhi nahi hai then add root first and then add root.left by 
			// changing root to root.left;
			while(root!=null && root.data!=key)
			{
				stacks.push(root);
				root=root.left;
			}
			
			if(root!=null && root.data==key)
				break;
			
			// root is now null
			if(stacks.peek().right==null)
			{
				root=stacks.pop();
				while(!stacks.isEmpty() && stacks.peek().right==root)
					root=stacks.pop();
			}
			
			// stacks.peek().right!=null to right vale to root banao and continue traversing.
			root=stacks.isEmpty()?null:stacks.peek().right;
		}
		while(!stacks.isEmpty())
		{
			System.out.println(stacks.pop().data);
		}
	}
	
	
	
	public static void main(String[] args) {
			// TODO Auto-generated method stub
		BinaryTreeNode node=new BinaryTreeNode(1);
		node.left=new BinaryTreeNode(2);
		node.right=new BinaryTreeNode(3);
		node.left.left=new BinaryTreeNode(4);
		node.left.right=new BinaryTreeNode(5);
	//	Ancestors(node, 4);
	//	ances(node, 3);
	}

}
