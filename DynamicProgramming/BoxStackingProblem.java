package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BoxStackingProblem {

	
	static class box
	{
		int l;
		int w;
		int h;
		
		public box(int l,int w,int h)
		{
			this.l=l;
			this.w=w;
			this.h=h;
		}
	}
	
	public static int solve(box[] b)
	{
		box small[]=new box[b.length*3];
		int k=0;
		for(int i=0;i<b.length;i++)
		{
			box temp=b[i];
			small[k++]=temp;
			small[k++]=new box(temp.w, temp.h, temp.l);
			small[k++]=new box(temp.h,temp.l,temp.w);
		}
		
	
		Arrays.sort(small,new Comparator<box>(){
			@Override
			public int compare(box a,box b)
			{
				if(a.l*a.w -b.l*b.w  <0)
					return 1;
				else if(a.l*a.w -b.l*b.w==0)
					return(b.h-a.h);
				else
					return -1;
			}
		
		});
		
		int arr[]=new int[small.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=small[i].h;
		}
		
		int t=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(small[i].l<small[j].l && small[i].w <small[j].w)
					arr[i]=Math.max(arr[j]+small[i].h,arr[i]);
				t=Math.max(t, arr[i]);
			}
		}
		
		System.out.println(t);
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		box b[]= { new box(4, 6, 7), new box(1, 2, 3), new box(4, 5, 6), new box(10, 12, 32) };
		solve(b);
	}

}
