package easy.e27_swap_case;

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
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}