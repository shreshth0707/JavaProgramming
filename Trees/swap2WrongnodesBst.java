package TreeRevision;

import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;

public class swap2WrongnodesBst {

	static BinaryTree<Integer> first=null;
	static BinaryTree<Integer> middle=null;
	static BinaryTree<Integer> last=null;
	static BinaryTree<Integer> prev=null;
	public static void swap(BinaryTree<Integer> root)
	{
		
		// inorder traversal so that root are in sorted order.
		// jab bhi current node is less than its previous ie: not sorted means wrong node.
		if(root!=null){
		swap(root.left);
		
		if(prev!=null && root.data<prev.data)
		{
			if(first==null)
			{
				first=prev;
				middle=root;
			}
			else
				last=root;
		}
		prev=root;
		swap(root.right);
		}
	}
	
	
	
	//solution 2  o(n) space
	

public static void inn(BinaryTree<Integer> a,ArrayList<Integer> in)
{
    if(a==null)
    return;
    
    
    inn(a.left,in);
    in.add(a.data);
    inn(a.right,in);
    
    
}


	public ArrayList<Integer> recoverTree(BinaryTree<Integer> a) {
	    ArrayList<Integer> in=new ArrayList<>();
	    inn(a,in);
	    int ea=-1;
	    int eb=Integer.MAX_VALUE;
	    for(int i=0;i<in.size()-1;i++)
	    {
	        if(in.get(i)>in.get(i+1))
	        {
	            ea=Math.max(ea,in.get(i));
	            eb=Math.min(eb,in.get(i+1));
	            
	        }
	    }
	    ArrayList<Integer> aa=new ArrayList<>();
	    if(ea>eb)
	    {
	        aa.add(eb);
	        aa.add(ea);
	    }
	    else
	    {
	       aa.add(ea);
	       aa.add(eb);
	    }
	    
	    return aa;
	}
//****************************************888*****************************
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree<Integer> r=BinaryTreeUse.takeInputLevelWise();
		swap(r);
		
		// 2 adjaent nodes need to be swapped
		if(last==null)
		{
			int a=first.data;
			first.data=middle.data;
			middle.data=a;
		}
		else  // nodes are distance apart
		{
			int a=first.data;
			first.data=last.data;
			last.data=a;
		}
		BinaryTreeUse.print(r);
	}
	
	
}