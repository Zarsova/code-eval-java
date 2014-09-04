package mdrt.m06_first_non_repeated_character;

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
        int i, j;
        final char[] charArray = line.toCharArray();
        final int length = charArray.length;
        int[] count = new int[length];
        for (i = 0; i < length; i++) {
            if (count[i] == 0) {
                for (j = i + 1; j < length; j++) {
                    if (charArray[i] == charArray[j]) {
                        count[j] = ++count[i];
                    }
                }
                if (count[i] == 0) {
                    System.out.println(charArray[i]);
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
