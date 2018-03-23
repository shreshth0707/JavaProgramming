package TreeRevision;


import java.util.*;

public class AncestorsAtDistK {

	public static void dist(BinaryTree<Integer> root,int  k)
	{ 
		if(root==null)
			return;
		
		if(k==0)
		{
			System.out.println(root.data);
			return;
		}
		dist(root.left, k-1);
		dist(root.right, k-1);
		
	}
	
	
	public static void ancestors(BinaryTree<Integer> node,int k,ArrayList<BinaryTree<Integer>> list,int target)
	{
		if(node==null)
			return;
		
		if(node.data==target)
		{
			dist(node,k);
			
			for(int i=0;i<list.size();i++)
			{
				BinaryTree<Integer> ele=list.get(list.size()-1);
				list.remove(list.size()-1);
				int newpos=k-i-1;
				
				if(newpos<0);
				else if(newpos==0)
				{
					dist(ele, k-i);
				}
				else
				{
					if(ele.left==node)
					{
						dist(ele.right, newpos-1);
					}
					else if(ele.right==node)
					{
						dist(ele.left, newpos-1);
					}
				}
				node=ele;
			}
			return;
		}
		else{
		list.add(node);
		ancestors(node.left, k, list, target);
		if(list.size()==0)
			return;
		ancestors(node.right, k, list, target);
		if(list.size()==0)
			return;
		list.remove(list.size()-1);
		}
		
	}
	
	
	
	
	
	
	public static void ancestors(BinaryTree<Integer> root,int path[],boolean visited[],int pathlen,int k)
	{
		if(root==null)
			return;

		path[pathlen]=root.data;
		visited[pathlen]=false;    // havent visited it yet
		pathlen++;

		if(root.left==null && root.right==null && pathlen-k-1>=0 && visited[pathlen-k-1]==false)
		{
			System.out.println(path[pathlen-k-1]);
			visited[pathlen-k-1]=true;
			return;
		}

		ancestors(root.left, path, visited, pathlen, k);
		ancestors(root.right, path, visited, pathlen, k);
		
	}
	
	
	static boolean find1=false;
	static boolean find2=false;
	static int level2=0;
	public static BinaryTree<Integer> lca(BinaryTree<Integer> root,int ele1,int ele2,int level)
	{
		if(root==null)
			return null;
		
		
		if(root.data==ele1)
		{
			find1=true;
			level2=level;
			return root;
		}
		if(root.data==ele2)
		{
			find2=true;
			level2=level;
			return root;
		}

		BinaryTree<Integer> left=lca(root.left, ele1, ele2,level+1);
		BinaryTree<Integer> right=lca(root.right,ele1,ele2,level+1);
		
		
		if(left!=null && right!=null)
			return root;
		
		else if(left!=null)
			return left;
		else
			return right;
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		
		/*
		int a=1000;
		int path[]=new int[a];
		boolean visited[]=new boolean[a];
	//	ancestors(root, path, visited, 0, 2);
		ancestors(root, 2, new ArrayList<>(),8 );
		
		
		*/
		
		System.out.println(lca(root, 8, 7,0
				).data);
		System.out.println(level2);
		
		
	}

}
