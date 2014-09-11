package mdrt.m22_counting_primes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main implements Runnable {
    private final String fileName;

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
        String[] strArray = line.split(",");
        final int n = Integer.parseInt(strArray[0]);
        final int m = Integer.parseInt(strArray[1]);
        atkinSieve(m);
        int count = 0;
        for (int i = n; i <= m; i++) {
            if (sieve[i] || i == 2 || i == 3 || i == 5) {
                count++;
            }
        }
        System.out.println(count);
    }

    private int[] pow = new int[0];
    private int powIdx = -1;

    private int pow(int n) {
        if (this.powIdx > n) {
            return this.pow[n];
        } else {
            int[] pow = Arrays.copyOf(this.pow, n + 1);
            for (int i = this.powIdx + 1; i <= n; i++) {
                pow[i] = i * i;
            }
            this.pow = pow;
            this.powIdx = n;
            return this.pow[n];
        }
    }

    private boolean[] sieve = new boolean[0];
    private int limit = -1;

    private void atkinSieve(final int _limit) {
        if (limit >= _limit) {
            return;
        }
        int done = limit;
        boolean[] _sieve = Arrays.copyOf(sieve, _limit + 1);
        Arrays.fill(_sieve, done + 1, _limit + 1, false);

        final int factor = (int) Math.sqrt(_limit) + 1;
        pow(factor);
        int i, j, n;
        for (i = 0; i < factor; i++) {
            final int powI = pow(i);
            for (j = 0; j < factor; j++) {
                final int powJ = pow(j);
                n = 4 * powI + powJ;
                if (n > done && n <= _limit && (n % 12 == 1 || n % 12 == 5)) {
                    _sieve[n] = !_sieve[n];
                }
                n = 3 * powI + powJ;
                if (n > done && n <= _limit && (n % 12 == 7)) {
                    _sieve[n] = !_sieve[n];
                }
                if (i > j) {
                    n = 3 * powI - powJ;
                    if (n > done && n <= _limit && (n % 12 == 11)) {
                        _sieve[n] = !_sieve[n];
                    }
                }
            }
        }
        for (i = 5; i < factor; i++) {
            if (_sieve[i]) {
                final int powI = pow(i);
                for (j = powI; j <= _limit; j += powI) {
                    if (j > done) {
                        _sieve[j] = false;
                    }
                }
            }
        }
        sieve = _sieve;
        limit = _limit;
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
