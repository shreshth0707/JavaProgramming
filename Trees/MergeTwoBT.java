package TreeRevision;

import java.util.Stack;

public class MergeTwoBT {

	public static BinaryTree<Integer> merge(BinaryTree<Integer> r1,BinaryTree<Integer> r2)
	{
		if(r1==null && r2==null)
			return null;
		
		if(r1==null)
			return r2;
		if(r2==null)
			return r1;
		
		r1.data=r1.data+r2.data;
		r1.left=merge(r1.left, r2.left);
		r1.right=merge(r1.right, r2.right);
		return r1;
		
	}
	
	public static boolean aremirror(BinaryTree<Integer> a,BinaryTree<Integer> b)
	{
        Stack<BinaryTree<Integer>> s1=new Stack<>();
        Stack<BinaryTree<Integer>> s2=new Stack<>();
        
        s1.push(a);
        s2.push(b);
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            if(s1.isEmpty()|| s2.isEmpty())
            return false;
            
            BinaryTree<Integer> p=s1.pop();
            BinaryTree<Integer> q=s2.pop();
            if(p.data!=q.data)
            return false;
            
            if(p.right!=null)
            s1.push(p.right);
            if(p.left!=null)
            s1.push(p.left);
            if(q.left!=null)
            s2.push(q.left);
            if(q.right!=null)
            s2.push(q.right);
        }
        return true;
 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> r1=BinaryTreeUse.takeInputLevelWise();
		BinaryTree<Integer> r2=BinaryTreeUse.takeInputLevelWise();
	//	r1=merge(r1, r2);
	//	BinaryTreeUse.print(r1);

		System.out.println(aremirror(r1, r2));
	}

}
// 3 6 1 -1 2 -1 7 -1 -1 -1 -1
//2 1 4 5 -1 -1 -1 -1 -1