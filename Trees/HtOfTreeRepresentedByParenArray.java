package TreeRevision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class HtOfTreeRepresentedByParenArray {

	public static void depth(int parent[],int depth[],int index)
	{
		if(depth[index]!=0)
			return;
		
		if(parent[index]==-1)
		{
			depth[index]=1;
			return;
		}
		
		if(parent[index]==0)   // parent ki entry nahi hui hai.so recur for parent.
		{
			depth(parent, depth, parent[index]);
		}
		
		depth[index]=depth[parent[index]]+1;
		
	}
	
	
	
	public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        
	
		for(int i=0;i<B.size();i++)
		{
			String s=B.get(i);
			s=i+"_";
			B.set(i, s);
		}
		HashSet<String> set=new HashSet<>();
		
		String goodwords[]=A.split("_");
		for(String str:goodwords)
		{
			set.add(str);
		}
		
        Collections.sort(B,new Comparator<String>() {
        	
        	@Override
        	public int compare(String s1,String s2)
        	{
        		int c1=0;
        		int c2=0;
        		String t1[]=s1.split("_");
        		for(int i=0;i<t1.length;i++)
        		{
        			if(set.contains(t1[i]))
        				c1++;
        		}
        		t1=s2.split("_");
        		for(int i=0;i<t1.length;i++)
        		{
        			if(set.contains(t1[i]))
        				c2++;
        		}
        		return c2-c1;
        	}
		});
        ArrayList<Integer> list=new ArrayList<>();
        
        	for(int i=0;i<B.size();i++)
        	{
        		String ss[]=B.get(i).split("_");
        		list.add(Integer.parseInt(ss[0]));
        	}
        return list;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String S = "cool_ice_wifi";
		String[] R = {"water_is_cool", "cold_ice_drink", "cool_wifi_speed"};
		ArrayList<String> aa=new ArrayList<>();
		for(String a:R)
			aa.add(a);
		
		ArrayList<Integer> ans=solve(S, aa);
		for(int i:ans)
			System.out.print(i  +" ");
		
		
		/*
		int array[]={-1,0,0,1,1,3,5};
		
		int depth[]=new int[array.length];
		for(int i=0;i<array.length;i++)
			depth[i]=depthB(array, depth, i);
			//	depthfun(array, depth, i);
		
		int max=-1;
		for(int i=0;i<array.length;i++)
			if(depth[i]>max)
				max=depth[i];
		
		
		System.out.println(max);
		*/
	}

	
	public static int depthB(int p[],int d[],int index)
	{
		if(p[index]==-1)
			return 1;
		
		if(d[index]!=0)
			return d[index];
		
		int a=index;
		index=p[index];
		int val=1+ depthB(p, d, index);
		d[a]=val;
		return d[a];
	}
	
	
	
	
	
	
	
	
	public static void depthfun(int arr[],int depth[],int i)
	{
		// already filled
		if(depth[i]!=0)
			return;
		
		// root index so level is 1
		if(arr[i]==-1)
		{
			depth[i]=1;
			return;
		}
		else if(depth[i]==0)
		{
			depthfun(arr, depth, arr[i]);
		}
		depth[i]=1+depth[arr[i]];
	}
	
}
