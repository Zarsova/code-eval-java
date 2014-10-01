package mdrt.m36_simple_calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private void parseLine(String line) {
        CalcParser parser = new CalcParser(line);
        parser.reverse();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }

}


class CalcParser {
    String line;
    int idx = 0;
    boolean isValue;
    private String token;

    CalcParser(String line) {
        this.line = line;
    }


    final List<Character> brackets = Arrays.asList('(', ')');
    final Map<Character, Integer> operators = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('^', 3);
        put('(', 5);
        put(')', 5);
    }};


    void reverse() {
        String token;
        while ((token = getToken()) != null) {
            System.out.println(token);
        }
    }

    public String getToken() {
        StringBuilder sb = new StringBuilder();
        while (idx < line.length()) {
            char c = line.charAt(idx);
            if (Character.isDigit(c) || c == '.' || (!isValue && c == '-')) {
                sb.append(c);
                idx++;
            } else if (sb.length() > 0) {
                isValue = true;
                String result = sb.toString();
                sb = new StringBuilder();
                return result;
            } else if (c == ' ') {
                idx++;
            } else {
                isValue = false;
                idx++;
                return Character.toString(c);
            }
        }
        if (sb.length() > 0) {
            String result = sb.toString();
            return result;
        }
        return null;
    }
}