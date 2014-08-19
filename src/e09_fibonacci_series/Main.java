package e09_fibonacci_series;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    private static final HashMap<Integer, Integer> fibs = new HashMap<>();

    public static int calc(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        if (fibs.containsKey(n)) {
            return fibs.get(n);
        } else {
            int ret = calc(n - 1) + calc(n - 2);
            fibs.put(n, ret);
            return ret;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            int fib = calc(Integer.parseInt(line));
            System.out.println(Integer.toString(fib));
        }
    }
}
