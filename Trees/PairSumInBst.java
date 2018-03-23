package TreeRevision;

import java.util.ArrayList;
import java.util.Stack;

public class PairSumInBst {
	
	
	//impt approch similar to  finding common nodes in  a bst/.
	public static void pair(BinaryTree<Integer> root,int target)
	{
		Stack<BinaryTree<Integer>> s1=new Stack<>();
		Stack<BinaryTree<Integer>> s2=new Stack<>();
		
		BinaryTree<Integer> root1=root;
		BinaryTree<Integer> root2=root;
		
		
		boolean done1=false;
		boolean done2=false;
		
		
		
		// dono chal rahe hain
		while(true)
		{
			if(root1!=null)
			{
				s1.push(root1);
				root1=root1.left;
			}
			
			else if(root2!=null)
			{
				s2.push(root2);
				root2=root2.right;
			}
			
			// both are null
			else if(!s1.isEmpty()  && !s2.isEmpty())
			{
				if(root1==null && root2==null){
				root1=s1.pop();
				root2=s2.pop();
				}
				
				if(root1.data+root2.data==target  && root.data!=root2.data)
				{
					System.out.println(root1.data+ "  " + root2.data);
					return ;
				}
				
				else if(root1.data+root2.data<target)
				{
					root1=root1.right;
					root2=null;
				}
				else
				{
					root2=root2.left;
					root1=null;
				}
			}
			else  // ek  traversal khatam ho chuka hai
				break;
		}
		System.out.println("no pair found");
	
	}
	
	
	
	
	

	public static void pairsum(BinaryTree<Integer> root,int target)
	{
		BinaryTree<Integer> curr1=root;
		BinaryTree<Integer> curr2=root;


		// we traverse tree in 2 ways :one in inorder and other using reverseinorder
		Stack<BinaryTree<Integer>> s1=new Stack<>();
		Stack<BinaryTree<Integer>> s2=new Stack<>();

		boolean done1=false;
		boolean done2=false;

		int val1=0;
		int val2=0;

		while(true){
			val1=-1;
			val2=-1;
			// first term ke liye chalega  baki tab chalega jab sum ko increase karna hai.
			while(done1==false)
			{
				// traversing the left child first
				if(curr1!=null)
				{
					s1.push(curr1);
					curr1=curr1.left;
				}
				else{
				// no  left child
				if(s1.isEmpty())
					done1=true;   // traversal over
				else
				{
					curr1=s1.pop();
					val1=curr1.data;
					curr1=curr1.right;
					done1=true;
				}
				}
			}

			while(done2==false)
			{
				// traversing the right child first ie:reverse inorder
				if(curr2!=null)
				{
					s2.push(curr2);
					curr2=curr2.right;
				}

				else{
				// no  left child
				if(s2.isEmpty())
					done2=true;   // traversal over
				else
				{
					curr2=s2.pop();
					val2=curr2.data;
					curr2=curr2.left;
					done2=true;
				}
				}
			}

			if(val1 !=val2 && (val1+val2==target))
			{
				System.out.println(val1 +  " " + val2);
				break;
			}
			else if(val1>val2)
			{
				System.out.println("not possible");
				break;
			}
			else if(val1 + val2<target)  // move ahead in inorder traversal
				done1=false;
			else   // move in reverse intorder traversal.
				done2=false;
		}
		
	}

	static ArrayList<Integer> list=new ArrayList<>();
    
    public static void fill(BinaryTree<Integer> root)
    {
        if(root==null)
        return;
        
        fill(root.left);
        list.add(root.data);
        fill(root.right);
    }
    
    public int t2Sum(BinaryTree<Integer> root, int target) {
        
        fill(root);
        int i=0;
        int j=list.size()-1;
        while(i<j)
        {
            int a=list.get(i) + list.get(j);
            if(a==target)
            return 1;
            
            else if (a<target)
            i++;
            else
            j--;
            
            
        } 
        return 0;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		//pairsum(root,19);
	//	PairSumInBst p=new PairSumInBst();
	//	System.out.println(p.t2Sum(root, 40));
			
		pair(root, 30);
	}

}
