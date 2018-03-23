package TreeRevision;

public class BinaryTree<T> {
public T data;
public BinaryTree<T> left;
public BinaryTree<T> right;

public BinaryTree(T data)
{
	this.data=data;
	left=null;
	right=null;
}
public BinaryTree()
{
}

}
