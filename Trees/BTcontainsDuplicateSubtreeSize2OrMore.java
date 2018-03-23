package TreeRevision;

import java.util.HashSet;

public class BTcontainsDuplicateSubtreeSize2OrMore {

	// used for serialisation
	public static final String marker="$";
	public static String find(BinaryTree<Integer> root,HashSet<String> set)
	{
		String s="";
		if(root==null)
		{	s+=marker;
		return s;	
		}
		
		// if left subtree has a duplicate subtree.
		String leftsubtree=find(root.left, set);
		if(leftsubtree.equals(s))
			return s;
		
		String rightsubtree=find(root.right, set);
		if(rightsubtree.equals(s))
			return s;
		
		// continue serialisation of tree
		s=s+ root.data+ leftsubtree+rightsubtree;
				
		// more than 1 node of tree to be checked for duplicate(There will be 2 markers)
			if(s.length()>3 && set.contains(s))  // already existing in set
				return "";
			
			// not in set ,so add to set
			set.add(s);
			
			return s;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		System.out.println(find(root, new HashSet<String>()));
	}

}
