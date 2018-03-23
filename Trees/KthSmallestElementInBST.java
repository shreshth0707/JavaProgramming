package TreeRevision;

class bt1
{
	int data;
	int lcount;   // lcount is the element in the left subtree
	int rcount;   // rcount is the element in the right subtree
	bt1 left;     
	bt1 right;
	
	public bt1(int d,int l)
	{
		this.data=d;
		this.lcount=l;
	}
	public bt1(int d)
	{
		this.data=d;
	}
}

public class KthSmallestElementInBST {	
	
	public static bt1 insert(bt1 root,int data)
	{
		if(root==null)
		{
			return new bt1(data);
		}
		
		else if(root.data<=data)
		{
			root.rcount++;
			root.right=insert(root.right, data);
		}
		else
		{
			root.lcount=root.lcount+1;
			root.left=insert(root.left, data);
		}
		return root;
	}
	
	public static bt1 kthsmallest(bt1 root,int k)
	{
		if(root==null)
			return null;
		
		// kth smallest is the current root
		if(k==(root.lcount+1))
			return root;
		
		// more nodes are needed
		else if(k>(root.lcount+1))
		{
			return kthsmallest(root.right, k-root.lcount-1);
		}
		else
		{
			return kthsmallest(root.left, k);
		}
	}
	
	public static bt1 kthlargest(bt1 root,int k)
	{
		if(root==null)
			return root;
		
		if(k==root.rcount+1)
		{
			return root;
		}
		else if(k<(root.rcount+1))
		{
			return kthlargest(root.right, k);
		}
		else
		{
			return kthlargest(root.left, k-root.rcount-1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int ele[] = { 20, 8, 22, 4, 12, 10, 14 };
		 bt1 root=null;
		 for(int i:ele)
			root=insert(root, i);
		 
		 for(int i=1;i<=
				 ele.length;i++){
		 System.out.print(kthsmallest(root, i).data + " ");
		 System.out.println(kthlargest(root, i).data);
		 }
	}

}
