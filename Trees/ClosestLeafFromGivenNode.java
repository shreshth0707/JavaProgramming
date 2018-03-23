package TreeRevision;
import java.sql.Array;
import java.util.*;

public class ClosestLeafFromGivenNode {

	
	//  find the path till the required node
	static ArrayList<BinaryTree<Integer>> p=new ArrayList<>();
	public static void path(BinaryTree<Integer> root,int curr,ArrayList<BinaryTree<Integer>> path)
	{
		if(root==null)
			return ;
		
		path.add(root);
		if(root.data==curr)
		{
			for(BinaryTree<Integer> b:path)
				p.add(b);
			return;
		}
		
		
		if(root.left!=null)
			path(root.left,curr,path);
		if(root.right!=null)
			path(root.right,curr,path);
		path.remove(path.size()-1);
	}
	
	// find closest leaf from root
	public static int findleaves(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 0;
		
		int left=findleaves(root.left);
		int right=findleaves(root.right);
		
		return 1+Math.min(left, right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		int curr=13;
		// calculate path till the node
		path(root, curr, new ArrayList<>());
		BinaryTree<Integer> node=p.get(p.size()-1);
		
		// calculate nearest leaf from the node itself
		int data=findleaves(node);
		
		// c will store how many level up we are going.
		// for each ancestor we check for nearest leaves in the subtree other than which contains the decendent 
		// according to path of node.
		// c will store total level moved up .1 so as to move to other subtree.
		int c=1;
		for(int i=p.size()-1;i>0;i--)
		{
			BinaryTree<Integer> current=p.get(i);
			BinaryTree<Integer> parent=p.get(i-1);
			
			if(parent.left==current)
			{
				data=Math.min(data, findleaves(parent.right)+c+1);
			}
			else if(parent.right==current)
			{
				data=Math.min(data, findleaves(parent.left)+c+1);
			}
			c++;
		}
		System.out.println(data);
	}

}

//10 12 13 -1 -1 14 -1 -1 -1
// 10 12 13 -1 -1  14 15 21 22 23 24 1 2 3 4 5 6 7 8 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
