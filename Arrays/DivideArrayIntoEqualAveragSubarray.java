package arraysRevision;

import java.util.ArrayList;


// problem link  ::: https://www.geeksforgeeks.org/break-array-maximum-number-sub-arrays-averages/

public class DivideArrayIntoEqualAveragSubarray {

	static class pair
	{
		int s;
		int e;
		public pair(int s,int e)
		{
			this.s=s;
			this.e=e;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={4, 6, 2, 4, 8, 0, 6, 2};
		int sum=0;
		for(int i:a)
			sum+=i;
		int avg=sum/a.length;
		
		ArrayList<pair> list=new ArrayList<>();
		
		int st=0;
		int partialavg=0;
		for(int i=0;i<a.length;i++)
		{
			partialavg+=a[i];
			if(partialavg/(i-st+1)==avg)
			{
				list.add(new pair(st,i));
				st=i+1;
				partialavg=0;
			}
		}
		if(st<a.length)
			
		list.add(new pair(st,a.length-1));
		for(pair p:list)
		{
			System.out.println(p.s + " " + p.e);
		}
	}

}
