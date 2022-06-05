
import java.util.ArrayList;

public class Knapsack {

    /**
     * Solves the 0/1 knapsack problem (given capacity of knapsack, value and
     * weight for the items to choose from) using dynamic programming.
     * 
     * Values and weights should be positive integers for meaningful results.
     * 
     * @param capacity the capacity of the knapsack
     * @param values   the values of the items (should be positive integers)
     * @param weights  the weights of the items (should be positive integers)
     * @return the indices of the chosen items in descending order
     * @throws IllegalArgumentException if c <= 0, values.length <= 0 or values and
     *                                  weight are not equal length
     */
    public static ArrayList<Integer> pickItems(int capacity, int[] values, int[] weights) {
        if (values.length != weights.length)
            throw new IllegalArgumentException("values and weights must be of equal length.");

        int n = values.length;

        if (capacity <= 0)
            throw new IllegalArgumentException("c must be a positive integer.");
        if (n <= 0)
            throw new IllegalArgumentException("n must be a positive integer.");

        int[][] m = new int[n + 1][capacity + 1];
        boolean[][] picks = new boolean[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    int tmp = values[i - 1] + m[i - 1][j - weights[i - 1]];
                    m[i][j] = Math.max(m[i - 1][j], tmp);
                    if (tmp > m[i - 1][j])
                        picks[i][j] = true;
                } else
                    m[i][j] = m[i - 1][j];
            }
        }

        // backtrack and store result
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (picks[i + 1][capacity]) {
                res.add(i);
                capacity -= weights[i];
            }
        }
        return res;
    }
}
