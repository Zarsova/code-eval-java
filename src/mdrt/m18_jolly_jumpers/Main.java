package mdrt.m18_jolly_jumpers;

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
        final String[] strArray = line.split(" ");
        final int length = strArray.length; // 4

        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        final int diffLength = length - 1; // 3
        boolean[] diffExists = new boolean[diffLength];
        Arrays.fill(diffExists, false);

        boolean isJolly = true;
        for (int i = 0; i < diffLength; i++) {
            final int diff = Math.abs(intArray[i] - intArray[i + 1]);
            if (diff < 1 || diff > diffLength) {
                isJolly = false;
                break;
            }
            if (diffExists[diff - 1]) {
                isJolly = false;
                break;
            }
            diffExists[diff - 1] = true;
        }
        System.out.println(
                isJolly ? "Jolly" : "Not jolly"
        );
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
