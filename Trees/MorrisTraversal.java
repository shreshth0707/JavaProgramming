package TreeRevision;

import java.util.Stack;

import org.omg.CORBA.INTERNAL;

public class MorrisTraversal {

	public static void morrisPreOrder(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;


		while(root!=null){
			
			
			if(root.left!=null)
			{
				BinaryTree<Integer> temp=root.left;
				while(temp.right!=null && temp.right!=root)
					temp=temp.right;

				if(temp.right==null)
				{
					temp.right=root;
			//		System.out.println("hello" + root.data);    in case of pre order.
					root=root.left;
				}
				else if(temp.right==root)
				{
					temp.right=null;
					System.out.println("hello" + root.data);
					root=root.right;
				}
			}
			else  // remains same for both pre and in.
			{
				System.out.println("hello" + root.data);
				root=root.right;
			}
		}
	}



	public static void preorderusingstack(BinaryTree<Integer> root)
	{
		if(root==null)
			return;

		Stack<BinaryTree<Integer>> stacks=new Stack<>();
		stacks.push(root);

		while(!stacks.isEmpty())
		{
			BinaryTree<Integer> temp=stacks.pop();
			System.out.println(temp.data);
			if(temp.right!=null)
				stacks.push(temp.right);
			if(temp.left!=null)
				stacks.push(temp.left);
		}		
	}
	/*
	 * 1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
	 */
	public static void inorderusingStack(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;
		Stack<BinaryTree<Integer>> stacks=new Stack<>();
		stacks.push(root);
		BinaryTree<Integer> current=root;
		if(root.left==null){
			System.out.println(root.data);
			current=root.right;
		}
		else {
			current=root.left;
		}
		//  stack mei kuch hai ya current null nahi  hai.
		while(!(stacks.isEmpty()&&current==null)){
			// current null nahi hai to traverse.
			while(current!=null )
			{
				stacks.push(current);
				current=current.left;
			}

			// koi right child jo stack se nikal chuka hai but process nhi hua hai.
			if(!stacks.isEmpty() && current==null)
			{
				current=stacks.pop();
				System.out.println(current.data);
				current=current.right;
			}

		}

	}














	public static void preorder(BinaryTree<Integer> root)
	{
		if(root==null)
			return;

		BinaryTree<Integer> current=root;
		while(current!=null)
		{
			if(current.left==null)
			{
				System.out.println(current.data);
				current=current.right;
			}

			else 
			{
				BinaryTree<Integer> pre=current.left;
				while(pre.right!=null && pre.right!=current)
				{
					pre=pre.right;
				}
				if(pre.right==null)
				{
					pre.right=current;
					System.out.println(current.data);
					current=current.left;
				}
				else
				{
					pre.right=null;
					current=current.right;
				}
			}
		}
	}

	public static void inorderMorris(BinaryTree<Integer> root)
	{
		if(root==null)
			return;

		BinaryTree<Integer> curr=root;
		BinaryTree<Integer> pre=null;

		while(curr!=null)
		{
			if(curr.left==null)
			{
				System.out.println(curr.data);
				curr=curr.right;
			}

			else
			{
				pre=curr.left;
				while(pre.right!=null && pre.right!=curr)
				{
					pre=pre.right;
				}
				if(pre.right==null)
				{
					pre.right=curr;
					curr=curr.left;
				}
				if(pre.right==curr)
				{
					System.out.println(curr.data);
					pre.right=null;
					curr=curr.right;
				}
			}

		}
	}



	public static void inorder(BinaryTree<Integer> root)
	{
		if(root==null)
			return;

		BinaryTree<Integer> current=root;
		BinaryTree<Integer> pre=null;
		while(current!=null)
		{
			if(current.left==null)  //  no left child so print current node and right child par move karo;
			{
				System.out.println(current.data);
				current=current.right;
			}
			else
			{
				pre=current.left;
				while(pre.right!=null && pre.right!=current)
				{
					pre=pre.right;
				}
				if(pre.right==null)   // link banao.pre ke right child current ko banao.
				{
					pre.right=current;
					current=current.left;
				}

				else  // pre.right=current .already link hai,use remove karo and print karo
				{
					pre.right=null;
					System.out.println(current.data);
					current=current.right;
				}
			}
		}

	}


	public static void Morrispreorder(BinaryTree<Integer> root)
	{
		BinaryTree<Integer> current=root;
		BinaryTree<Integer> pre=null;
		while(current!=null)
		{
			if(current.left==null)
			{
				System.out.println(current.data);
				current=current.right;
			}
			else
			{
				pre=current.left;
				while(pre.right!=null && pre.right!=current)
				{
					pre=pre.right;
				}
				if(pre.right==null)
				{
					pre.right=current;
					System.out.println(current.data);
					current=current.left;
				}
				else
				{
					pre.right=null;
					//	System.out.println(current.data);
					current=current.right;
				}
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		//		Morrispreorder(root);
		//		preorder(root);
		//		preorderusingstack(root);
		//		inorderusingStack(root);
		//		inorderMorris(root);
			morrisPreOrder(root);
		//  preordermorris(root);

	}


	public static void preordermorris(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;

		BinaryTree<Integer> pre=null;
		BinaryTree<Integer> curr=root;
		while(curr!=null)
		{
			if(curr.left==null)
			{
				System.out.println(curr.data);
				curr=curr.right;
			}

			else
			{
				pre=curr.left;
				while(pre.right!=null && pre.right!=curr)
				{
					pre=pre.right;
				}
				if(pre.right==null)
				{
					pre.right=curr;
					System.out.println(curr.data);	
					curr=curr.left;
				}
				else if(pre.right==curr)
				{
					pre.right=null;
					curr=curr.right;
				}
			}

		}
	}
}
