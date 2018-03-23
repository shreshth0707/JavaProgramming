package TreeRevision;

import org.omg.CORBA.INTERNAL;

public class TreeFromPreAndPost {

	public static BinaryTree<Integer> convert(int pre[],int post[],int pres,int posts,int poste)
	{
		if(pres>=pre.length || posts>poste)
			return null;

		BinaryTree<Integer> root=new BinaryTree<>(pre[pres]);

		if(poste==posts)
			return root;

		int i=posts;
		while(i<=poste){
			if( post[i]!=pre[pres+1])
				break;
			i++;
		}

		if(i<=poste)
		{
			root.left=convert(pre, post, pres+1, posts, i);
			root.right=convert(pre, post, pres+1,i+1, poste);
		}

		return root;

	}
	
	public static BinaryTree<Integer> treeFromPreAndPost(int post[],int pre[],int pos,int poe,int pres,int pree)
	{
		if(pos>poe || pres>pree)
			return null;
		
		BinaryTree<Integer> root=new BinaryTree<>(pre[pres]);
		
		// if array size is greater than 1,then root will have both left and right child.
		if(pree-pres+1>1) 
		{
			int temp=pre[pres+1];   // it is root.left
			int c=1;
			int i=pos;
			while(post[i]!=temp)
			{
				c++;
				i++;
			}
			
			
			int lpres=pres+1;
			int rpree=pree;
			int lpree=pres+c;
			int rpres=lpree+1;
			
			
			int lposs=pos;
			int rpoe=poe-1;
			int lpoe=pos+c-1;
			int rpos=lpoe+1;
			
			root.left=treeFromPreAndPost(post, pre, lposs, lpoe, lpres, lpree);
			root.right=treeFromPreAndPost(post, pre, rpos, rpoe, rpres, rpree);
		}
		
		return root;
	}

	public static BinaryTree<Integer> treeFromPreAndIn(int pre[],int pres,int in[],int ins,int pree,int ine)
	{
		if(pres>pree || ins>ine)
			return null;

		BinaryTree<Integer> root=new BinaryTree<>(pre[pres]);

		int lps=pres+1;
		int rpe=pree;
		int lis=ins;
		int rie=ine;


		int i=ins;
		int c=0;
		while(in[i]!=pre[pres])
		{
			i++;
			c++;
		}

		int lie=i-1;
		int ris=i+1;

		int lpe=lps+c-1;
		int rps=lpe+1;

		root.left=treeFromPreAndIn(pre, lps, in, lis, lpe, lie);
		root.right=treeFromPreAndIn(pre, rps, in, ris, rpe, rie);
		return root;
	}

	public static BinaryTree<Integer> treeFromPostAndIn(int post[],int in[],int ins,int ine,int posts,int poste)
	{
		if(ins>ine || posts>poste)
		{
			return null;
		}

		BinaryTree<Integer> root=new BinaryTree<>(post[poste]);

		int lps=posts;
		int rpe=poste-1;
		int lis=ins;
		int rie=ine;


		int i=ins;
		int c=0;
		while(in[i]!=post[poste])
		{
			i++;
			c++;
		}

		int lie=i-1;
		int ris=i+1;

		int lpe=posts+c-1;
		int rps=lpe+1;

		root.left=treeFromPostAndIn(post, in, lis, lie, lps, lpe);
		root.right=treeFromPostAndIn(post, in, ris, rie, rps, rpe);
		return root;
	}
	
	
	public static void postorderFromPreAndIn(int in[],int pre[],int ins,int ine,int pres,int pree)
	{
		
		if(ins>ine || pres>pree)
			return ;
		
		int rdata=pre[pres];
		int i=ins;
		int c=0;
		while(i<in.length && in[i]!=rdata)
		{
			i++;
			c++;
		}
		int lps=pres+1;
		int lpe=pres+c;
		int rps=lpe+1;
		int rpe=pree;
		
		
		int lis=ins;
		int lie=i;
		int ris=i+1;
		int rie=ine;
		
		postorderFromPreAndIn(in, pre, lis, lie, lps, lpe);
		postorderFromPreAndIn(in, pre, ris, rie, rps, rpe);
		System.out.print(rdata + " ");
		
	}

	
	public static BinaryTree<Integer> prepost(int pre[],int pos[],int pres,int pree,int poss,int pose)
	{
		if(poss>pose || pres>pree)
			return null;
		
		if(poss==pose)
			return new BinaryTree<>(pos[poss]);
		
		BinaryTree<Integer> r=new BinaryTree<>(pre[pres]);
		
		int lpres=pres+1;
		int rpree=pree;
		int rpose=pose-1;
		int lposs=poss;
		
		int i=lposs;
		while(pos[i]!=pre[lpres])
			i++;
		
		int lpose=i;
		int rposs=i+1;
		int lpree=lpres+(i-poss);
		int rpres=lpree+1;
		
		r.left=prepost(pre,pos,lpres,lpree,lposs,lpose);
		r.right=prepost(pre, pos, rpres, rpree, rposs, rpose);
		return r;
	}
	
	
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
		int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
		//  BinaryTree<Integer> root=convert(pre, post, 0, 0, post.length-1);
		// BinaryTreeUse.print(root);

		int a[]={1,2,4,5,3,6,7}; // pre
		int b[]={4,2,5,1,6,3,7}; // in
		int c[]={4,5,2,6,7,3,1};  // post
 	
		BinaryTree<Integer> root=treeFromPreAndIn(a, 0, b, 0, a.length-1, b.length-1);
	/*	BinaryTreeUse.print(root);

		root=treeFromPostAndIn(c, b, 0, b.length-1, 0, c.length-1);
		BinaryTreeUse.print(root);
		
		root=treeFromPreAndPost(c, a, 0, c.length-1, 0, a.length-1
				);
		BinaryTreeUse.print(root);

		*/
		root=prepost(a, c, 0, a.length-1, 0, c.length-1);
		BinaryTreeUse.print(root);
		
	}

}
