package StacksRevision;

import java.util.*;

import javax.naming.InitialContext;
public class InfixToPostFix {

	static HashMap<Character,Integer>  oppre=new HashMap<>();
	
	
	public static void main(String[] args) {
		
		HashSet<Character> set=new HashSet<>();
		set.add('+'); set.add('-'); set.add('*');set.add('/');set.add('^');set.add('(');
		set.add(')');
		
		oppre.put('+',1);
		oppre.put('-', 1);

		oppre.put('*',2);
		oppre.put('/',2);
		oppre.put('^',3);
		oppre.put('(',-1);
		
		String infix="a+b*(c^d-e)^(f+g*h)-i";
		StringBuffer sb=new StringBuffer("");
		Stack<Character> op=new Stack<>();
		
		
		for(int i=0;i<infix.length();i++)
		{
			if(!set.contains(infix.charAt(i)))
			{
				sb.append(infix.charAt(i)+ "");
			}
			else
			{
				if(infix.charAt(i)=='(')
					op.push(infix.charAt(i));
					
				else if(infix.charAt(i)==')')
				{
					while(op.peek()!='(')
						sb.append(op.pop());
					op.pop();
				}
				
				else if(op.isEmpty() || oppre.get(op.peek())<oppre.get(infix.charAt(i)))
				{
				 op.push(infix.charAt(i));
				}
				else
				{
					while(!op.isEmpty() && oppre.get(op.peek())>=oppre.get(infix.charAt(i)))
					{
						sb.append(op.pop()+ "");
					}
					op.push(infix.charAt(i));
				}
			}
		}
			while(!op.isEmpty())
				sb.append(op.pop());
			System.out.println(sb.toString());
			
			postfixEvaluation("231*+9-");
	
	}
	
	public static void postfixEvaluation(String pofix)
	{
		Stack<Integer> operands=new Stack<>();
		for(int i=0;i<pofix.length();i++)
		{
			char c=pofix.charAt(i);
			if(oppre.containsKey(c))
			{
				if(operands.size()<2){
					System.out.println("invalid postfix expression");
					return;
				}
				else
				{
					int b=operands.pop();
					int a=operands.pop();
					if(c=='+')
						operands.push(a+b);
					else if(c=='-')
						operands.push(a-b);
					else if(c=='*')
						operands.push(a*b);
					else if(c=='/')
						operands.push(a/b);
					else if(c=='^')
						operands.push((int)Math.pow(a,b));
				}
			}
			else
				operands.push(Integer.parseInt(c+""));
		}
		if(operands.size()!=1)
			System.out.println("invalid postfix expression");
		else
		System.out.println(operands.pop());
	}

}
