package TreeRevision;

import java.util.ArrayList;

public class ReverseAlternateLevel {

	// second inorder traversal
	public static void store(BinaryTree<Integer> root,int level,ArrayList<Integer> list)
	{
		if(root==null)
		return;
		
		store(root.left, level+1, list);
		if(level%2==1)
		{
			list.add(root.data);
		}
		store(root.right, level+1, list);
	}
	
	// first inorder traversal
	public static void assign(BinaryTree<Integer> root,int level,ArrayList<Integer> list)
	{
		if(root==null)
			return;
		
		assign(root.left, level+1, list);
		if(level%2==1)
		{
			root.data=list.get(list.size()-1);
			list.remove(list.size()-1);
		}
		
		assign(root.right, level+1, list);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		ArrayList<Integer> list=new ArrayList<>();
		store(root, 0, list);
		assign(root, 0, list);
		BinaryTreeUse.print(root);
	}

	//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15  -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
	
}
