package TreeRevision;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class MirrorOfNaryTree {

	public static void mirror(Tree<Integer> root)
	{
		if(root==null)
			return ;
		
		ArrayList<Tree<Integer>> child=new ArrayList<>();
		
		while(!root.children.isEmpty())
		{
			child.add(root.children.get(root.children.size()-1));
			root.children.remove(root.children.size()-1);
		}
		root.children=child;
		for(int i=0;i<root.children.size();i++)
			mirror(root.children.get(i));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree<Integer> root=TreeUse.takeinput();
//		Tree<Integer> mirror=null;
//		convert(root, mirror);
//		TreeUse.printTree(mirror);
	
		mirror(root);
		TreeUse.printTree(root);
	}

}
