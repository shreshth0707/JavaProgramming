package TreeRevision;

import java.util.ArrayList;
import java.util.Arrays;

public class AncestorMatrix {

	// a[i][j]==1 if i is ancestor of j
	
	public static BinaryTree<Integer> TreefromMatrix(int mat[][],ArrayList<BinaryTree<Integer>> ancestors)
	{
		if(mat.length==0)
			return null;
		
		BinaryTree<Integer> root=null;
		int desired=-1;
		if(ancestors.isEmpty())
		{
			for(int i=0;i<mat[0].length;i++)
			{
				int count=0;
				for(int j=0;j<mat.length;j++)
				{
					if(mat[j][i]==1)
					{
						break;
					}
					count++;
				}
				if(count==mat.length)
				{
					desired=i;
					break;
				}
			}
			if(desired!=-1)
			{
				root=new BinaryTree<>(desired);
			}
			else
			{
				return null;
			}
		}
		else
		{
			root.left=null;
			root.right=null;
			
			for(int i=0;i<mat[0].length;i++)
			{
				int visited[]=new int[mat.length];
				Arrays.fill(visited, -1);
				for(BinaryTree<Integer> b:ancestors)
					visited[b.data]=0;
				
				for(int j=0;j<mat.length;j++)
				{
					if(mat[j][i]==i)
						visited[j]=1;	
				}
				boolean cc=false;
				for(int zi=0;zi<visited.length;zi++)
				{
					if(visited[zi]==0)
					{
						cc=true;
						break;
					}
				}
				if(cc==false)
				{
					if(root.left==null)
					{
						root.left=
					}
				}
				
			}
			
			
			
		}
		
		
		
	}
	
	
	// construct ancestor matrix from tree.
	public static void ancestorMatrix(int a[][],BinaryTree<Integer> root,ArrayList<BinaryTree<Integer>> ancestor)
	{
		if(root==null)
			return;

		// leaf node ,so set matrix acc to ancestors
		if(root.left==null && root.right==null)
		{
			int j=root.data;
			for(BinaryTree<Integer> r:ancestor)
			{
				int i=r.data;
				a[i][j]=1;
			}
			return;
		}
		// add root to ancestor list and set left and right child.
		ancestor.add(root);
		ancestorMatrix(a, root.left, ancestor);
		ancestorMatrix(a, root.right, ancestor);
		ancestor.remove(ancestor.size()-1);
		
		// left child set right child ke ancestors set,khudko bhi set apko apne ancestors se.
		int j=root.data;
		for(BinaryTree<Integer> r:ancestor)
		{
			int i=r.data;
			a[i][j]=1;
		}
		
	}


	public static int count(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		return 1+count(root.left) + count(root.right);
	}

	public static BinaryTree<Integer> treeFromAncestor(int mat[][],BinaryTree<Integer> curr)
	{
		int r=mat.length;
		int c=mat[0].length;
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		int c=count(root);
		int a[][]=new int[c][c];
		
		ArrayList<BinaryTree<Integer>> list=new ArrayList<>();
		ancestorMatrix(a, root, list);
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(a[i][j] + " ");

			}
			System.out.println();
		}
	}
}
