
import java.util.HashMap;

/**
 * Solves the Kattis problem: timebomb
 */
public class Main {
    /**
     * Reads the input and prints the solution as specified by Kattis.
     */
    private void runOnKattis() {
        Kattio io = new Kattio(System.in, System.out);

        String[] rows = new String[5];
        HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
        hm.put(31599, '0');
        hm.put(18724, '1');
        hm.put(29671, '2');
        hm.put(31207, '3');
        hm.put(18925, '4');
        hm.put(31183, '5');
        hm.put(31695, '6');
        hm.put(18727, '7');
        hm.put(31727, '8');
        hm.put(31215, '9');

        for (int i = 0; i < rows.length; i++) {
            rows[i] = io.getLine();
        }

        int digits = (rows[0].length() + 1) / 4;

        StringBuilder sb = new StringBuilder();
        int offset = 0;
        int d, c;

        for (int i = 0; i < digits; i++) {
            d = 0;
            c = 0;
            for (int j = 0; j < rows.length; j++) {
                for (int k = 0; k < 3; k++) {
                    if (rows[j].charAt(k + offset) == '*') {
                        d |= (1 << c);
                    }
                    c++;
                }
            }

            if (hm.containsKey(d)) {
                sb.append(hm.get(d));
            }
            else {
                io.println("BOOM!!");
                io.close();
                return;
            }
            offset += 4;
        }

        int code = Integer.valueOf(sb.toString());

        if ((code % 6) == 0)
            io.println("BEER!!");
        else
            io.println("BOOM!!");
        io.close();
    }

    public static void main(String[] args) {
        new Main().runOnKattis();
    }
}
