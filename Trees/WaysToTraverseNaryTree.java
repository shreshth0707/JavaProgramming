package TreeRevision;

public class WaysToTraverseNaryTree {

	public static long count(Tree<Integer> root,long array[])
	{
		if(root==null)
			return 0;
		if(root.children.size()==0)
			return 1;
		
		long a=array[root.children.size()];
		for(int i=0;i<root.children.size();i++)
		{
			long b=count(root.children.get(i),array);
			a=a*b;
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long array[]=new long[21];
		array[0]=1;
		for(int i=1;i<21;i++)
		{
			array[i]=array[i-1]*i;
		}
		Tree<Integer> root=TreeUse.takeInputLevelWise();
		System.out.println(count(root, array));

	}

}
