package mdrt.m24_valid_parentheses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

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
        Stack<Character> stack = new Stack<>();
        char[] charArray = line.toCharArray();
        boolean isValid = true;
        for (char c : charArray) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    isValid = false;
                    break;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    isValid = false;
                    break;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    isValid = false;
                    break;
                }
            }
        }
        System.out.println(isValid && stack.isEmpty() ? "True" : "False");
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
