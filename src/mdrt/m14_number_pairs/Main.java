package mdrt.m14_number_pairs;

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
        String[] strArray = line.split(";");
        final int x = Integer.parseInt(strArray[1]);

        strArray = strArray[0].split(",");
        final int length = strArray.length;
        int idx = 0;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
            if (intArray[i] > x / 2 && idx == 0) {
                idx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            for (int j = idx; j < length; j++) {
                if (intArray[i] + intArray[j] == x) {
                    if (sb.length() > 0) {
                        sb.append(";");
                    }
                    sb.append(intArray[i]).append(",").append(intArray[j]);
                    break;
                }
            }
        }
        if (sb.length() == 0) {
            sb.append("NULL");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
