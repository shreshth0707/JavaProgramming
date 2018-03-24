package DynamicProgramming;
import java.util.*;

public class choiceOfArea {

	static class pair
	{
		int x;
		int y;
		public pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		
	}
	
	public static HashMap<pair,Integer> map=new HashMap<>();
	public static int xa,xb,ya,yb,za,zb;

	public static int calc(int a,int b,char curr)
	{
		if(map.containsKey(new pair(a,b))){
			return (map.get(new pair(a,b)));
		}
		int nax=a+xa;
		int nbx=b+xb;
		int nay=a+ya;
		int nby=b+yb;
		int naz=a+za;
		int nbz=b+zb;
		
		int mx=0;
		int my=0;
		int mz=0;
		if(curr=='X' || curr=='S')
		{
			if((nay<0 || nby<0) && (naz<0 || nbz<0))
				return 0;
			
			if(nay>=0  && nby>=0)
			{
				my=Math.max(my,1+ calc(nay, nby, 'Y'));
			}
			
			if(naz>=0  && nbz>=0)
			{
				mz=Math.max(mz,1+ calc(naz, nbz, 'Z'));
			}
		}
		if(curr=='Y' || curr=='S')
		{
			if((nax<0 || nbx<0) && (naz<0 || nbz<0))
				return 0;
			
			if(nax>=0  && nbx>=0)
			{
				mx=Math.max(mx,1+ calc(nax, nbx, 'X'));
			}
			
			if(naz>=0  && nbz>=0)
			{
				mz=Math.max(mz,1+ calc(naz, nbz, 'Z'));
			}
		}
		
		if(curr=='Z' || curr=='S')
		{
			if((nay<0 || nby<0) && (nax<0 || nbx<0))
				return 0;
			
			if(nay>=0  && nby>=0)
			{
				my=Math.max(my,1+ calc(nay, nby, 'Y'));
			}
			
			if(nax>=0  && nbx>=0)
			{
				mz=Math.max(mz,1+ calc(naz, nbz, 'X'));
			}
		}
		
		map.put(new pair(a, b), Math.max(mx, Math.max(my, mz)));
		return Math.max(mx, Math.max(my, mz));		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=20;
		int b=8;
		
		Scanner s=new Scanner(System.in);
		xa=s.nextInt();
		xb=s.nextInt();
		ya=s.nextInt();
		yb=s.nextInt();
		za=s.nextInt();	
		zb=s.nextInt();	
		
		
		System.out.println(calc(a, b, 'S'));
		
		
		
	}

}
