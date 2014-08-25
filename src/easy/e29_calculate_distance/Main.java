package easy.e29_calculate_distance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        if (line.length() > 0) {
            String[] strArray = line.split("[\\(|\\)|,| ]+");
            int x1 = Integer.parseInt(strArray[1]);
            int y1 = Integer.parseInt(strArray[2]);
            int x2 = Integer.parseInt(strArray[3]);
            int y2 = Integer.parseInt(strArray[4]);
            System.out.println((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}