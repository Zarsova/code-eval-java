package mdrt.m20_prime_numbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main implements Runnable {
    private final String fileName;
    private boolean[] sieve = new boolean[0];
    private int limit = 0;
    private int[] pow = new int[0];
    private int powIdx = -1;

    public Main(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            parseLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLines() throws IOException {
        final BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                parseLine(line);
            }
        }
        in.close();
    }

    private void parseLine(String line) {
        final int limit = Integer.parseInt(line);
        if (this.limit < limit) {
            atkinSieve(limit, this.limit);
            this.limit = limit;
        }

        final StringBuilder result = new StringBuilder("2,3,5");
        for (int i = 7; i < limit; i++) {
            if (this.sieve[i]) {
                result.append(",").append(i);
            }
        }
        System.out.println(result);
    }

    private int pow(int n) {
        if (this.powIdx > n) {
            return this.pow[n];
        } else {
            int[] pow = Arrays.copyOf(this.pow, n + 1);
            for (int i = this.powIdx + 1; i <= n; i++) {
                pow[i] = (int) Math.pow(i, 2);
            }
            this.pow = pow;
            this.powIdx = n;
            return this.pow[n];
        }
    }

    private void atkinSieve(final int limit, final int done) {
        boolean[] sieve = Arrays.copyOf(this.sieve, limit + 1);
        Arrays.fill(sieve, done + 1, limit, false);
        final int factor = (int) Math.sqrt(limit) + 1;
        pow(factor);
        int i, j, n;
        for (i = 0; i < factor; i++) {
            final int powI = pow(i);
            for (j = 0; j < factor; j++) {
                final int powJ = pow(j);
                n = 4 * powI + powJ;
                if (n >= done && n < limit && (n % 12 == 1 || n % 12 == 5)) {
                    sieve[n] = !sieve[n];
                }
                n = 3 * powI + powJ;
                if (n >= done && n < limit && (n % 12 == 7)) {
                    sieve[n] = !sieve[n];
                }
                if (i > j) {
                    n = 3 * powI - powJ;
                    if (n >= done && n < limit && (n % 12 == 11)) {
                        sieve[n] = !sieve[n];
                    }
                }
            }
        }
        for (i = 5; i < factor; i++) {
            if (sieve[i]) {
                final int powI = pow(i);
                for (j = powI; j < limit; j += powI) {
                    if (j >= done) {
                        sieve[j] = false;
                    }
                }
            }
        }
        this.sieve = sieve;
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
