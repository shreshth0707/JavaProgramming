package TreeRevision;

import java.util.ArrayList;

public class Solution {
    BinaryTree<Integer> t=new BinaryTree<Integer>();
    ArrayList<Integer> list=new ArrayList<>();
    int count;

    public void fill(BinaryTree<Integer> root)
    {
        if(root==null)
        return;
        
        fill(root.left);
        list.add(root.data);
        fill(root.right);
    }

    public Solution(BinaryTree<Integer> root) {
        
        t=root;
        fill(t);
        count=list.size();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(count==0)
        return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
    	count--;
        return list.get(list.size()-count-1);
    }
    
    public static void main(String args[])
    {
    	BinaryTree<Integer> b=BinaryTreeUse.takeInputLevelWise();
    	Solution s=new Solution(b);
    	while(s.hasNext()!=false)
    		System.out.println(s.next());
    }
    
}

