package mdrt.m16_pangrams;

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
        int i;
        boolean[] alphaExists = new boolean['z' - 'a' + 1];
        Arrays.fill(alphaExists, false);

        for (int c : line.toCharArray()) {
            i = Character.toLowerCase(c) - 'a';
            if (i >= 0 && i < 26) {
                alphaExists[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < 26; i++) {
            if (!alphaExists[i]) {
                sb.append((char) ('a' + i));
            }
        }
        if (sb.length() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
