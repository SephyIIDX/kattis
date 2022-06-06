
/**
 * Solves the Kattis problem: fenwick
 */
public class Main {
	
	/**
	 * Reads the input and prints the solution as specified by Kattis.
	 */
	public void runOnKattis() {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt();
		int q = io.getInt();

		FenwickTree ft = new FenwickTree(n);
		
		char query;
		int j;
		int delta;
		for (int i = 0; i < q; i++) {
			query = io.getWord().charAt(0);
			j = io.getInt();
			
			if (query == '+') {
				delta = io.getInt();
				ft.add(j, delta);
			}
			else { //query == '?'
				io.println(ft.sum(j));
			}
		}
		io.close();
	}
	
	public static void main(String[] args) {
		new Main().runOnKattis();
	}
}
