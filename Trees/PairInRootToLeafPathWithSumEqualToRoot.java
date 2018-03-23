package TreeRevision;

import java.util.*;

public class PairInRootToLeafPathWithSumEqualToRoot {

	
	public static boolean exist(BinaryTree<Integer> root,HashSet<Integer> set,int a)
	{
		// end tak pauch gaye pair nahi mila
		if(root==null)
			return false;
		
		int data=root.data;
		
		// pair mil gaya.
		if(set.contains(a-data))
			return true;
		// pair nahi mila to root to hashset mei daaldo taki agar aage pair mile to match kar jaye.
		set.add(data);
		// check ki left half ya right half mei pair exist karta hai kya.
		boolean ans1=exist(root.left, set, a);
		boolean ans2=exist(root.right, set, a);
		// agar han to return true
		if(ans1 || ans2)
			return true;
		// else root ko set se nikalo ans false return kardo to search in other branch.
		set.remove(data);
		return false;
	}
	 // 8 5 4 9 7 -1 11 -1 -1 1 12 3 -1 -1 -1 2 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		HashSet<Integer> set=new HashSet<>();
		System.out.println(exist(root, set, root.data));

	}

}
