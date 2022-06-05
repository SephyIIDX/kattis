
/**
 * An implementation of a disjoint-set forest with the ability to
 * join two sets or check if two elements are in the same set.
 * 
 * At the start all elements are alone in separate sets.
 */
public class UnionFind {
	private int[] parent;
	private int[] rank;
	
	private int aRoot;
	private int bRoot;
	
	/**
	 * Constructs <i>n</i> disjoint sets ranging from 0 to <i>n</i>-1.
	 * 
	 * @param n number of disjoint sets
	 * @throws IllegalArgumentException if n <= 0
	 */
	public UnionFind(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("n has to be a positive integer.");
		parent = new int[n];
		rank = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	/**
	 * Joins the set containing <i>a</i> with the set containing <i>b</i> by appending<br>
	 * the set with lower rank to the one with higher rank. <br><br>
	 * 
	 * If both ranks are the same the set containing <i>b</i> is appended to the <br>
	 * set containing <i>a</i> and the rank of set containing <i>a</i> is increased by 1.
	 * 
	 * @param a member of a set to be joined
	 * @param b member of a set to be joined
	 * @return <i>true</i> if successful. Otherwise <i>false</i> (<i>a</i> and <i>b</i> are already <br>in same set).
	 */
	public boolean union(int a, int b) {
		aRoot = find(a);
		bRoot = find(b);
		
		if (aRoot == bRoot) 
			return false;
		
		if (rank[aRoot] < rank[bRoot])
			parent[aRoot] = bRoot;
		else if (rank[aRoot] > rank[bRoot])
			parent[bRoot] = aRoot;
		else { //rank[aRoot] == rank[bRoot]
			parent[bRoot] = aRoot;
			rank[aRoot]++;
		}
		return true;
	}

	/**
	 * Checks if <i>a</i> and <i>b</i> are in the same set.
	 * 
	 * @param a member of a set
	 * @param b member of a set
	 * @return <i>true</i> if <i>a</i> and <i>b</i> are in the same set
	 */
	public boolean same(int a, int b) {
		if (a == b || find(a) == find(b))
			return true;
		return false;
	}
	
	/**
	 * Finds the root element of the set containing <i>x</i>, used as an unique identifier for a set.<br>
	 * Also sets the parent of every visited member to the root element.
	 * 
	 * @param x member of the set which root is sought after
	 * @return root of the set containing <i>x</i>
	 */
	private int find(int x) {
		if (parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}
}
