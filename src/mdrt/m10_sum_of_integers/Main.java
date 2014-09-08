package mdrt.m10_sum_of_integers;

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
        String[] strArray = line.split(", *");
        int length = strArray.length;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        int largestSum = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += intArray[j];
                if (largestSum < sum) {
                    largestSum = sum;
                }
            }
        }
        System.out.println(largestSum);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
