package StacksRevision;

import java.util.*;

import org.omg.PortableInterceptor.INACTIVE;

import TreeRevision.BinaryTree;
import TreeRevision.BinaryTreeUse;



public class iterativeTraversals {





	//  preorder means node,then left ,then right.So stack mei pehle right daalo then left.
	public static void preorder(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			root=stack.pop();
			System.out.println(root.data);
			if(root.right!=null)
				stack.push(root.right);
			if(root.left!=null)
				stack.push(root.left);
		}
	}



	// pehle sare left vale ko jane do then khud uske bad right vale.
	public static void inorder(BinaryTreeNode  root)
	{
		Stack<BinaryTreeNode> stack=new Stack<>();	
		BinaryTreeNode curr=root;

		while(!(stack.isEmpty() && curr==null))    // no pending elements left untraversed and current is over.
		{
			while(curr!=null)
			{
				stack.push(curr);
				curr=curr.left;
			}
			if(!stack.isEmpty() && curr==null)    // left subtree over and right vala left.
			{
				root=stack.pop();
				System.out.println(root.data);
				curr=root.right;
			}
		}
	}

	// using 2 stacks.
	// we want reverse preorder traversal.
	public static void postorder(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> stacks1=new Stack<>();
		Stack<BinaryTreeNode> stacks2=new Stack<>();

		stacks1.push(root);
		while(!stacks1.isEmpty())
		{
			root=stacks1.pop();// root sabse pehle stack mei means sabse end mei niklega.
			stacks2.push(root);
			if(root.left!=null)
				stacks1.push(root.left);
			if(root.right!=null)
				stacks1.push(root.right);
		}

		while(!stacks2.isEmpty())
			System.out.println(stacks2.pop().data);
	}

	// using single stack.
	public static void postorderB(BinaryTreeNode root)
	{
		BinaryTreeNode curr=root;
		Stack<BinaryTreeNode> stacks=new Stack<>();

		do
		{
			while(curr!=null)
			{
				if(curr.right!=null)
					stacks.push(curr.right);
				stacks.push(curr);
				curr=curr.left;
			}
			curr=stacks.pop();
			// it means that current.right havent been traversed till now so traverse it first before moving on the root.
			if(curr.right!=null && stacks.peek()==curr.right){
				stacks.pop();
				stacks.push(curr);
				curr=curr.right;
			}
			else
			{
				System.out.println(curr.data);
				curr=null;
			}
		}
		while(!stacks.isEmpty());
	}
	
	public static void P(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> s=new Stack<>();
		BinaryTreeNode curr=root;
		
		do{
			while(curr!=null)
			{
				if(curr.right!=null)
					s.push(curr.right);
				s.push(curr);
				curr=curr.left;
			}
			if(!s.isEmpty()){
			BinaryTreeNode t=s.pop();
			if(  !s.isEmpty() && t.right==s.peek() )
			{
				s.pop();
				s.push(t);
				curr=t.right;
			}
			else
			{
				System.out.println(t.data +" ");
				curr=null;
			}
			}
		}
		while(!s.isEmpty());
	}
	

				// video tushar roy
	public void postOrderItrOneStack(BinaryTreeNode root){
		BinaryTreeNode current = root;
        Deque<BinaryTreeNode> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.addFirst(current);
                current = current.left;
            }else{
            	BinaryTreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeNode node=new BinaryTreeNode(1);
		node.left=new BinaryTreeNode(2);
		node.right=new BinaryTreeNode(3);
		node.left.left=new BinaryTreeNode(4);
		node.left.right=new BinaryTreeNode(5);
		
		/*
		//	preorder(node);
		System.out.println("inorder");
		inorder(node);
		//		postorder(node);

		System.out.println("using 1 stack");
		//		postorderB(node);
		
		System.out.println("yo :" );
		P(node);
		
		*/
		TusharRoyInorder(BinaryTreeUse.takeInputLevelWise());
		
		
		
		
	}

	public static void ino11(BinaryTreeNode root)
	{
		if(root==null)
			return;
		
		Stack<BinaryTreeNode> s=new Stack<>();
		BinaryTreeNode  curr=root;
		
		while(!s.isEmpty() || curr!=null)
		{
			if(curr!=null)
			{
				s.push(curr);
				curr=curr.left;
			}
			else   // curr is null
			{
				BinaryTreeNode r=s.pop();
				System.out.println(r.data);
				if(r.right!=null)
					curr=r.right;
			}
		}
	}
	
	
	public static void ppppp(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode > s=new Stack<>();
		BinaryTreeNode  curr=root;
		
		do
		{
			while(curr!=null)
			{
				if(curr.right!=null)
				s.push(curr.right);
				s.push(curr);
				curr=curr.left;
			}
			
			if(!s.isEmpty())
			{
				BinaryTreeNode  t=s.pop();
				if(!s.isEmpty() &&  s.peek()==t.right)
				{
					s.pop();
					s.push(t);
					curr=t.right;
				}
				else
				{
					System.out.println(t.data);
					curr=null;
				}
			}
			
		}
		while(!s.isEmpty());
	}

	public static void TusharRoyInorder(BinaryTree<Integer> r)
	{
		Stack<BinaryTree<Integer>> stacks=new Stack<>();
		BinaryTree<Integer> root=r;
		while(root!=null || !stacks.isEmpty())
		{
			while(root!=null)
			{
				stacks.push(root);
				root=root.left;
			}
			
			if(!stacks.isEmpty())
			{
				BinaryTree<Integer> ele=stacks.pop();
				System.out.println(ele.data);
				root=ele.right;
			}
			
		}
	}

}
