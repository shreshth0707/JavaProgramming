package TreeRevision;

import java.util.Arrays;

// find min elements in a particular range.
public class SegmentTree {

	public static void constructTree(int input[],int segtree[],int low,int high,int pos)
	{
		if(low==high) //only 1 element ,it is the leaf node
		{
			segtree[pos]=input[low];
			return;
		}
		int  mid=(low+high)/2;
		constructTree(input, segtree, low, mid, 2*pos+1);
		constructTree(input, segtree, mid+1, high, 2*pos+2);
		segtree[pos]=Math.min(segtree[2*pos+1], segtree[2*pos+2]);    // query ke according kya karna hai hume.
	}
	
	public static int rangequery(int segtree[],int qlow,int qhigh,int low,int high,int pos)
	{
		// condition for total overlap
		if(qlow<=low && qhigh>=high)
			return segtree[pos];
		
		// no overlap
		if(qlow>high || qhigh<low)
			return Integer.MAX_VALUE;
				
		// else partial overlap .Search in both the subtree and return the min element. or acc to query.
		int middle=(low+high)/2;
		return Math.min(rangequery(segtree, qlow, qhigh, low, middle, 2*pos+1),
				rangequery(segtree, qlow, qhigh, middle+1, high, 2*pos+2));
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]={-1,2,4,0};
		int treesize=-1;
		double pow=Math.log10(input.length)/Math.log10(2);
		
		if(Math.pow(2, pow)==input.length)
		{
			treesize=(int)(input.length*2-1);
		}
		else
		{
			int ele=(int)Math.pow(2, (int)(pow+1));
			treesize=2*ele-1;
		}
		int segtree[]=new int[treesize];
		Arrays.fill(segtree, Integer.MAX_VALUE);
		constructTree(input, segtree, 0, input.length-1, 0);
		
		for(int i:segtree)
			System.out.print(i + " ");
		
		System.out.println();
		System.out.println(rangequery(segtree, 0, 3, 0, input.length-1, 0));
		
	}

}
