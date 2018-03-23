package TreeRevision;

import org.omg.CORBA.INTERNAL;

public class TreeFromLevelAndIn {

	
public static BinaryTree<Integer> constructTree(BinaryTree<Integer> startNode, int[] levelOrder, int[] inOrder,
            int inStart, int inEnd) 
    {
  
        // if start index is more than end index
        if (inStart > inEnd)
            return null;
        	
        // only 1 node and so is the root.
        if (inStart == inEnd)
            return new BinaryTree<>(inOrder[inStart]);
             
        boolean found = false;
        int index = 0;
        
        //.....................................................................
        				// important step
        // it represents the index in inOrder array of element that
        // appear first in levelOrder array.
        for (int i = 0; i < levelOrder.length - 1; i++) 
        {
            int data = levelOrder[i];
            for (int j = inStart; j < inEnd; j++) 
            {
                if (data == inOrder[j]) 
                {
                    startNode = new BinaryTree<>(data);
                    index = j;
                    found = true;
                    break;
                }
            }
            if (found == true)
                break;
        }
  
        //elements present before index are part of left child of startNode.
        //elements present after index are part of right child of startNode.
        startNode.left=constructTree(startNode, levelOrder, inOrder, 
                                                    inStart, index - 1);
        startNode.right=constructTree(startNode, levelOrder, inOrder, 
                                                     index + 1, inEnd);
  
        return startNode;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
        int n = in.length;
        BinaryTree<Integer> root=null;
       // root=constructTree(root, level, in, 0, n-1);
        //root=construct(in, 0, in.length-1, level);
       root=cons(in, level, 0, in.length-1); 
        BinaryTreeUse.print(root);
	}

	public static BinaryTree<Integer> cons(int i[],int l[],int is,int ie)
	{
		if(is>ie)
			return null;
		
		if(is==ie)
		{
			BinaryTree<Integer> node=new BinaryTree<>(i[is]);
			return node;
		}
		
		
		BinaryTree<Integer> root=new BinaryTree<>();
		// find the first element in level order traversal that appears first in inorder traversal
		// it will indicate the root of the current subtree.
		
		// this will indicate the position of root.
		int index=-1;
		for(int z=0;z<l.length;z++)
		{
			for(int j=is;j<=ie;j++)
			{
				if(l[z]==i[j])
				{
					root.data=i[j];
					index=j;
					break;
				}
			}
			if(index!=-1)
				break;
		}
		
		root.left=cons(i, l, is, index-1);
		root.right=cons(i, l, index+1, ie);
		return root;
		
	}
	
	
}
