import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


// compute ((a^b)/c)mod m) efficiently
public class modularArithmetic {
    
    public static int apowerb(int a,int b,int m)
    {
        int result=1;
        while(b>0)
        {
            if(b%2==1)
            result=((result%m)*(a%m))%m;
            
            b=b/2;
            a=a*a;
        }
        return result%m;
    }
    
    public static int modulusinverse(int a,int m)
    {
       int m0 = m;
        int y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1)
        {
            // q is quotient
            int q = a / m;
 
            int t = m;
 
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x; 
    }
    
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        int c=s.nextInt();
        int m=s.nextInt();
        
        int r1=apowerb(a,b,m);
        int r2=modulusinverse(c,m);
        int v1=((r1%m)*(r2))%m;
        if(v1<0)
        System.out.println(v1+m);
        else
        System.out.println(v1);
    }
}
