package TreeRevision;

import java.util.*;

import LinkListRevision.Node;
import arraysRevision.QueueUsinLL;
public class BinaryTreeUse {

	public static void roottoleaf(BinaryTree<Integer> root,ArrayList<Integer> ad)
	{
		if(root==null)
			return ;
		
		ad.add(root.data);
		
		if(root.left==null && root.right==null)
		{
			for(int i:ad)
				System.out.print(i +" ");
			System.out.println();

			return;
		}
		
		
		if(root.left!=null)
		{
			roottoleaf(root.left,ad);
			ad.remove(ad.size()-1);
		}
		if(root.right!=null)
		{
			roottoleaf(root.right, ad);
			ad.remove(ad.size()-1);
		}
	}
	
	public static void leftview(BinaryTree<Integer> root)
	{
		if(root==null)
			return;
		if(root.left!=null)
		{
			System.out.println(root.data);
			leftview(root.left);
		}
		else if(root.right!=null)
		{
			System.out.println(root.data);
			leftview(root.right);
		}
		else   // it is a leaf node.
		{
			System.out.println(root.data);
			return;
		}
	}

	public static BinaryTree<Integer> takeInputLevelWise()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the root data");
		int rootdata=s.nextInt();
		BinaryTree<Integer> root=new BinaryTree<>(rootdata);
		QueueUsinLL<BinaryTree<Integer>> queue=new QueueUsinLL<>();
		queue.enque(root);

		while(!queue.isEmpty())
		{
			BinaryTree<Integer> bt=queue.deque();
			System.out.println("enter left child of " + bt.data);
			int l=s.nextInt();
			if(l!=-1)
			{
				BinaryTree<Integer> temp=new BinaryTree<>(l);
				bt.left=temp;
				queue.enque(temp);
			}
			System.out.println("enter right child of " +bt.data);
			int r=s.nextInt();
			if(r!=-1)
			{
				BinaryTree<Integer> temp=new BinaryTree<>(r);
				bt.right=temp;
				queue.enque(temp);
			}
		}
		return root;
	}

	public static void print(BinaryTree<Integer> root)
	{
		QueueUsinLL<BinaryTree<Integer>> queue=new QueueUsinLL<>();
		queue.enque(root);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> cur=queue.deque();
			System.out.print(cur.data + ":");
			if(cur.left!=null)
			{
				System.out.print(cur.left.data + " is left child,");
				queue.enque(cur.left);
			}
			if(cur.right!=null)
			{
				System.out.print(cur.right.data + " is right child,");
				queue.enque(cur.right);
			}
			System.out.println();
		}
	}

	public static int height(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		return 1 +Math.max(height(root.left), height(root.right));
	}

	public static int diameter(BinaryTree<Integer> root)
	{
		int hleft=height(root.left);
		int hright=height(root.right);
		int d=hleft+hright;

		if(root.left!=null){
			int c=diameter(root.left);
			if(c>d)
				d=c;
		}
		if(root.right!=null){
			int c=diameter(root.right);
			if(c>d)
				d=c;
		}
		return d;

	}

	// using an element as a separator.
	public static void printAtDifferentLines(BinaryTree<Integer> root)
	{
		QueueUsinLL<BinaryTree<Integer>> queue=new QueueUsinLL<>();
		BinaryTree<Integer> temp=new BinaryTree<>(-1);
		queue.enque(root);
		queue.enque(temp);

		while(!queue.isEmpty())
		{
			BinaryTree<Integer> curr=queue.deque();
			if(curr==temp)
			{
				if(!queue.isEmpty()){
					System.out.println();
					queue.enque(temp);
				}
				else
					return;
			}
			else
			{
				System.out.print(curr.data + " ");
				if(curr.left!=null)
				{
					queue.enque(curr.left);
				}
				if(curr.right!=null)
				{
					queue.enque(curr.right);
				}
			}
		}
	}

	public static BinaryTree<Integer> getTreefromPreAndIn(int pre[],int in[],int pres,int ins,int pree,int ine)
	{
		if(ins<=ine){
			BinaryTree<Integer> root=new BinaryTree<Integer>(pre[pres]);
			int i;
			for(i=ins;in[i]!=root.data;i++);

			int leftins=ins;
			int leftinend=i-1;
			int rightins=i+1;
			int rightine=ine;

			int leftpres=pres+1;
			int rightpree=pree;

			int length=leftinend-leftins+1;
			int leftpree=leftpres+length-1;
			int rightpres=leftpree+1;

			root.left=getTreefromPreAndIn(pre, in, leftpres, leftins, leftpree, leftinend);
			root.right=getTreefromPreAndIn(pre, in, rightpres, rightins, rightpree, rightine);

			return root;
		}
		return null;

	}

	public static void printAtDiffLinesAlter(BinaryTree<Integer> root)
	{
		if(root==null)
			return;

		QueueUsinLL<BinaryTree<Integer>> queue=new QueueUsinLL<>();
		queue.enque(root);
		BinaryTree<Integer> temp=new BinaryTree<Integer>(-1);
		queue.enque(temp);

		int i=1;
		StacksUsingLL<BinaryTree<Integer>> stack=new StacksUsingLL<>();
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> top=queue.deque();
			if(top==temp)
			{
				if(i%2==0){
					while(!stack.isEmpty())
						System.out.print(stack.pop().data + " ");
				}
				System.out.println();
				if(queue.isEmpty())
					return;
				queue.enque(temp);
				i++;
			}
			else
			{
				if(i%2==1)
				{
					System.out.print(top.data + " ");
					if(top.left!=null)
					{
						queue.enque(top.left);
					}
					if(top.right!=null)
					{
						queue.enque(top.right);
					}
				}
				else 
				{
					stack.push(top);
					if(top.left!=null)
					{
						queue.enque(top.left);
					}
					if(top.right!=null)
					{
						queue.enque(top.right);
					}
				}
			}
		}
		System.out.println();
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop().data+ " ");
		}
	}

	public static BinaryTree<Integer> lca(BinaryTree<Integer> root,int data1,int data2)
	{
		if(root==null)
			return null;

		if(root.data==data1 || root.data==data2)
			return root;

		BinaryTree<Integer> lans=lca(root.left, data1, data2);
		BinaryTree<Integer> rans=lca(root.right, data1, data2);
		if(lans!=null && rans!=null)
			return root;
		if(lans!=null)
			return lans;
		else
			return rans;

	}

	// not fully complete.donot waste time.
	public static ArrayList<Node<Integer>> listlevel(BinaryTree<Integer> root)
	{
		if(root==null)
			return new ArrayList<Node<Integer>>();

		BinaryTree<Integer> temp=new BinaryTree<Integer>(-1);
		QueueUsinLL<BinaryTree<Integer>> queue=new QueueUsinLL<>();
		queue.enque(root);
		queue.enque(temp);
		ArrayList<Node<Integer>> list=new ArrayList<>();

		Node<Integer> nodes=null;
		Node<Integer> t=null;
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> cur=queue.deque();
			if(cur==temp)
			{

				list.add(nodes);
				nodes=null;
				temp=null;
				if(queue.isEmpty())
					break;
				queue.enque(temp);

			}
			else
			{
				if(nodes==null)
				{
					nodes=new Node<Integer>(cur.data);
					t=nodes;
				}
				else
				{
					t.next=new Node<Integer>(cur.data);
					t=t.next;
				}
			}
		}
		return list;

	}

	static int minlevel=Integer.MAX_VALUE;
	public static void closestLeaf(BinaryTree<Integer> root,int currlevel)
	{
		if(root==null)
			return;
		if(root.left==null && root.right==null && currlevel<minlevel)
			minlevel=currlevel;

		closestLeaf(root.left, currlevel+1);
		closestLeaf(root.right, currlevel+1);
	}


	public static boolean checkBtHeightBalanced(BinaryTree<Integer> root)
	{
		if(root==null)
			return true;
		int ht1=height(root.left);
		int ht2=height(root.right);
		if(Math.abs(ht1-ht2)>1)
			return false;
		return checkBtHeightBalanced(root.left)&& checkBtHeightBalanced(root.right);
	}

	// leaf node se ulta check karte jao ki sum tree form ho raha hai ya nahi.
	//if yes then update the root data with the sum value;
	public static boolean checkBTisSumTree(BinaryTree<Integer> root)
	{
		if(root==null || (root.left==null && root.right==null))
			return true;
		
		checkBTisSumTree(root.left);
		checkBTisSumTree(root.right);
		int l=root.left!=null?root.left.data:0;
		int r=root.right!=null?root.right.data:0;
		
		if(l+r==root.data){
			root.data+=l+r;

			return true;
		}
		return false;

	}

	public static int mindepth(BinaryTree<Integer> root)
	{
		if(root==null)
			return -1;
		
		if(root.left==null && root.right==null)
			return 0;
		
		return 1+Math.min(mindepth(root.left), mindepth(root.right));
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=takeInputLevelWise();
		roottoleaf(root, new ArrayList<Integer>());
		
		print(root);
		//	System.out.println();
		//	printAtDifferentLines(root);
		//	System.out.println();
		//	System.out.println(diameter(root));
		int in[]={4,2,5,1,3,7};
		int pre[]={1,2,4,5,3,7};
		//	printAtDifferentLines(getTreefromPreAndIn(pre, in, 0, 0, pre.length-1, in.length-1));
		//	printAtDiffLinesAlter(root);
		//	ArrayList<Node<Integer>> list=listlevel(root);
		//		for(Node n:list)
		//		{
		//			revision.linklistUse.printll(n);
		//			System.out.println();
		//		}
		//		System.out.println(lca(root, 8, 5).data);
		//	leftview(root);

		//	closestLeaf(root, 0);
		//	System.out.println(minlevel);
//		System.out.println(checkBTisSumTree(root));
		System.out.println(mindepth(root));
	}

}
