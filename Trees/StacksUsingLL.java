package TreeRevision;

import LinkListRevision.Node;

public class StacksUsingLL<T> {
	Node<T> head;
	int count;
	public StacksUsingLL(T element) {
		head=new Node<T>(element);
		count=1;
	}
	public StacksUsingLL() {
		head=null;
		count=0;
	}

	public int size()
	{
		return count;
	}
	public boolean isEmpty()
	{
		return(size()==0);
	}
	public void push(T element)
	{
		if(head==null)
		{
			head=new Node<T>(element);
			count++;
		}
		else{
		Node<T> temp=new Node<T>(element);
			temp.next=head;
			head=temp;
			count++;
		}
	}

	public T pop()
	{
		if(isEmpty())
		{
			System.out.println("empty stack");
			return null;
		}
		else
		{
			T top=head.data;
			head=head.next;
			count--;
			return top;
		}
	}
	public T top()
	{
		if(!isEmpty())
		return head.data;
		else
			return null;
	}
}
