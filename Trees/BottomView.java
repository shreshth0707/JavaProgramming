package TreeRevision;

import java.util.HashMap;

public class BottomView {

	public static void Bottomview(BinaryTree<Integer> root,int left,HashMap<Integer, Integer> map)
	{
		if(root==null)
			return;
		
		// error :traversal should have to be level order.

		map.put(left, root.data);
		Bottomview(root.left, left-1, map);
		Bottomview(root.right, left+1, map);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map=new HashMap<>();
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
		Bottomview(root, 0, map);
		int ht=BinaryTreeUse.height(root);
		for(int i=-ht;i<=ht;i++)
		{
			if(map.containsKey(i))
				System.out.println(map.get(i));
		}
			
	}

}
