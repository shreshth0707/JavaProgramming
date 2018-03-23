package DynamicProgramming;

import java.util.ArrayList;
class job
{
	int stime;
	int etime;
	int profit;
	
	public job(int a,int b,int c)
	{
		stime=a;
		etime=b;
		profit=c;
	}
}

public class WeightedJobScheduling {

	
	public static int latestnonconflicting(ArrayList<job> list,int i)
	{
		for(int k=i-1;k>=0;k--)
		{
			if(list.get(k).etime<=list.get(i-1).stime)
				return k;
		}
		return -1;
	}
	
	public static int value(ArrayList<job> list,int curr)
	{
		int profit=0;
		// currently one element so return it only
		if(curr==1)
			return list.get(0).profit;
		
		// if we are including the current stock in our list
		//then we need to find out the latest non conflicting stock to proceed.
		int ans1=list.get(curr-1).profit;
		int index=latestnonconflicting(list, curr);
		
		// if are able to find that job then apply recursion to invlude job till that point
		if(index!=-1)
		ans1+=value(list, index+1);
		
		// if we dont want to include that stock in our solution we recurse for job before the current job.
		int ans2=value(list, curr-1);
		
		// maximize the profit
		profit=Math.max(ans1, ans2);
		return profit;
	}

	
							// dp
	public static void count(ArrayList<job> j)
	{
		int table[]=new int[j.size()];
		table[0]=j.get(0).profit;
		
		for(int i=1;i<j.size();i++)
		{
			int ans=j.get(i).profit;
			int l=latestnonconflicting(j, i);
			if(l!=-1)
			{
				ans+=table[l];
			}
			table[i]=Math.max(table[i-1], ans);	
		}
		
		System.out.println(table[j.size()-1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<job> list=new ArrayList<>();
		list.add(new job(1, 2, 50));
		list.add(new job(3, 5, 20));
		list.add(new job(6, 19, 100));
		list.add(new job(2, 100, 200));
	//	System.out.println(value(list, list.size()));
		count(list);
	}

}
