package mdrt.m04_mth_to_last_element;

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

    private void parseLine(final String line) {
        final String[] strArray = line.split(" ");
        final int index = Integer.parseInt(strArray[strArray.length - 1]);
        if (strArray.length - index > 0) {
            System.out.println(strArray[strArray.length - index - 1]);
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

