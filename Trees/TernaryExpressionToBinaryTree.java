package TreeRevision;

public class TernaryExpressionToBinaryTree {

	static int index=0;
	public static BinaryTree<Integer> convertToBT(String str)
	{
		if (str == null)
			return null;

		// if whole string is traversed,return null
		if (index >= str.length())
			return null;
		
		// create a root using data at the current index
		BinaryTree<Integer> root = new BinaryTree<>(Integer.parseInt(str.charAt(index)+ ""));
		index++;
		
		// left done denotes if left child has been traversed or not.
		boolean leftDone = false;
		
		// question mark means left tree will start now.
		if (index < str.length() && str.charAt(index) == '?') {
			index++;
			root.left = convertToBT(str);
			leftDone = true;
		}
		// left part is done and : coomes so traverse for right subtree.
		if (index < str.length() && str.charAt(index) == ':' && leftDone) {
			index++;
			root.right = convertToBT(str);
		}
		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str="1?2:3";
//		BinaryTreeUse.print(convertToBT(str));
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		get(root, 2);
		System.out.println(ans);
	}
   
    
	static int ans=-1;
	static int c=0;
    public static void get(BinaryTree<Integer> root,int k)
    {
        if(root==null)
        return;
        
        get(root.left,k);
        
        c++;
        if(c==k){
        ans=root.data;
        return;
        }
        
        get(root.right,k);
    }

}
