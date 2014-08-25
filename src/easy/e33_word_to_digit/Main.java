package easy.e33_word_to_digit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    private final Map<String, Integer> NUMBERS = new HashMap<String, Integer>() {
        {
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }
    };

    private void parseLine(String line) {
        if (line.length() > 0) {
            String[] strArray = line.split(";");
            StringBuilder sb = new StringBuilder();
            for (String str : strArray) {
                sb.append(NUMBERS.get(str));
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}