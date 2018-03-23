package TreeRevision;

import java.util.ArrayList;

class pair
{
	int a;
	int b;
}

public class RootToLeafPathRelativePosition {

	public static void rtl(BinaryTree<Integer> root,int left,ArrayList<pair> list)
	{
		if(root==null)
			return;
		
		pair p=new pair();
		p.a=root.data;
		p.b=left;
		list.add(p);
		
		if(root.left==null && root.right==null)
		{
			int min=Integer.MAX_VALUE;
			for(pair pp:list)
				min=Math.min(min, pp.b);
			
			for(pair pp:list)
			{
				int space=pp.b-min;
				for(int i=1;i<=space;i++)
				{
					System.out.print("_");
				}
				System.out.print(pp.a);
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
		if(root.left!=null)
			rtl(root.left,left-1, list);
		if(root.right!=null)
			rtl(root.right, left+1, list);
		
		list.remove(list.size()-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		rtl(root, 0, new ArrayList<>());
		

	}

}
