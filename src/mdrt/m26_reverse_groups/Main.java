package mdrt.m26_reverse_groups;

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
        String[] strArray = line.split(";");
        String[] seqStrArray = strArray[0].split(",");

        int k = Integer.parseInt(strArray[1]);
        int[] numbersArray = new int[seqStrArray.length];
        for (int i = 0; i < seqStrArray.length; i++) {
            numbersArray[i] = Integer.parseInt(seqStrArray[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = numbersArray.length; i < length; i++) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            if (((i / k) + 1) * k <= length) {
                int reverse = (i / k) * k + (k - 1 - i % k);
                sb.append(numbersArray[reverse]);
            } else {
                sb.append(numbersArray[i]);
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

