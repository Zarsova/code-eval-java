package mdrt.m12_trailing_string;

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
        final String[] strArray = line.split(",");
        final String first = strArray[0];
        final String second = strArray[1];
        if (first.contains(second)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
