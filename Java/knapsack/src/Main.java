
import java.util.ArrayList;

/**
 * This program solves the KATTIS problem "knapsack".
 */
public class Main {

    /**
     * Reads the input and prints the solution as specified by KATTIS.
     */
    private void runOnKattis() {
        Kattio io = new Kattio(System.in, System.out);

        int c;
        int n;

        int[] values;
        int[] weights;

        while (io.hasMoreTokens()) {
            c = io.getInt();
            n = io.getInt();

            values = new int[n];
            weights = new int[n];

            for (int i = 0; i < n; i++) {
                values[i] = io.getInt();
                weights[i] = io.getInt();
            }

            ArrayList<Integer> res = Knapsack.pickItems(c, values, weights);

            io.println(res.size());
            for (Integer i : res) {
                io.print(i);
                io.print(' ');
            }
            io.println();
        }
        io.close();
    }

    public static void main(String[] args) {
        new Main().runOnKattis();
    }
}
