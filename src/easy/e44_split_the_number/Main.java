package easy.e44_split_the_number;

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

    private void parseLine(String line) {
        String[] strArray = line.split(" ");
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('+', '+');
            put('-', '-');
        }};

        // init map
        char index = 'a';
        for (char c : strArray[0].toCharArray()) {
            map.put(index, c);
            index++;
        }

        // convert test case
        StringBuilder testCase = new StringBuilder();
        for (char c : strArray[1].toCharArray()) {
            testCase.append(map.get(c));
        }

        StringBuilder from = new StringBuilder();
        for (int i = 0; i < testCase.length(); i++) {
            if (testCase.charAt(i) == '+') {
                System.out.println(Integer.parseInt(from.toString()) + Integer.parseInt(testCase.substring(i + 1)));
                break;
            } else if (testCase.charAt(i) == '-') {
                System.out.println(Integer.parseInt(from.toString()) - Integer.parseInt(testCase.substring(i + 1)));
                break;
            } else {
                from.append(testCase.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
