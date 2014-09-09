package mdrt.m35_pass_triangle;

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
        int[] totalArray = {0};
        int i, length, maxTotal;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                final String[] strArray = line.split(" ");
                length = strArray.length;
                int[] tmp = new int[length];
                for (i = 0; i < length; i++) {
                    if (i == 0) {
                        tmp[i] = totalArray[0] + Integer.parseInt(strArray[i]);
                    } else if (i == length - 1) {
                        tmp[i] = totalArray[i - 1] + Integer.parseInt(strArray[i]);
                    } else {
                        tmp[i] = (totalArray[i - 1] > totalArray[i] ? totalArray[i - 1] : totalArray[i])
                                + Integer.parseInt(strArray[i]);
                    }
                }
                totalArray = tmp;
            }
        }
        maxTotal = 0;
        for (int x : totalArray) {
            maxTotal = Math.max(maxTotal, x);
        }
        System.out.println(maxTotal);
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
