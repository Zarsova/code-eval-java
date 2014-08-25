package easy.e26_capitalize_words;

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
        String[] strArray = line.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str.substring(0, 1).toUpperCase());
            if (str.length() > 1) {
                sb.append(str.substring(1));
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}