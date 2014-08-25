package easy.e28_find_a_writer;

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
            String[] strArray = line.split("\\| ");
            char[] firstPart = strArray[0].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (String str : strArray[1].split(" ")) {
                sb.append(firstPart[Integer.parseInt(str) - 1]);
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}