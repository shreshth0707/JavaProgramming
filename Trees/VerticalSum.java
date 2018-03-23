package TreeRevision;

import java.util.ArrayList;
import java.util.HashMap;

import arraysRevision.Node;

class dn
{
	int data;
	dn next;
	dn prev;

	public dn(int d)
	{
		this.data=d;
		this.next=null;
		this.prev=null;
	}
}
public class VerticalSum {
	
	

	// ek counter rakh liya left which determines ki root se kitni left position par hai child.
	// since it can be max left by value of height,add height to the factor and store the sum in an array.

	public static void verticalsum(int array[],BinaryTree<Integer> root,int left,int height)
	{
		if(root==null)
			return;

		array[left+height]+=root.data;

		if(root.left!=null)
			verticalsum(array, root.left, left-1, height);

		if(root.right!=null)
			verticalsum(array, root.right, left+1, height);

	}

	public static void verticalsum(BinaryTree<Integer> root)
	{
		dn node=new dn(0);
	//	Sum(root,node);
		sumcal(root, node);
		dn temp=node;
		while(temp.prev!=null)      //  move to left most end
			temp=temp.prev;

		while(temp!=null)
		{
			System.out.print(temp.data+ "-->");
			temp=temp.next;
		}

	}


	public static void sumcal(BinaryTree<Integer> root,dn node)
	{
		if(root==null)
			return ;

		node.data+=root.data;

		if(root.left!=null)
		{
			if(node.prev==null)
			{
				node.prev=new dn(0);
				node.prev.next=node;
			}
			sumcal(root.left, node.prev);
		}
		if(root.right!=null)
		{
			if(node.next==null)
			{
				node.next=new dn(0);
				node.next.prev=node;
			}
			sumcal(root.right,node.next);
		}	
	}




//  ek node create karenge jo ki root ko symbolize karegi.Jab bhi hum left child par jaenge,tab tab hum 
// node ke prev mei add karenge ,jab bhi hum tree ke right child mei jaenge,tab tab hum node ke next 
// mei move karenge.We will check accrdingly ki next and prev null to nahi hai, then we add root.data to it
// to calculate the vertical sum.
private static void Sum(BinaryTree<Integer> root,dn node)
{
	// we need to add root.data to node.data
	node.data+=root.data;
	//left child exist
	if(root.left!=null)
	{
		// prev is null so create it.
		if(node.prev==null)
		{
			node.prev=new dn(0);
			node.prev.next=node;

		}
		// add left child to node.prev
		Sum(root.left, node.prev);
	}

	// right child exist
	if(root.right!=null)
	{

		// next is null so create it
		if(node.next==null)
		{
			node.next=new dn(0);
			node.next.prev=node;
		}
		// add right child to node.right
		Sum(root.right, node.next);
	}
}

static int lmax=0;
static int lmin=0;
public static void traverse(BinaryTree<Integer> root,HashMap<Integer,ArrayList<Integer>> map,int level)
{
    if(root==null)
    return;
    
    if(!map.containsKey(level))
    {
        ArrayList<Integer> al=new ArrayList<>();
        al.add(root.data);
        map.put(level,al);
    }
    else
    {
        ArrayList<Integer> al=map.get(level);
        al.add(root.data);
        map.put(level,al);
    }
    lmax=Math.max(lmax,level);
    lmin=Math.min(lmin,level);
    
    
    if(root.left!=null)
    {
        traverse(root.left,map,level-1);
    }
    if(root.right!=null)
    {
        traverse(root.right,map,level+1);
    }
}
public static  ArrayList<ArrayList<Integer>> verticalOrderTraversal(BinaryTree<Integer> A) {
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
    traverse(A,map,0);
    
    for(int i=lmin;i<=lmax;i++)
    {
        ans.add(map.get(i));
    }
    return ans;
}





public static void main(String[] args) {
	// TODO Auto-generated method stub
	BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
	//		int height=BinaryTreeUse.height(root);
	//		int array[]=new int[2*height+1];
	//		verticalsum(array, root, 0,height);
	//		for(int i:array)
	//		{
	//			if(i!=0)
	//				System.out.println(i);
	//		}
//	verticalsum(root);
	
	ArrayList<ArrayList<Integer>> al=new ArrayList<>();
	al=verticalOrderTraversal(root);
	for(ArrayList<Integer> a:al)
	{
		for(int i:a)
			System.out.print(i +" ");
		System.out.println();
	}
}

}

 
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1  -1
