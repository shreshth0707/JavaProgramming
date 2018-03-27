
import java.util.*;

public class TotientFunction {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        long a=s.nextLong();
        if(a==1 || a==2)
        {
            System.out.println(1);
            return;
        }
        boolean prime[]=new boolean[1000001];
        Arrays.fill(prime,true);
        for(long i=2;i*i<=prime.length;i++)
        {
            if(prime[(int)i]==true)
            {
                for(long j=i+i;j<prime.length;j=j+i)
                {
                    prime[(int)j]=false;
                }
            }
        }
        
        if(prime[(int)a]==true)
        {
            System.out.println(a-1);
            return;
        }
        
        long result=a;
        for(long i=2;i<=result;i++)
        {
            if(prime[(int)i]==true  && a%i==0)
            {
                result=(result*(i-1))/i;
            }
        }
        System.out.println(result);
    }
}
