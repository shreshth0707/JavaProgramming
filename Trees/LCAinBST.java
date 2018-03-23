package TreeRevision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LCAinBST {

	public static BinaryTree<Integer> lca(BinaryTree<Integer> root,int a,int b)
	{
		if(root==null)
			return root;
		// both nodes are in left subtree.
		if(a<root.data && b<root.data)
			return lca(root.left, a, b);
		
		//  both nodes are in right subtree.
		if(a>root.data && b>root.data)
			return lca(root.right, a, b);
		
		// agar a or b is equal to root.data, then root is the lca.
		return root;
	}
	
	
	public static void levelordertraversalspiral(BinaryTree<Integer> root)
	{
		Stack<BinaryTree<Integer>> q1=new Stack();
		Stack<BinaryTree<Integer>> q2=new Stack();
		
		q1.add(root);
		while(!q1.isEmpty() ||
				!q2.isEmpty())
		{
			while(!q1.isEmpty())
			{
				System.out.print(q1.peek().data);
				if(q1.peek().left!=null)
					q2.add(q1.peek().left);
				if(q1.peek().right!=null)
					q2.add(q1.peek().right);
				q1.pop();
			}
			System.out.println();
			while(!q2.isEmpty())
			{
				System.out.print(q2.peek().data);
				if(q2.peek().right!=null)
				{
					q1.add(q2.peek().right);
				}
				if(q2.peek().left!=null)
				{
				q1.add(q2.peek().left);	
				}
				q2.pop();
			}
			System.out.println();
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
	//	System.out.println(lca(root, 14, 22).data);
	//	levelordertraversalspiral(root);
		System.out.println(lcab(root, 10, 14).data);
		}

}
