package TreeRevision;

import java.util.Arrays;

public class PostOrderFromPreandIn {

	public static int search(int arr[], int x, int n)
    {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
            return i;
        return -1;
    }
 
// Prints postorder traversal from given inorder and preorder traversals
    public static void printPostOrder(int in[], int pre[], int n)
    {
        // The first element in pre[] is always root, search it
        // in in[] to find left and right subtrees
        int root = search(in, pre[0], n);
 
        int tempPre[] , tempIn[];
 
        // If left subtree is not empty, print left subtree
        if (root != 0){
            tempPre = Arrays.copyOfRange(pre, 1,pre.length);
            printPostOrder(in, tempPre, root);
        }
 
 
        // If right subtree is not empty, print right subtree
        if (root != n-1)
        {   tempPre = Arrays.copyOfRange(pre,root+1,pre.length);
            tempIn =  Arrays.copyOfRange(in,root+1,in.length);
            printPostOrder(tempIn, tempPre,n-root-1);
        }
 
        // Print root
        System.out.print(pre[0]+" ");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[] = {4, 2, 5, 1, 3, 6};
		   int pre[] =  {1, 2, 4, 5, 3, 6};
		//   construct(in, 0, in.length-1, pre, 0);

	}

}
