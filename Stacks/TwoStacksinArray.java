package StacksRevision;

public class TwoStacksinArray {
	int array[];
	int size;
	int top1;
	int top2;
	
	public TwoStacksinArray(int n)
	{
		array=new int[n];
		size=n;
		top1=-1;
		
		top2=n;
	}
	
	public void push1(int ele)
	{
		if(top1<top2-1)
		{
			top1++;
			array[top1]=ele;
		}
		else
		{
			System.out.println("overflow");
		}
	}
	
	public void push2(int ele)
	{
		if(top1<top2-1)
		{
			top2--;
			array[top2]=ele;
		}
		else
		{
			System.out.println("overflow");
		}
	}

	public void pop1()
	{
		if(top1==0)
		{
			System.out.println("underflow");
		}
		else
		{
			top1--;
		}
	}
	public void pop2()
	{
		if(top2==size)
		{
			System.out.println("underflow");
		}
		else
		{
			top2++;
		}
	}
	
	public void print()
	{
		for(int i:array)
			System.out.print(i + " ");
		System.out.println();
		System.out.println(top1 + " is top1 and " + top2 + " is top2");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStacksinArray ts=new TwoStacksinArray(10);
		int array1[]={1,2,3};
		int array2[]={4,5,6};
		for(int i=0;i<3;i++)
		{
			ts.push1(array1[i]);
			ts.push2(array2[i]);
		}
		ts.print();
		ts.pop1();
		ts.print();
		ts.pop2();
		ts.print();
	}

}
