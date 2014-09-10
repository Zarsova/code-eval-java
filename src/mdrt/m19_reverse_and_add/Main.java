package mdrt.m19_reverse_and_add;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        long n = Integer.parseInt(line);
        int iteration = 0;
        while (true) {
            final long reverse = reverse(n);
            if (reverse == n) {
                System.out.println(iteration + " " + n);
                break;
            }
            n += reverse;
            iteration++;
        }
    }

    private long reverse(long n) {
        long x = 0L;
        while (n > 0) {
            x *= 10;
            x += n % 10;
            n = n / 10;
        }
        return x;
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
