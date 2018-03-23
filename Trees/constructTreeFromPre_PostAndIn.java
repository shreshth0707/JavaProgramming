package TreeRevision;

public class constructTreeFromPre_PostAndIn {

	public static BinaryTree<Integer> getTreeFromPreAndIn(int[] pre,
			int[] in, int preS, int preE, int inS, int inE) {
		if (inS > inE) {
			return null;
		}

		int rootData = pre[preS];
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);

		int i = inS;
		while (i <= inE) {
			if (in[i] == rootData)
				break;
			i++;
		}

		int leftInStart = inS;
		int leftInEnd = i - 1;
		int rightInStart = i + 1;
		int rightInEnd = inE;

		int leftPreStart = preS + 1;
		int rightPreEnd = preE;

		int leftLength = leftInEnd - leftInStart + 1;
		int leftPreEnd = leftPreStart + leftLength - 1;
		int rightPreStart = leftPreEnd + 1;
		root.left = getTreeFromPreAndIn(
				pre, in, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
		root.right = getTreeFromPreAndIn(
				pre, in, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
		return root;
	}

	public static BinaryTree<Integer> fromPostandIn(int p[],int in[],int ins,int ine,int ps,int pe)
	{
		if(ins>ine)
			return null;
		 // at least one element is there.
		
		
		BinaryTree<Integer> root=new BinaryTree<>(p[pe]);
		int i=ine;
		while(i>=ins)
		{
			if(in[i]==p[pe])
				break;
			i--;
		}
		
		int lis=ins;
		int lie=i-1;
		int ris=i+1;
		int rie=ine;
		
		int lps=ps;
		int rpe=pe-1;
		
		int count=rie-ris+1;
		int rps=rpe-count+1;
		int lpe=rps-1;
		
		
		root.left=fromPostandIn(p, in, lis, lie, lps, lpe);
		root.right=fromPostandIn(p, in, ris, rie, rps, rpe);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ia[]={4,2,5,1,6,3};
		int pa[]={1,2,4,5,3,6};
		int post[]={4,5,2,6,3,1};
		BinaryTree<Integer> root=getTreeFromPreAndIn(pa, ia, 0, pa.length-1, 0, ia.length-1);
		BinaryTreeUse.print(root);
		root=fromPostandIn(post, ia, 0, ia.length-1, 0, post.length-1);
		BinaryTreeUse.print(root);
		
	}

}
