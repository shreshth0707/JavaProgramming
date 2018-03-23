package TreeRevision;

import java.util.Stack;

public class CommonNodeIn2BST {


	//inorder traversal :left n right.
	public static void common(BinaryTree<Integer> r1,BinaryTree<Integer> r2)
	{
		// construct 2 stacks
		Stack<BinaryTree<Integer>> s1=new Stack<>();
		Stack<BinaryTree<Integer>> s2=new Stack<>();

		while(true)
		{
			if(r1!=null)
			{
				// traverse left nodes first.
				s1.add(r1);
				r1=r1.left;
			}
			else if(r2!=null)
			{
				// traverse left nodes first ie:inorder traversal
				s2.add(r2);
				r2=r2.left;
			}
			// both are  null
			else 
			{
				//  anyone of the stacks is empty ie:no comparison of nodes can be done
				if(s1.isEmpty()  ||  s2.isEmpty())
					break;      

				// both stacks are filled.
				r1=s1.peek();
				r2=s2.peek();

				if(r1.data==r2.data)
				{
					System.out.println(r1.data +" ");
					s1.pop();
					s2.pop();

					r1=r1.right;
					r2=r2.right;

				}
				else if(r1.data<r2.data)   //  first tree ko aage badao 
				{
					s1.pop();
					r1=r1.right;
					r2=null;

				}
				else
				{
					s2.pop();
					r2=r2.right;
					r1=null;
				}

			}
		}

	}

	public static void commons(BinaryTree<Integer> root1,BinaryTree<Integer> root2)
	{
		Stack<BinaryTree<Integer>> s1=new Stack<>();
		Stack<BinaryTree<Integer>> s2=new Stack<>();
		while(true)
		{
			if(root1!=null)
			{
				s1.push(root1);
				root1=root1.left;
			}
			else if(root2!=null)
			{
				s2.push(root2);
				root2=root2.left;
			}
			else
			{

				if(!s1.isEmpty() && !s2.isEmpty())
				{
					BinaryTree<Integer> ele1=s1.peek();
					BinaryTree<Integer> ele2=s2.peek();

					if(ele1.data==ele2.data)
					{
						System.out.println(ele1.data);
						ele1=ele1.right;
						ele2=ele2.right;
						s1.pop();
						s2.pop();
					}

					else if(ele1.data<ele2.data)
					{
						// increase entry for tree1
						ele1=s1.pop();
						ele1=ele1.right;
						ele2=null;
					}
					else
					{
						ele2=s2.pop();
						ele2=ele2.right;
						ele1=null;
					}
				}
				else 
				{
					break;
				}
			}

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> r1=BinaryTreeUse.takeInputLevelWise();

		BinaryTree<Integer> r2=BinaryTreeUse.takeInputLevelWise();
		commons(r1, r2);
	}

}
//5 1 10 0 4 7 -1 -1 -1 -1 -1 -1  9 -1 -1   10 7 20 4 9 -1 -1 -1 -1 -1 -1 
