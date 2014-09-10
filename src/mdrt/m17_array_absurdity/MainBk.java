package mdrt.m17_array_absurdity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MainBk implements Runnable {
    private final String fileName;

    public MainBk(final String fileName) {
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
        String[] strArray = line.split(";")[1].split(",");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        Arrays.sort(intArray);

        StringBuilder sb = new StringBuilder();

        int pre = -1;
        int output = -1;
        for (int i = 0; i < intArray.length; i++) {
            if (i > 0 && pre == intArray[i] && pre != output) {
                sb.append(pre).append("\n");
                output = intArray[i];
            }
            pre = intArray[i];
        }

        if (sb.length() > 0) {
            System.out.print(sb);
        }
    }

    public static void main(String[] args) {
        new MainBk(args[0]).run();
    }
}
