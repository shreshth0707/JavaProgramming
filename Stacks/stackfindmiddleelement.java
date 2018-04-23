package StacksRevision;

public class stackfindmiddleelement {
	public static void main(String[] aerg)
	{
		stack st=new stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
 
		System.out.println(st.getmiddlekey());
		st.deletemiddle();
		System.out.println(st.getmiddlekey());
		st.deletemiddle();
		System.out.println(st.getmiddlekey());
 
 
	}
	// doubly link list
	static class node
	{
		int data;
		node prev,next;
 
		node(int d)
		{
			this.data=d;
			prev=null;
			next=null;
		}
 
	}
	
	// stack will have a head, middle node and its size
	static class stack
	{
		node middlement;
		node root;
		int size;
		stack()
		{
			root=null;
			size=0;
			 middlement=null;
		}
		
		public void deletemiddle()
		{
			if(middlement!=null)
			{
			size--;            // middle element delete ho gaya to size ek less
			if(size==0)            //stack empty ho gaya,root and middle dono null ho gaye.
			{
				root=null;
				middlement=null;
				return;
			}
			if(size%2==0)    // delete karke size is even,previous vala middle ho gaya.
			{
				node temp=middlement.prev;
				if(temp!=null)
				{
				temp.next=middlement.next;
				}
				if(middlement.next!=null)
				{
					middlement.next.prev=temp;
				}
				middlement=temp;
			}
				else     // aage vala element middle ho jaega.
				{
					node temp=middlement.next;
					if(temp!=null)
					{
					temp.prev=middlement.prev;
					}
					if(middlement.prev!=null)
					{
						middlement.prev=middlement.next;
					}
					middlement=temp;
 
 
				}
			}
		}
		public void push(int key)
		{
			// aage lagani hai nayi node.
			node temp=new node(key);
			if(root==null)
			{
				root=temp;
				 middlement=temp;
			}
			else
			{
				root.next=temp;
				temp.prev=root;
				root=temp;
			}
			size++;
			if(size%2==1 && size>1)
			{
				 middlement=middlement.next;
			} 
		}
		public int getmiddlekey()
		{
			if(middlement!=null)
			{
				return middlement.data;
			}
			return -1;
		}
		public int pop()
		{
			if(root!=null)
			{
				int data=root.data;
				node pp=root.prev;
				pp.next=null;
 
				root=pp;
				size--;
				if(size%2==0)
				{
					middlement=middlement.prev;
				}
				return data;
 
			}
			return -1;
		}
		public int peek()
		{
			if(root!=null)
			{
				return root.data;
			}
			return -1;
		}
 
	}
 
}
 

