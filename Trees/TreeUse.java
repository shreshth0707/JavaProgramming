package TreeRevision;

import java.util.*;

import org.omg.CORBA.INTERNAL;

import arraysRevision.QueueUsinLL;

class pair1{
	int data;
	Tree<Integer> node;
	public pair1(int data,Tree<Integer> root)
	{
		this.data=data;
		this.node=root;
	}
}
public class TreeUse {
	
	public static void inorderIteratively(BinaryTree<Integer> root)
	{
		Stack<BinaryTree<Integer>> stacks=new Stack<>();
		BinaryTree<Integer> curr=root.left;
		stacks.push(root);
		
		// if stack is empty and current is null then stop.
		while(!stacks.isEmpty() || curr!=null)
		{
			while(curr!=null)
			{
				stacks.push(curr);
				curr=curr.left;
			}
			if(curr==null && !stacks.isEmpty())
			{
				System.out.println(stacks.peek().data);
				curr=stacks.pop().right;
			}
		}
	}

	public static boolean identical(BinaryTree<Integer> root1,BinaryTree<Integer> root2)
	{
		if(root1==null && root2==null)
			return true;

		if(root1==null || root2==null)
			return false;

		if(root1.data!=root2.data)
			return false;

		boolean left=identical(root1.left,root2.left);
		boolean right=identical(root1.right, root2.right);
		return (left && right);

	}

	public static void delete(BinaryTree<Integer> root)
	{
		if(root==null)
			return;

		delete(root.left);
		delete(root.right);
		System.out.println(root.data +" deleted");
		root=null;
	}


	public static void RootToLeafPath(BinaryTree<Integer> root,ArrayList<BinaryTree<Integer>> list)
	{
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			list.add(root);
			for(BinaryTree<Integer> i:list)
				System.out.print(i.data+" ");
			System.out.println();
			list.remove(list.size()-1);
			return;
		}

		list.add(root);
		if(root.left!=null)
		{
			RootToLeafPath(root.left, list);
		}
		if(root.right!=null)
		{
			RootToLeafPath(root.right, list);
		}
		list.remove(list.size()-1);
	}

	public static boolean RootToLeafPathSum(BinaryTree<Integer> root,ArrayList<BinaryTree<Integer>> list,int sum,int k)
	{
		if(root==null)
			return true;
		if(root.left==null && root.right==null)
		{
			list.add(root);
			sum+=root.data;
			if(sum==k){
				for(BinaryTree<Integer> i:list)
					System.out.print(i.data+" ");
				System.out.println();
				list.remove(list.size()-1);
				sum=sum-root.data;
				return true;
			}
			return false;
		}

		list.add(root);
		sum+=root.data;
		boolean ans1=true;
		boolean ans2=true;
		if(root.left!=null)
		{
			ans1=RootToLeafPathSum(root.left, list,sum,k);
		}
		if(root.right!=null)
		{
			ans2=RootToLeafPathSum(root.right, list,sum,k);
		}
		list.remove(list.size()-1);
		sum=sum-root.data;

		return ans1 || ans2;
	}


	public static Tree<Integer> takeinput()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the root data");
		int rootdata=s.nextInt();
		if(rootdata!=-1){
			Tree<Integer> root=new Tree<>(rootdata);
			System.out.println("enter  number of children of " + root.data);
			int children=s.nextInt();
			for(int i=0;i<children;i++)
			{
				Tree<Integer> t=takeinput();
				if(t!=null)
					root.children.add(t);
			}
			return root;
		}
		else
			return null;
	}

	public static void printTree(Tree<Integer> root)
	{
		if(root==null)
			return;
		else
		{
			System.out.print(root.data+ ": ");
			for(int i=0;i<root.children.size();i++)
			{
				System.out.print(root.children.get(i).data+",");
			}
			System.out.println();
			for(int i=0;i<root.children.size();i++)
				printTree(root.children.get(i));
		}	
	}
	
	
    public static BinaryTree<Integer> build(ArrayList<Integer> a,int start,int end)
    {
        if(start>end)
            return null;
            
        if(start==end)
        {
            BinaryTree<Integer> c=new BinaryTree<Integer>(a.get(start));
            return c;
        }
            
        int curr=start;
        int max=-1;
        for(int i=start;i<=end;i++)
        {
            if(a.get(i)>max){
             max=a.get(i);
             curr=i;
            }
        }
        BinaryTree<Integer> root=new BinaryTree<Integer>(max);
        root.left=build(a,start,curr-1);
        root.right=build(a,curr+1,end);
        
        return root;    
    }
    

	public static int height(Tree<Integer> root)
	{
		if(root==null)
			return 0;

		if(root.children.size()==0)
			return 1;

		int min=0;
		for(int i=0;i<root.children.size();i++)
		{
			int count=1 +height(root.children.get(i));
			if(count>min)
				min=count;
		}
		return min;

	}

	// returns the msx value
	public static int max(Tree<Integer> root)
	{
		return maxNode(root, Integer.MIN_VALUE);
	}
	private static int maxNode(Tree<Integer> root,int max)
	{
		if(root==null)
			return max;

		int l=Math.max(root.data, max);
		for(int i=0;i<root.children.size();i++)
		{
			int k=maxNode(root.children.get(i), l);
			if(k>l)
				l=k;
		}
		return l;
	}

	public static void elementsAtDepthK(Tree<Integer> root,int k)
	{
		if(k==0){
			System.out.println(root.data + " ");
			return;
		}

		for(int i=0;i<root.children.size();i++)
			elementsAtDepthK(root.children.get(i), k-1);

	}

	public static int nodesGreaterthanX(Tree<Integer> root,int x)
	{
		if(root==null)
			return 0;

		int c=0;
		if(root.data>x)
			c=1;

		for(int i=0;i<root.children.size();i++)
		{
			c+=nodesGreaterthanX(root.children.get(i),x);
		}
		return c;
	}

	public static pair1 maxChildNodeSum(Tree<Integer> root,int sum,Tree<Integer> ans)
	{	
		if(root==null)
			return new pair1(sum,ans);

		int s=root.data;
		for(int i=0;i<root.children.size();i++)
		{
			s+=root.children.get(i).data;
		}
		if(s>sum){
			sum=s;
			ans=root;
		}
		for(int i=0;i<root.children.size();i++)
		{
			pair1 small=maxChildNodeSum(root.children.get(i), sum, ans);
			if(small.data>sum){
				sum=small.data;
				ans=small.node;
			}
		}
		return new pair1(sum,ans); 
	}

	public static void preorder(Tree<Integer> root)  
	{
		if(root==null)
			return;
		System.out.print(root.data + " ");
		for(int i=0;i<root.children.size();i++)
			preorder(root.children.get(i));
	}

	public static void levelorderIter(Tree<Integer> root)
	{
		if(root==null)
			return;

		String str="";

		QueueUsinLL<Tree<Integer>> queue=new QueueUsinLL<>();
		queue.enque(root);
		while(!queue.isEmpty())
		{
			Tree<Integer> curr=queue.deque();
			str+=curr.data+ " ";
			for(int i=0;i<curr.children.size();i++)
				queue.enque(curr.children.get(i));

		}
		System.out.println(str);
	}

	public static void preorderIterative(Tree<Integer> root)
	{
		if(root==null)
			return;

		StacksUsingLL<Tree<Integer>> stack=new StacksUsingLL<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			Tree<Integer> ele=stack.pop();
			System.out.print(ele.data +" ");
			for(int i=0;i<ele.children.size();i++)
				stack.push(ele.children.get(i));
		}		
	}
	public static Tree<Integer> takeInputLevelWise()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter root data");
		int rootdata=s.nextInt();
		Tree<Integer> root=new Tree<>(rootdata);
		QueueUsinLL<Tree<Integer>> queue=new QueueUsinLL<>();
		queue.enque(root);
		while(!queue.isEmpty())
		{
			Tree<Integer> cur=queue.deque();
			System.out.println("enter no of children of "+ cur.data);
			int n=s.nextInt();
			for(int i=0;i<n;i++){
				System.out.println("enter "+ (i+1) +"th child");
				int ele=s.nextInt();
				Tree<Integer> t=new Tree<Integer>(ele);
				queue.enque(t);
				cur.children.add(t);
			}
		}
		return root;
	}

	public static void replaceWithDepth(Tree<Integer> root,int k)
	{
		root.data=k;
		for(Tree<Integer> child:root.children)
			replaceWithDepth(child, k+1);
	}

	// use double node instead.Store largest ans second largest in a pair.
	// dont use below method ..confusing.
	public static int secondLargest(Tree<Integer> root,int l,int sl)
	{
		if(root==null)
			return sl;

		int s=root.data;
		if(l==sl)
		{
			if(s>=l)
				l=s;
			else
				sl=s;
		}
		else 
		{
			if(s>l)
			{
				sl=l;
				l=s;
			}
			else if(s<=l && s>=sl)
			{
				sl=s;
			}
		}
		int small=-1;
		for(Tree<Integer> child:root.children)
		{
			small=secondLargest(child, l, sl);
			if(small>l)
			{
				sl=l;
				l=small;
			}
			else if(small<l && small>sl)
				sl=small;

		}
		return sl;
	}

	public static void LevelOrdertraversal(BinaryTree<Integer> root)
	{
		BinaryTree<Integer> temp=new BinaryTree<>(-1);
		Queue<BinaryTree<Integer>> q=new LinkedList<>();
		q.add(root);
		q.add(temp);
		while(!q.isEmpty())
		{
			BinaryTree<Integer> curr=q.remove();
			if(curr==temp)
			{
				if(q.isEmpty())
					return;
				q.add(temp);
				System.out.println();
			}
			else
			{
				System.out.print(curr.data + " ");
				if(curr.left!=null)
					q.add(curr.left);
				if(curr.right!=null)
					q.add(curr.right);
			}
		}
	}

	public static void LevelOrdertraversal2(BinaryTree<Integer> root)
	{
		BinaryTree<Integer> temp=new BinaryTree<>(-1);
		Queue<BinaryTree<Integer>> q=new LinkedList<>();
		q.add(root);
		int left=1;  // will tell ki level mei kitne element unprocessed hain
		while(!q.isEmpty())
		{
			left--;
			BinaryTree<Integer> curr=q.remove();
			System.out.print(curr.data+ " ");
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
			if(left==0)
			{
				left=q.size();
				System.out.println();
			}
		}
	}

	public static void lv(BinaryTree<Integer> root)
	{
		if(root==null)
			return ;
		
		if(root.left!=null)
		{
			System.out.println(root.data);
			lv(root.left);
		}
		else if(root.right!=null)
		{
			System.out.println(root.data);
			lv(root.right);
		}
		else
		{
			System.out.println(root.data
					);
		}
	}
	
	
	
	public static void levelOrderSpiralB(BinaryTree<Integer> root)
	{
		if(root==null)
			return;
		if(root.left==null || root.right==null)
		{
			System.out.println(root.data);
			return;
		}
		
		Stack<BinaryTree<Integer>> ltr=new Stack<>();
		Stack<BinaryTree<Integer>> rtl=new Stack<>();
		
		ltr.push(root);
		while(!ltr.isEmpty() || !rtl.isEmpty())
		{
			if(!ltr.isEmpty())
			{
				while(!ltr.isEmpty())
				{
					BinaryTree<Integer> t=ltr.pop();
					System.out.println(t.data);
					if(t.left!=null)
						rtl.push(t.left);
					if(t.right!=null)
						rtl.push(t.right);
				}
			}
			
			
			if(!rtl.isEmpty())
			{
				while(!rtl.isEmpty())
				{
					BinaryTree<Integer> t=rtl.pop();
					System.out.println(t.data);
					if(t.right!=null)
						ltr.push(t.right);
					if(t.left!=null)
						ltr.push(t.left);
					
				}
			}
		}		
	}
	
	
	public static void levelorderspiral(BinaryTree<Integer> root){
		BinaryTree<Integer> temp=new BinaryTree<>(-1);
		Queue<BinaryTree<Integer>> q=new LinkedList<>();
		Stack<Integer> stacks=new Stack<>();
		int i=0;
		q.add(root);
		int left=1;  // will tell ki level mei kitne element unprocessed hain
		while(!q.isEmpty())
		{
			left--;
			BinaryTree<Integer> curr=q.remove();
			if(i%2==0){
				stacks.add(curr.data);
			}
			else{
			System.out.print(curr.data+ " ");
			}
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
			if(left==0)
			{
				left=q.size();
				if(i%2==0)
				{
					while(!stacks.isEmpty())
						System.out.print(stacks.pop() + " ");
				}
				i++;
				stacks=new Stack<>();
				System.out.println();
			}
		}
	}
	
	
	public static void path(BinaryTree<Integer> root,int sum,ArrayList<Integer> list,int s,ArrayList<ArrayList<Integer>> ans )
    {
		if(root==null)
			return ;
		if(root.left==null && root.right==null)
		{
			list.add(root.data);
			s+=root.data;
			if(sum==s)
			{
				ArrayList<Integer> clone=new ArrayList<>();
				for(int i:list)
					clone.add(i);
				ans.add(clone);
			}
			s=s-root.data;
			list.remove(list.size()-1);
			return;
		}
		else{
		s+=root.data;
		list.add(root.data);
		path(root.left,sum,list,s,ans);
		path(root.right,sum,list,s,ans);
		s=s-root.data;
		list.remove(list.size()-1);
		}
    }
    
	public static ArrayList<ArrayList<Integer>> pathSum(BinaryTree<Integer> root, int sum) {
	    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
	    ArrayList<Integer> path=new ArrayList<>();
	    path(root,sum,path,0,ans);
	    return ans;
	}

	
	// and tree
	public static int andtree(BinaryTree<Integer> root)
	{
		if(root==null)
			return 1;
		
		if(root.left==null && root.right==null)
			return root.data;
	
		int left=andtree(root.left);
		int right=andtree(root.right);
		root.data=left  &  right;
		return root.data;
	}
	
	public static boolean isMinHeap(BinaryTree<Integer> root)
	{
		if(root==null || (root.left==null && root.right==null))
			return true;
		
		// not a leaf node and perfect btree
		// therefore it will have 2 child.
		
		boolean isLeft=isMinHeap(root.left);
		boolean isRight=isMinHeap(root.right);
		
		if(root.data>root.left.data || root.data>root.right.data)
			return false;
		return isLeft && isRight;
	}
	
	
	// will return no of even nos.
	
	static int count=0;
	public static int oddCountEvenNo(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{ 
			// increment subtree count if leaf node is even
			if(root.data%2==0)
				count++;
			return root.data%2==0?1:0;   //if root is even return 1 else 0 .
		}
		
		// count no of even nodes for left and right subtree.
		int l=oddCountEvenNo(root.left);
		int r=oddCountEvenNo(root.right);
		
		//check if  count of even data nodes is odd acordingly if root is even or odd.
		if(root.data%2==0)
		{
			if((l+r+1)%2==1)
			{
				count++;
			}
			return (l+r+1)%2;
		}
		else
		{
			if((l+r)%2==1)
				count++;
			return (l+r)%2;
		}
		

		// 2 1 3 4 10 8 5  -1 -1 6 -1 -1 -1 -1 -1 -1 -1 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Tree<Integer> root=takeInputLevelWise();
		//printTree(root);
		//		System.out.println(height(root));
		//		System.out.println(max(root));
		//		elementsAtDepthK(root, 2)
		//		System.out.println(nodesGreaterthanX(root, 4));
		//		System.out.println(maxChildNodeSum(root, 0, null).data  + "  " + maxChildNodeSum(root, 0, null).node.data);
		//	preorder(root);
		//	System.out.println();
		//	preorderIterative(root);
		//	replaceWithDepth(root, 0);
		//	printTree(root);
		//	System.out.println(secondLargest(root, 0, 0));
		//	BinaryTree<Integer> rr=BinaryTreeUse.takeInputLevelWise();
		//	ArrayList<BinaryTree<Integer>> r=new ArrayList<>();
		//	System.out.println(RootToLeafPathSum(rr, r,0,21));


		BinaryTree<Integer> r1=BinaryTreeUse.takeInputLevelWise();
//		levelOrderSpiralB(r1);
		inorder(r1);
		//	BinaryTree<Integer> r2=BinaryTreeUse.takeInputLevelWise();
		//	System.out.println(identical(r1, r2))
		//	delete(r1);
		//LevelOrdertraversal2(r1);
	//	levelorderspiral(r1);
			
		
	//	inorderIteratively(r1);
	
	//	lv(r1);
	/*
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		ans=pathSum(r1, 10);
		for(ArrayList<Integer> a:ans)
		{
			for(int i:a)
				System.out.print(i+" ");
			System.out.println();
		}
	*/
	//	min(r1, 1);
	//	System.out.println(min);
//		int a[]={2,1,3};
//		ArrayList<Integer> al=new ArrayList<>();
//		for(int i:a)
//			al.add(i);
//		BinaryTreeUse.printAtDifferentLines(build(al, 0, al.size()-1));
		
//		andtree(r1);
//		BinaryTreeUse.print(r1);
	
//		System.out.println(isMinHeap(r1));
	
//		oddCountEvenNo(r1);
//		System.out.println(count);
	}
	
	static int min=Integer.MAX_VALUE;
	 public static void min(BinaryTree<Integer> root,int current)
	    {
	        if(root==null)
	        {
	            return;
	        }
	        if(root.left==null && root.right==null)
	        {
	            min=Math.min(min,current); 
	            return;
	        }
	        if(root.left!=null)
	        {
	            min(root.left,current+1);
	        }
	        if(root.right!=null)
	        {
	            min(root.right,current+1);
	        }
	         
	    }
	
	 public static void  inorder(BinaryTree<Integer> root)
	 {
		 Stack<BinaryTree<Integer>> s=new Stack<>();
		 s.push(root);
		 
		 while(!s.isEmpty())
		 {
			 BinaryTree<Integer> ele=s.peek();
			 while(ele.left!=null)
			 {
				 s.push(ele.left);
			 }
			 System.out.println(ele.data);
			 ele=s.pop();
			 if(ele.right!=null)
				 s.push(ele.right);
		 }
		 
	 }

}
