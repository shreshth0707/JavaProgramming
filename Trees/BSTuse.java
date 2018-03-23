package TreeRevision;

public class BSTuse {

	public static boolean contains(BinaryTree<Integer> root,int ele)
	{
		if(root==null)
			return false;
		if(root.data<ele)
			return contains(root.right, ele);
		else
			return contains(root.left, ele);
	}
	
	public static BinaryTree<Integer> insert(BinaryTree<Integer> root,int ele)
	{
		if(root==null){
			root=new BinaryTree<Integer>(ele);
			return root;
		}
		else if(root.data<ele)
			root.right=insert(root.right, ele);
		else
			root.left=insert(root.left, ele);
			
		return root;
	}	
	
	public static int findmin(BinaryTree<Integer> root)
	{
		BinaryTree<Integer> temp=root;
		while(temp.left!=null)
			temp=temp.left;
		
		return temp.data;
	}
	
	static BinaryTree<Integer> pre=null;
	static BinaryTree<Integer> suc=null;
	public static void inorderSuccPred(BinaryTree<Integer> root,int key)
	{
		if(root==null)
			return;
		
		if(root.data==key)
		{
			//if left subtree is null,pre is rightmost node of left subtree.
			if(root.left!=null)
			{
				BinaryTree<Integer> temp=root.left;
				while(temp.right!=null)
					temp=temp.right;
				
				pre=temp;   // this is inorder predessor
			}
			
			// if right subtree is null, suc is leftmost node of right subtree
			if (root.right!=null)
			{
				BinaryTree<Integer> temp=root.right;
				while(temp.left!=null)
					temp=temp.left;
				
				suc=temp;
			}
		}
		else if(root.data<key)   // go to right subtree
		{
			// going to right subtree  so predessor is root.
			pre=root;
			inorderSuccPred(root.right,key);
		}
		else 
		{
			// going to left subtree so successot is  root.
			suc=root;
			inorderSuccPred(root.left,key);
		}
		
	}
	
	public static BinaryTree<Integer> delete(BinaryTree<Integer> root,int ele)
	{
		if(root==null)
			return null;
		
		if(root.data==ele)
		{
			if(root.left==null && root.right==null) // it is a leaf node
				return null;
			else if(root.left!=null && root.right==null)
				return root.left;
			else if(root.right!=null && root.left==null)
				return root.right;
			else{ // 2 child so replace with min of right subtree or max of left subtree.
				root.data=findmin(root.right);
				root.right=delete(root.right, root.data);
			}
		}
		if(root.data<ele)
		{
			root.right=delete(root.right,ele);
		}
		else if(root.data>ele)
		{
			root.left=delete(root.left,ele);
		}
		return root;
	}
	
	public static BinaryTree<Integer> arrayToBst(int a[],int s,int e)
	{
		if(s>e)
			return null;
		
		int m=s +(e-s)/2;
		BinaryTree<Integer> r=new BinaryTree<>(a[m]);
		r.left=arrayToBst(a, s, m-1);
		r.right=arrayToBst(a, m+1, e);
		
		return r;
	}
	

	static int  i=0;
	public static BinaryTree<Integer> frompreorder(int data[],int max,int min)
	{
		if(i>data.length)
			return null;
		
		BinaryTree<Integer> root=null;
		
		
		// if current data is part of current subtree.
		if(data[i]<max &&data[i]>min)
		{
			root=new BinaryTree<>(data[i]);
			i++;
			
			if(i<data.length)
			{
				root.left=frompreorder(data,root.data,min);
				root.right=frompreorder(data, max, root.data);
			}
		}
		return root;
	}
	
	int currsum=0;
	public static void greaterSumTree(BinaryTree<Integer> root,BSTuse b)
	{
		if(root==null)
			return ;
		
		greaterSumTree(root.right,b);
		int a=root.data;
		root.data=b.currsum;
		b.currsum+=a;
		
		greaterSumTree(root.left,b);
	}
	
	int a=0;
	public void kthlargest(BinaryTree<Integer> root)
	{
		if(root==null)
			return;
		
		kthlargest(root.right);
		a--;  // traversed.
		if(a==0)
		{
			System.out.println(root.data);
			return ;
		}
		
		kthlargest(root.left);
		
	}
	
	int q=0;
	public boolean bstsubtreeingivenrange(BinaryTree<Integer> root,int low,int high)
	{
		if(root==null)
			return true;
		
		boolean l=bstsubtreeingivenrange(root.left, low, high);
		boolean r=bstsubtreeingivenrange(root.right, low, high);
		
		if(root.data<=high && root.data>=low)
		{
			if(l &&r==true)
			{
				q++;
			}
			return (l&&r);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		BinaryTree<Integer> root=null;
		int arr[]={3,1,5,0,2,4,7,6};
		for(int i:arr)
			root=insert(root, i);
		BinaryTreeUse.print(root);
		root=delete(root, 3);
		BinaryTreeUse.print(root);
	*/
	
	//	BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
	//	inorderSuccPred(root,30);
	//	System.out.println(pre.data + " " + suc.data);
	
		
		
//		int arr[]={1, 2, 3, 4, 5, 6, 7};
//		BinaryTreeUse.print(arrayToBst(arr, 0, arr.length-1));
		
//		int a[]={10, 5, 1, 7, 40, 50};
//			BinaryTreeUse.print(frompreorder(a, Integer.MAX_VALUE, Integer.MIN_VALUE));
				
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		BSTuse b=new BSTuse();
	//	greaterSumTree(root,b);
	//	BinaryTreeUse.print(root);
		
		
		
		// behaving as static by using non static method.
/*
		for(int i=1;i<=3;i++){
		b.a=i;
		b.kthlargest(root);
		}
	*/	
		
		b.bstsubtreeingivenrange(root, 1,45);
		System.out.println(b.q);
		
	}

}
//11 2 29 1 7 15 40 -1 -1 -1 -1 -1 -1 35 -1 -1 -1 