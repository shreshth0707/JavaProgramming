package TreeRevision;

public class singleValuesSubtree {

	static int count=0;
	public static boolean singleValue(BinaryTree<Integer> root)
	{
		//root==null so can be included but dont increment the count
		if(root==null)
			return  true;
		// leaf node hai, so can be included as valid subtree for bigger trees and increment the count
		if(root.left==null && root.right==null)
		{
			count++;
			return true;
		}
		
		// find if left subtree and right subtree are valid or not. ie:can be included in the higher trees or not
		boolean ans1=singleValue(root.left);
		boolean ans2=singleValue(root.right);
		
		
		
		// if left child is null and right child is not null, then if left child ka data and root ka data is same 
		// and left child is valid for inclusion as a subtree,increment the count
		if(root.left==null && root.right!=null)
		{
			if(root.data==root.right.data && ans2==true)
			{
				count++;
				return true;
			}
			return false;
		}
	
		// if right child is null and left child is not null, then if rihgt child ka data and root ka data is same 
		// and right child is valid for inclusion as a subtree,increment the count
	
		if(root.left!=null && root.right==null)
		{
			if(root.data==root.left.data && ans1==true)
			{
				count++;
				return true;
			}
			return false;
		}	

		// both child not null and their data are equal and can be included as subtree ,increment count
		if(root.left!=null && root.right!=null)
		{
			if(root.data==root.left.data && root.data==root.right.data)
			{
				if(ans1 && ans2)
				{
					count++;
					return true;
				}
			}
			return false;
		}	
		return false;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		singleValue(root);
		System.out.println(count);
	}

}
