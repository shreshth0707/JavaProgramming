package DynamicProgramming;
 
class p
{
	int t;
	int f;
}
public class BooleanParentherisation {
	
	
	public static void parentherisation(boolean s[],String o[])
	{
		
		int t[][]=new int[s.length][s.length];
		int f[][]=new int[s.length][s.length];
		for(int i=0;i<s.length;i++)
		{
			t[i][i]=(s[i]==true)?1:0;
			f[i][i]=(s[i]==true)?1:0;
		}
		for(int i=0;i<s.length-1;i++)
		{
			int z=0;
			int y=0;
			z+=((s[i] && s[i+1])==true)?1:0;
			z+=((s[i] || s[i+1])==true)?1:0;
			z+=((s[i] ^ s[i+1])==true)?1:0;
			t[i][i+1]=z;
			
			y+=((s[i] && s[i+1])==true)?0:1;
			y+=((s[i] || s[i+1])==true)?0:1;
			y+=((s[i] ^ s[i+1])==true)?0:1;	
			f[i][i+1]=y;
		}
		
		for(int l=2;l<s.length;l++)
		{
			for(int i=0;i<s.length;i++)
			{
				int j=i+l;
				if(j<s.length)
				{
					int count=0;     // true count;
					int fcount=0;	// false count;
					
					for(int k=i;k<j;k++)
					{
						count+=t[i][k]*t[k+1][j];
						count+=(t[i][k]+f[i][k])*(t[k+1][j]+f[k+1][j])  - f[i][k]*f[k+1][j];
						count+=t[i][k]*f[k+1][j] + t[k+1][j]*f[i][k];
						
						fcount+=(t[i][k]+f[i][k])*(t[k+1][j]+f[k+1][j]) - t[i][k]*t[k+1][j];
						fcount+=f[i][k]*f[k+1][j];
						fcount+=t[i][k]*f[k+1][j] + t[k+1][j]*f[i][k];
					}
					t[i][j]=count;
					f[i][j]=fcount;
				}
			}
		}
		System.out.println(t[0][s.length-1]);
		
	}
	
	public static void main(String[] args)
	{
		boolean symbols[] = {true,true,false,true};
	   String operators[] = {"|","&","^"};
	   parentherisation(symbols, operators);
	}

}