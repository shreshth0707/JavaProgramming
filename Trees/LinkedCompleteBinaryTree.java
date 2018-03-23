package TreeRevision;

import java.util.LinkedList;
import java.util.Queue;

import arraysRevision.Node;
import arraysRevision.QueueUsinLL;

public class LinkedCompleteBinaryTree {

	public static BinaryTree<Integer> insert(BinaryTree<Integer> root,int data)
	{
		if(root==null)
			return new BinaryTree<>(data);
		QueueUsinLL<BinaryTree<Integer>> queue=new QueueUsinLL<>();
		queue.enque(root);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> curr=queue.deque();
			
			// if left child is null,insert as left child
			if(curr.left==null){
				curr.left=new BinaryTree<>(data);
				break;
			}
			else
			{
				queue.enque(curr.left);
			}
			
			// if right child is null , insert as right child
			if(curr.right==null){
				curr.right=new BinaryTree<>(data);
				break;
			}
			else
			{
				queue.enque(curr.right);
			}
		}
		return root;
	}
	
	
	
	
	public static BinaryTree<Integer> ins(BinaryTree<Integer> root,int data)
	{
		if(root==null)
			return null;
		
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> rem=queue.remove();
			if(rem.left==null)
			{
				rem.left=new BinaryTree<>(data);
				return root;
			}
			else if(rem.right==null)
			{
				rem.right=new BinaryTree<>(data);
				return root;
			}
			else
			{
				queue.add(rem.left);
				queue.add(rem.right);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		root=ins(root, 6);
		root=ins(root, 7);
		root=ins(root,8);
		BinaryTreeUse.print(root);
	}

}
