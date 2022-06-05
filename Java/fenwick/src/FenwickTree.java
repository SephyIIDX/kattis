
public class FenwickTree {
	private long[] tree;
	
	public FenwickTree(int n) {
		tree = new long[n];
	}
	
	public void add(int i, int v) {
		while (i < tree.length) {
			tree[i] += v;
			
			i |= (i+1);
		}
	}
	
	public long sum(int i) {
		long sum = 0;
		while (i > 0) {
			sum += tree[i-1];
			
			i -= (i & -i);
		}
		return sum;
	}
}
