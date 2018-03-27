import java.util.*;

/*Shreshth Sharma        
 * 
 * John loves prime numbers. One day he was playing a game "primcia" with his wife alicia. The game is as follows, John write a number N on a table.

The number is of the form:

N = (P1A1) * (P2A2) * .............. * (PxAx).

Where Pi are prime numbers and Ai are its corresponding powers.

Now, he asks Alicia to find the sum of all the numbers which are less than or equal to N and also contain all prime numbers which N contains in its prime factorization. For small numbers, Alicia can solve easily but it becomes too hard for large numbers. Help her to answer the query of john.

Input:
First Line contains T test cases. Each test case contains 3 lines, 1st line contain X numbers of primes in N, 2nd line contains X distinct prime numbers and 3rd line contain X powers. Each power Ai is power of Pi.

Output:
Output the Answer Modulo 109 +7.

Constraints:
1 <= T <= 10
1 <= X <= 100000
0 < Pi <=1000000
1<= Ai <= 1000000000
 * 
 * 
 * 
 */


public class BeautifulPrimes {
    
    public static final long c=1000000007;
    public static long apowerb(long a,long b,long m)
    {
        long result=1;
        while(b>0)
        {
            if(b%2==1)
            result=((result%m)*(a%m))%m;
            
            b=b/2;
            a=(a%m*a%m)%m;
        }
        return result%m;
    }
    
    public static long modulusinverse(long a,long m)
    {
       long m0 = m;
        long y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1)
        {
            // q is quotient
            long q = a / m;
 
            long t = m;
 
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
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        while(t>0)
        {
            long n=s.nextLong();
            long ele[]=new long[(int)n];
            long power[]=new long[(int)n];
            for(int i=0;i<n;i++)
            ele[i]=s.nextLong();
            
            for(int i=0;i<n;i++)
            power[i]=s.nextLong();
            
            long result=1;
            for(int i=0;i<n;i++)
            {
                long num=(apowerb(ele[i],power[i]+1,c) - ele[i]%c)%c;
                long den=ele[i]-1;
                den=apowerb(den,c-2,c)%c;
                result=((result%c)*(num%c*den%c)%c)%c;
            }
            if(result%c<0)
            	result+=c;
            System.out.println(result%c);
            t--;
        }
    }
}
