package mdrt.m07_remove_characters;

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
        final String[] strArray = line.split(", ");
        final char[] string = strArray[0].toCharArray();
        final char[] delChars = strArray[1].toCharArray();
        final StringBuilder sb = new StringBuilder();
        for (final char c : string) {
            for (int i = 0, length = delChars.length; i < length; i++) {
                if (c == delChars[i]) {
                    break;
                }
                if (i == length - 1) {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
