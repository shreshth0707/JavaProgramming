package HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RhezoAndPrimeProblem {
  
	public static void aa()
	{
		  Scanner s = new Scanner(System.in);
	        int test=s.nextInt();
	        while(test>0)
	        {
	            int n=s.nextInt();
	            int h=s.nextInt();
	            int arr[]=new int[n];
	            for(int i=0;i<n;i++)
	            {
	                arr[i]=s.nextInt();
	            }
	            
	            long max=0;
	            long sum=0;
	            for(int i=0;i<n;)
	            {
	                if(arr[i]<=h)
	                {
	                    while(i<n && arr[i]<=h)
	                    {
	                        sum+=arr[i];
	                        i++;
	                    }
	                    max=Math.max(sum,max);
	                }
	                else
	                i++;
	            }
	            System.out.println(max);
	            test--;
	        }
	}
	
	
	
	
	public static void main(String args[] ) throws Exception {
        aa();
        return;
		
		/*
		Scanner s = new Scanner(System.in);
        boolean a[]=new boolean[5001];
        Arrays.fill(a,true);
        a[0]=false;
        a[1]=false;
        a[2]=true;
        for(int i=2;i<=Math.sqrt(5001);i++)
        {
            if(a[i]==true){
            int j=i+i;
            while(j<5001)
            {
                if(a[j]!=false)
                a[j]=false;
                j=j+i;
            }
            }
        }
        
        // get a  list of all the prime numbers
        ArrayList<Integer> prime=new ArrayList<>();
        for(int i=2;i<a.length;i++)
        {
        	if(a[i]==true)
        		prime.add(i);
        }
        
        
        
        int n=s.nextInt();
        int pre[]=new int[n+1];
        pre[0]=0;
        for(int i=1;i<pre.length;i++)
        	{
        		pre[i]=s.nextInt();
        		pre[i]+=pre[i-1];
        	}
        
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        
        for(int i=2;i<dp.length;i++)
        {
        	dp[i]=dp[i-1];
        	
        	// our prime arraylist will contain prime numbers
        	// we check from i how many numbers we can sum together. 
        	for(int j=0;j<prime.size() && prime.get(j)<=i;j++)
        	{
        		// we reached the starting index ie 0 so total sum is pre[i]
        		if(i-prime.get(j)==0)
        			dp[i]=Math.max(dp[i], pre[i]);
        		else
        		{
      // else get sum for the numbers in prime list and ask for best previous sum excluding the next previous element
        			dp[i]=Math.max(dp[i], pre[i]-pre[i-prime.get(j)] + dp[i-prime.get(j)-1]);
        		}
        	}
        }
        System.out.println(dp[n]);
    */
    }
    
}
