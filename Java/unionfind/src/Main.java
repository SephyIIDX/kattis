
/**
 * Solves the Kattis problem: unionfind
 */
public class Main {

    /**
     * Reads the input and prints the solution as specified by Kattis.
     */
    public void runOnKattis() {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int q = io.getInt();

        UnionFind uf = new UnionFind(n);

        char query;
        int a;
        int b;
        for (int i = 0; i < q; i++) {
            query = io.getWord().charAt(0);
            a = io.getInt();
            b = io.getInt();

            if (query == '=')
                uf.union(a, b);
            else { // query == '?'
                if (uf.same(a, b))
                    io.println("yes");
                else
                    io.println("no");
            }
        }
        io.close();
    }

    public static void main(String[] args) {
        new Main().runOnKattis();
    }
}
