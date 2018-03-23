package DynamicProgramming;

class treenode
{
	int value;
	int count;
	treenode left,right;
	
	public treenode(int a) {
		value=a;
		count=-1;
		left=null;
		right=null;
	}
}
public class VertexCoverProblem {

	public static int value(treenode t)
	{
		// no node in tree ie tree is empty
		if(t==null)
			return 0;
		
		// only 1 node in tree means 0 edge so vertex cover=0
		if(t.left==null && t.right==null)
			return 0;
		
		// if value is computed already then directly use result.
		if(t.count!=-1)
			return t.count;
		
		else
		{
			// we are including the current node
			//if we include current node,we need to check just for its children
			int ans1= 1 + value(t.left) + value(t.right);
			
			// if we exclude current node,we must include both of the children 
			//	and then call for grandchildren of current node.
			int ans2= 0;
			if(t.left!=null)
			{
				ans2+=1+value(t.left.left) + value(t.left.right);
			}
			
			if(t.right!=null)
				ans2+=1+value(t.right.left) + value(t.right.right);
			
			// assign count to minimum value
			t.count=Math.min(ans1, ans2);
		}
		return t.count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treenode t=new treenode(10);
		t.left=new treenode(20);
		t.right=new treenode(30);
		t.left.left=new treenode(40);
		t.left.right=new treenode(50);
		t.right.right=new treenode(60);
		t.left.right.left=new treenode(70);
		t.left.right.right=new treenode(80);
		System.out.println(value(t));
	}

}
