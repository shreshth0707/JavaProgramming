package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {

	public static int MinNoOfCuts(String a)
	{
		boolean cp[][]=new boolean[a.length()][a.length()];
		for(int i=0;i<cp.length;i++)
			Arrays.fill(cp[i], false);
		
		for(int i=0;i<a.length();i++)
			cp[i][i]=true;
		for(int i=0;i<a.length()-1;i++)
		{
			if(a.charAt(i)==a.charAt(i+1))
				cp[i][i+1]=true;
		}
		
		// to identity if a[i...j] is palindrome
		for(int l=2;l<a.length();l++)  // length of gap
		{
			for(int i=0;i<a.length();i++)
			{
				int j=i+l;   // end
				if(j<a.length())
				{
					if(a.charAt(i)==a.charAt(j))
					{
						cp[i][j]=cp[i+1][j-1];
					}
				}
			}
		}
		
		
		int c[]=new int[a.length()];
		Arrays.fill(c,Integer.MAX_VALUE);
		c[0]=0;
		c[1]=(cp[0][1]==true)?0:1;
		
		//  test  a[0...i]
		for(int i=1;i<a.length();i++)
		{
			for(int j=0;j<i;j++)
			{
				// aage vala part palindrom hai
				if(cp[j+1][i]==true)
				{
					if(c[i]>(c[j] + 1))
						c[i]=c[j]+1;
				}
			}
		}
		System.out.println(c[a.length()-1]);
		return c[a.length()-1];
	}



	// best solution o(n2) gfg
	public static int minCuts(String a) {

		// m[i][j] will store if a[i to j] is palindrome or not
		boolean m[][]=new boolean[a.length()][a.length()];
		int c[]=new int[a.length()];
		for(int i=0;i<a.length();i++)
		{
			m[i][i]=true;
		}

		for (int l=2;l<=a.length();l++)
		{
			for(int i=0;i<a.length()+1-l;i++)
			{
				int j=i+l-1;
				boolean aa=(a.charAt(i)==a.charAt(j));
				if(l==2)
					m[i][j]=aa;
				else
					m[i][j]=m[i+1][j-1] && aa;
			}
		}

		for(int i=0;i<a.length();i++)
		{
			// if a(i to j) is palindrome then no of cuts =1;
			if(m[0][i]==true)
				c[i]=0;


			else
			{
				// assign cuts as maximum and reduce it to get the minimum.
				c[i]=Integer.MAX_VALUE;
				for(int j=0;j<i;j++)
				{
					// agar aage vala palindrome hai to cuts =1 + cuts(peeche vala).
					if(m[j+1][i]==true && (1+c[j]<c[i]))
						c[i]=1+c[j];
				}
			}
		}

		return c[a.length()-1];

	}





	// tushar roy code
	public int minCut(String str){
		if (str.length() == 0) {
			return 0;
		}

		int[] cut = new int[str.length()];
		boolean isPal[][] = new boolean[str.length()][str.length()];
		for (int i = 1; i < str.length(); i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
					isPal[i][j] = true;
					min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
				}
			}
			cut[i] = min;
		}
		return cut[str.length() - 1];
	}

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.
	 * https://leetcode.com/problems/palindrome-partitioning/
	 */
	public List<List<String>> partition(String s) {
		Map<Integer, List<List<String>>> dp = new HashMap<>();
		List<List<String>> result =  partitionUtil(s, dp, 0);
		List<List<String>> r = new ArrayList<>();
		for (List<String> l : result) {
			r.add(l);
		}
		return r;
	}

	private List<List<String>> partitionUtil(String s, Map<Integer, List<List<String>>> dp, int start) {
		if (start == s.length()) {
			List<String> r = new ArrayList<>();
			return Collections.singletonList(r);
		}

		if (dp.containsKey(start)) {
			return dp.get(start);
		}

		List<List<String>> words = new ArrayList<>();
		for (int i = start; i < s.length(); i++) {
			if (!isPalindrome(s, start, i) ) {
				continue;
			}
			String newWord = s.substring(start, i + 1);
			List<List<String>> result = partitionUtil(s, dp, i + 1);
			for (List l : result) {
				List<String> l1 = new ArrayList<>();
				l1.add(newWord);
				l1.addAll(l);
				words.add(l1);
			}
		}
		dp.put(start, words);
		return words;
	}

	private  boolean isPalindrome(String str, int r, int t) {
		while(r < t) {
			if (str.charAt(r) != str.charAt(t)) {
				return false;
			}
			r++;
			t--;
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	palindromeParttion("abcbm");
		MinNoOfCuts("abcbm");
	}

}
