package TreeRevision;

import java.util.LinkedList;
import java.util.Queue;

import arraysRevision.Node;

public class LeftmostRightmostNode {

	public static void print(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;
	
		Queue<BinaryTree<Integer>> q=new LinkedList();
		q.add(root);
		BinaryTree<Integer> nulle=new BinaryTree<>(-1);
		q.add(nulle);
		boolean start=false;
		while(!q.isEmpty())
		{
			BinaryTree<Integer> p=q.poll();
			if(p.data!=-1)
			{
				if(start==true)
				{
					System.out.println(p.data);
					start=false;
				}
				if(q.isEmpty())
				{
					return;
				}
				if(q.peek().data==-1)
				{
					System.out.println(p.data);
				}
				
				if(p.left!=null)
				q.add(p.left);
				if(p.right!=null)
					q.add(p.right);
				
			}
			else if(p.data==-1)
			{
				start=true;
				q.add(nulle);
			}	
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		print(root);
		
	}

}
