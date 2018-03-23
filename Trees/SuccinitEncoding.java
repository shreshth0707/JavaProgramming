package TreeRevision;

import java.sql.Array;
import java.util.*;
import java.util.Base64.Decoder;

import org.omg.CORBA.INTERNAL;
public class SuccinitEncoding {

	/*
	 * function EncodeSuccinct(node n, bitstring structure, array data) {
    if n = nil then
        append 0 to structure;
    else
        append 1 to structure;
        append n.data to data;
        EncodeSuccinct(n.left, structure, data);
        EncodeSuccinct(n.right, structure, data);
}
And below is algorithm for decoding

function DecodeSuccinct(bitstring structure, array data) {
    remove first bit of structure and put it in b
    if b = 1 then
        create a new node n
        remove first element of data and put it in n.data
        n.left = DecodeSuccinct(structure, data)
        n.right = DecodeSuccinct(structure, data)
        return n
    else
        return nil
}
	 */

	// traverse in preorder fashion
	static String str="";
	public static void Encode(BinaryTree<Integer> root,ArrayList<Integer> array)
	{
		if(root==null)
		{
			str=str+"0";
			return;
		}
		str=str+"1";
		array.add(root.data);
		Encode(root.left, array);
		Encode(root.right, array);

	}

	public static BinaryTree<Integer> decode(ArrayList<Integer> list)
	{
		if(str.length()==0 || list.size()==0)
			return null;
		if(str.charAt(0)=='0')
		{
			str=str.substring(1);
			return null;
		}

		else
		{
			BinaryTree<Integer> root=new BinaryTree<>(list.get(0));
			list.remove(0);
			str=str.substring(1);
			root.left=decode(list);
			root.right=decode(list);
			return root;
		}

	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l=new ArrayList<>();
		BinaryTree<Integer> root=BinaryTreeUse.takeInputLevelWise();
			Encode(root, l);
	//	encoded(root, l);
		System.out.println(str);
		  root=decode(l);
	//	root=decoded(l);

		BinaryTreeUse.print(root);
	}

}
