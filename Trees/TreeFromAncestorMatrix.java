package TreeRevision;

import java.util.*;

class bint
{
	int data;
	bint left;
	bint right;
	
	public bint(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

public class TreeFromAncestorMatrix {

	public static bint construct(int mat[][]){
		
		// parent array to tell if the parent of a bint has been set or not
		boolean parent[]=new boolean[mat.length];
		bint root=null;
		
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
		 
		// get sum of all rows and put sum and corresponding list of row-numbers in the TreeMap
		for(int i=0;i<mat.length;i++) {
			int sum = 0;
			for(int j=0;j<mat.length;j++)
				sum += mat[i][j];
 
			if(map.get(sum) == null) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(i);
				map.put(sum,arr);
			}
			else
				map.get(sum).add(i);
		}
		
		bint[] nodes = new bint[mat.length];
		 
		// iterate over TreeMap
		for(Integer key : map.keySet()) {
			ArrayList<Integer> arr = map.get(key);
 
			for(Integer row : arr) {
				nodes[row] = new bint(row);
				root = nodes[row];
 
				// non-leaf node
				if(key != 0) {
 
					// traverse row "row"
					for(int i=0;i<mat.length;i++) {
 
						// If parent doesn't exist and ancestor exists
						if(!parent[i] && mat[row][i]==1) {
							if(nodes[row].left == null)
								nodes[row].left = nodes[i];
							else
								nodes[row].right = nodes[i];
 
							parent[i] = true;
						}
					}
				}
			}
		}
 
		return root;

		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]={};
		bint root=construct(a);
		
	}

	
}

/*
 * 
 * public static final int N = 6;
 
	static bint constructTreeFromAncestorMatrix(int[][] mat) {
		// parent[i] = true means parent of i is set
		boolean[] parent = new boolean[N];
 
		bint root = null;
 
		// TreeMap is used to keep the array sorted according to key
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
 
		// get sum of all rows and put sum and corresponding list of row-numbers in the TreeMap
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int j=0;j<N;j++)
				sum += mat[i][j];
 
			if(map.get(sum) == null) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(i);
				map.put(sum,arr);
			}
			else
				map.get(sum).add(i);
		}
 
		// nodes[i] stores ith bint
		bint[] nodes = new bint[N];
 
		// iterate over TreeMap
		for(Integer key : map.keySet()) {
			ArrayList<Integer> arr = map.get(key);
 
			for(Integer row : arr) {
				nodes[row] = new bint(row);
				root = nodes[row];
 
				// non-leaf bint
				if(key != 0) {
 
					// traverse row "row"
					for(int i=0;i<N;i++) {
 
						// If parent doesn't exist and ancestor exists
						if(!parent[i] && mat[row][i]==1) {
							if(nodes[row].left == null)
								nodes[row].left = nodes[i];
							else
								nodes[row].right = nodes[i];
 
							parent[i] = true;
						}
					}
				}
			}
		}
 
		return root;
	}
 */

