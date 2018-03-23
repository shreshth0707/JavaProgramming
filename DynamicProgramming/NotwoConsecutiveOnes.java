package DynamicProgramming;

import java.util.ArrayList;

public class NotwoConsecutiveOnes {

	public static ArrayList<String> value(ArrayList<String> list,int N)
	{
		if(N==0)
			return list;
		
		ArrayList<String> list1=new ArrayList<>();
		while(!list.isEmpty())
		{
			String s1="";
			String s2="";
			String str=list.get(0);
		    list.remove(0);
			if(str.charAt(0)=='0')
			{
				s1="1" + str;
				s2="0" +str;
				list1.add(s2);
				list1.add(s1);
			}
			else
			{
				s1="0" + str;
				list1.add(s1);
			}
		}
		return value(list1, N-1);	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N=3;
		ArrayList<String> n=new ArrayList<>();
		n.add("0");
		n.add("1");
		n=value(n, N-1);
		for(String s:n)
			System.out.println(s + " ");
	}

}
