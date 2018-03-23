package TreeRevision;

import org.omg.CORBA.INTERNAL;

class dum
{
	int data;
	dum left;
	dum right;
}

public class BinaryTreeFromParentArray {

	
	// to search for current in the array.
	
	public static BinaryTree<Integer> construct(int array[],int current)
	{
		
		int i=0;
		for(i=0;i<array.length;i++)
		{
			if(array[i]==current)
				break;
		}
		// agar current array mei nahi mila then return null .
		if(i==array.length)
			return null;
		
		// mil gaya to us index ko root ka data banao.
		BinaryTree<Integer> root=new BinaryTree<>(i);
		
		// search for that particular index for left and right child.
		root.left=construct(array, i);
		// left child mil gaya,then jis bhi index pe mila use -2 karo so as to avoid loop
		if(root.left!=null)
		array[root.left.data]=-2;
		//  " "
		root.right=construct(array,i);
		if(root.right!=null)
		array[root.right.data]=-2;
		return root;
	}
	
	
										// method 2
	
	static BinaryTree<Integer> froot;
	public static void create(int parent[],int i,BinaryTree<Integer> created[])
	{
		// node is already created
		if(created[i]!=null)
			return ;
		
		// create new node
		created[i]=new  BinaryTree<>(i);
		
		// no parent so this is the root
		if(parent[i]==-1)
		{
			froot=created[i];
			return;
		}
		
		// if parent node is not created till now, first create it.
		if(created[parent[i]]==null)
		{
			create(parent, parent[i], created);
		}
		
		BinaryTree<Integer> p=created[parent[i]];
		if(p.left==null)
		{
			p.left=created[i];
		}
		else if(p.right!=null)
		{
			p.right=created[i];
		}
	}
	
	public static void createTree(int parent[])
	{
		BinaryTree<Integer> created[];
		
		
		
//		for(int i=0;i<parent.length;i++)
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={1, 5, 5, 2, 2, -1, 3};
		BinaryTree<Integer> root=construct(array, -1);
		BinaryTreeUse.print(root);
	}
				
					
	
	
}
