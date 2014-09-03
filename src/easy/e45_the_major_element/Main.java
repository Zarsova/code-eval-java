package easy.e45_the_major_element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main implements Runnable {
    private final String fileName;

    public Main(String fileName) {
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
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                parseLine(line);
            }
        }
        in.close();
    }

    private void parseLine(String line) {
        String[] strArray = line.split(",");

        int[] shorts = new int[101];
        Arrays.fill(shorts, 0);

        for (int i = 0, length = strArray.length, count = strArray.length / 2; i < length; i++) {
            int idx = Integer.parseInt(strArray[i]);
            shorts[idx]++;
            if (shorts[idx] > count) {
                System.out.println(idx);
                return;
            }
        }
        System.out.println("None");
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
