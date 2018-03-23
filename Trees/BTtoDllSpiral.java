package TreeRevision;

import java.util.*;

public class BTtoDllSpiral {

	public static void convert(BinaryTree<Integer> root)
	{
		Deque<BinaryTree<Integer>> deque=new LinkedList<>();
		deque.addFirst(root);
		// stack will store the final ans
		Stack<BinaryTree<Integer>> stacks=new Stack<>();
		int level=0;
		while(!deque.isEmpty())
		{
			int count=deque.size();
			// even level hai ie: already in reverse,we want next level to be in sequence
			if(level%2==0)
 			{
				//trick:to handle operations
				//  popiing from last so add to front
				while(count>0)
				{
					BinaryTree<Integer> curr=deque.pollLast();
					stacks.push(curr);
					
					if(curr.right!=null)
					{
						deque.addFirst(curr.right);
					}
					
					if(curr.left!=null)
					{
						deque.addFirst(curr.left);
					}
					
					count--;
					
				}
				
			}
			else   // level is odd.
			{
				
				// popping from first and adding in last.
				while(count>0)
				{
					BinaryTree<Integer> curr=deque.pollFirst();
					stacks.push(curr);
					
					if(curr.left!=null)
					{
						deque.addLast(curr.left);
					}
					if(curr.right!=null)
					{
						deque.addLast(curr.right);
					}
					count--;
				}
			}
			level++;
		}
		
		while(!stacks.isEmpty())
		{
			System.out.print(stacks.pop().data+ " ");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		convert(root);
	}

}
