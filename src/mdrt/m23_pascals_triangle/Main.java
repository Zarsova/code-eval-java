package mdrt.m23_pascals_triangle;

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
        int depth = Integer.parseInt(line);
        int[] tmpArray = new int[0];
        StringBuilder sb = new StringBuilder();
        while (depth > 0) {
            tmpArray = pascal(tmpArray);
            for (int i = 0, length = tmpArray.length; i < length; i++) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(tmpArray[i]);
            }
            depth--;
        }
        System.out.println(sb);
    }

    private int[] pascal(final int[] input) {
        final int length = input.length;
        int[] result = new int[input.length + 1];
        for (int i = 0; i <= length; i++) {
            if (i == 0 || i == length) {
                result[i] = 1;
            } else {
                result[i] = input[i - 1] + input[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
