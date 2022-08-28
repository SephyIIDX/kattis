
/**
 * Solves the Kattis problem: moviecollection
 */
public class Main {

    /**
     * Reads the input and prints the solution as specified by Kattis.
     */
    public void runOnKattis() {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();

        for (int k = 0; k < n; k++) {

            int m = io.getInt();
            int r = io.getInt();

            FenwickTree ft = new FenwickTree(m + r + 1);
            int[] pos = new int[m + 1];

            for (int i = 1; i <= m; i++) {
                ft.add(i, 1);
                pos[i] = m - i + 1;
            }

            int j;
            for (int i = 1; i <= r; i++) {
                j = io.getInt();
                io.print(ft.sum(m + r + 1) - ft.sum(pos[j] + 1));
                io.print(' ');
                ft.add(pos[j], -1);
                pos[j] = m + i;
                ft.add(pos[j], 1);
            }
            io.println();
        }
        io.close();
    }

    public static void main(String[] args) {
        new Main().runOnKattis();
    }
}
