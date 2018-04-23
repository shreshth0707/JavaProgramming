package StacksRevision;

/*
 * Find if an expression has duplicate parenthesis or not
Given an balanced expression, find if it contains duplicate parenthesis or not. A set of parenthesis are duplicate if same subexpression is surrounded by multiple parenthesis.

Examples:

Below expressions have duplicate parenthesis - 
((a+b)+((c+d)))
The subexpression "c+d" is surrounded by two
pairs of brackets.

(((a+(b)))+(c+d))
The subexpression "a+(b)" is surrounded by two 
pairs of brackets.

(((a+(b))+c+d))
The whole expression is surrounded by two 
pairs of brackets.

Below expressions don't have any duplicate parenthesis -
((a+b)+(c+d)) 
No subsexpression is surrounded by duplicate
brackets.

((a+(b))+(c+d))
No subsexpression is surrounded by duplicate
brackets.
 */
import java.util.*;

public class duplicateParenthesis {

	public static boolean duplicates(String str)
	{
		Stack<Character> stacks=new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==')')
			{
				Character top=stacks.pop();
				if(top=='(')
					return false;

				while(!stacks.isEmpty() && top!='(')
				{
					top=stacks.pop();
				}
			}
			else
				stacks.push(str.charAt(i));
		}
		return true;
	}

	public static boolean dp(String str)
	{
		Stack<Character> stacks=new Stack<>();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==')')
			{
				if(stacks.peek()=='(')
					return false;
				
				while(!stacks.isEmpty() && stacks.peek()!='(')
					stacks.pop();
				
				stacks.pop();
				
			}
			else
				stacks.push(str.charAt(i));
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="((a+b)+((c+d)))";
		Stack<Character> stacks=new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==')')
			{
				int top=stacks.peek();
				stacks.pop();

				if(top=='('){
					System.out.println("duplicates");
					return;
				}

				while(!stacks.isEmpty() && top!='(')
				{
					top=stacks.pop();
				}
			}
			else
			{
				stacks.push(str.charAt(i));
			}
		}
		System.out.println("NO duplicates");
		System.out.println(duplicates("((a+b)+(c+d))"));

		System.out.println("hello     " + dp(str));
	}
}
