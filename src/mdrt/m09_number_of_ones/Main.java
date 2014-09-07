package mdrt.m09_number_of_ones;

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
        int n = Integer.parseInt(line);
        int x = 0;
        while (n > 0) {
            if ((n & 0x1) == 0x1) {
                x++;
            }
            n = n >> 1;
        }
        System.out.println(x);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
