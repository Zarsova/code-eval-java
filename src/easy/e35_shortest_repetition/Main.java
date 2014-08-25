package easy.e35_shortest_repetition;

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
            int cycle = line.length();
            int i, j;
            for (i = 0, j = 1; j < line.length(); i++, j = j + 2) {
                if (line.charAt(i) == line.charAt(j)) {
                    if (line.substring(0, i).equals(line.substring(i + 1, j))) {
                        cycle = i + 1;
                        break;
                    }
                }
            }
            System.out.println(cycle);
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

