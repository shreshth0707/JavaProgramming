package StacksRevision;

import java.util.PriorityQueue;
import java.util.Queue;

import arraysRevision.QueueUsinLL;

public class stackusingSingleQueue {

	QueueUsinLL<Integer> queues=new QueueUsinLL<Integer>();
	
	
	public void push(int element)
	{
		int size=queues.size();
		queues.enque(element);
		for(int i=0;i<size;i++)
		{
			queues.enque(queues.peek());
			queues.deque();
		}
	}
	public void pop()
	{
		System.out.println(queues.deque());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stackusingSingleQueue stack=new stackusingSingleQueue();
		int array[]={1,2,3,4,5,6};
		for(int i=0;i<array.length;i++)
			stack.push(array[i]);
		stack.pop();
		stack.pop();
		stack.push(10);
		stack.pop();
	}

}
