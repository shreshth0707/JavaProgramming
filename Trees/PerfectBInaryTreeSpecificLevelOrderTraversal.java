package TreeRevision;

import java.util.ArrayDeque;
import java.util.Queue;

import arraysRevision.QueueUsinLL;

public class PerfectBInaryTreeSpecificLevelOrderTraversal {

	public static void traversal(BinaryTree<Integer> root)
	{
		Queue<BinaryTree<Integer>> queue=new ArrayDeque<>();
		System.out.println(root.data);
		queue.add(root.left);
		queue.add(root.right);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> q1=queue.remove();
			BinaryTree<Integer> q2=queue.remove();
			System.out.println(q1.data);
			System.out.println(q2.data);
			if(q1.left!=null)
			{
				queue.add(q1.left);
				queue.add(q2.right);
				queue.add(q1.right);
				queue.add(q2.left);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		traversal(root);
	}

}
