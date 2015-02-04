package mdrt.m36_simple_calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    int weight(String token) {
        char c = token.charAt(0);
        if (operators.containsKey(c)) {
            return operators.get(c);
        } else {
            return 0;
        }
    }

    void reverse() {
        String token;
        List<String> orgList = new ArrayList<>();
        List<Integer> weightList = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        List<String> out = new ArrayList<>();
        while ((token = getToken()) != null) {
            int weight = weight(token);
            orgList.add(token);
            weightList.add(weight);

            if (weight == 0) {
                out.add(token);
            }
            String topItem = stack.pop();
            if (weight < weight(topItem)) {

            }
        }
        System.out.println(orgList);
        System.out.println(weightList);
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
                return sb.toString();
            } else if (c == ' ') {
                idx++;
            } else {
                isValue = false;
                idx++;
                return Character.toString(c);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}