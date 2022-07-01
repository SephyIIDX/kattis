
/**
 * Solves the Kattis problem: bestcompression
 */
public class Main {

    /**
     * Reads the input and prints the solution as specified by Kattis.
     */
    public void runOnKattis() {
        Kattio io = new Kattio(System.in, System.out);
        if (io.getLong() < (2L << io.getInt()))
            io.println("yes");
        else
            io.println("no");
        io.close();
    }

    public static void main(String[] args) {
        new Main().runOnKattis();
    }
}
