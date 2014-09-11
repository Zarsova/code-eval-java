package mdrt.m20_prime_numbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main implements Runnable {
    private final String fileName;
    private final boolean debug = false;

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
        atkinSieve(limit - 1);

        final StringBuilder result = new StringBuilder("2,3,5");
        for (int i = 7; i < limit; i++) {
            if (this.sieve[i]) {
                result.append(",").append(i);
            }
        }
        System.out.println(result);
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
        debugPrint("############# limit/new limit", limit, _limit);

        if (limit >= _limit) {
            return;
        }
        int done = limit;

        debugPrint("create _sieve size", _limit + 1);
        debugPrint("sieve(org)", sieve);
        debugPrint("sieve size(org)", sieve.length);

        boolean[] _sieve = Arrays.copyOf(sieve, _limit + 1);

        debugPrint("sieve(copy done)", _sieve);

        Arrays.fill(_sieve, done + 1, _limit + 1, false);

        debugPrint("sieve(fill done)", _sieve);

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


    void debugPrint(String msg, Object... args) {
        if (debug) {
            StringBuilder sb = new StringBuilder();
            for (Object arg : args) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                if (arg instanceof int[]) {
                    sb.append(Arrays.toString((int[]) arg));
                } else if (arg instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) arg));
                } else if (arg instanceof String[]) {
                    sb.append(Arrays.toString((String[]) arg));
                } else {
                    sb.append(arg);
                }
            }
            System.out.println(msg + ": " + sb);
        }
    }

}
