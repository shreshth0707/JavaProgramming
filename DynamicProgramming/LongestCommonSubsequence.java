package DynamicProgramming;

public class LongestCommonSubsequence {

	
	public static int lcs(String str1,String str2)
	{
		int array[][]=new int[str2.length()+1][str1.length()+1];
		for(int i=0;i<=str1.length();i++)
			array[0][i]=0;
		for(int i=0;i<=str2.length();i++)
			array[i][0]=0;
		
		for(int i=1;i<=str2.length();i++)
		{
			for(int j=1;j<=str1.length();j++)
			{
				if(str2.charAt(i-1)==str1.charAt(j-1))
					array[i][j]=1 + array[i-1][j-1];
				else
				{
					array[i][j]=Math.max(array[i-1][j], array[i][j-1]);
				}
			}
		}
		
		
		return array[str2.length()][str1.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcs("abcdef","aebcf"));
	}

}
