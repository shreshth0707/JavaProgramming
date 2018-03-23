package TreeRevision;

import org.omg.CORBA.INTERNAL;

public class DiffBetweenOddEvenLevelNode {

	int oddsum=0;
	int evensum=0;
	
	public static void diff(BinaryTree<Integer> root,int level,DiffBetweenOddEvenLevelNode d)
	{
		if(root==null)
			return;
		
		if(level%2==0)
			d.evensum+=root.data;
		else
			d.oddsum+=root.data;
		
		diff(root.left, level+1, d);
		diff(root.right,level+1,d);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		DiffBetweenOddEvenLevelNode d=new DiffBetweenOddEvenLevelNode();
		diff(root, 0, d);
		System.out.println(Math.abs(d.evensum-d.oddsum));

	}

}
