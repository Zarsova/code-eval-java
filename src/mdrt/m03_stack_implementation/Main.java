package mdrt.m03_stack_implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    private void parseLine(final String line) {
        final Stack s = new Stack();
        final String[] strArray = line.split(" ");
        for (String str : strArray) {
            s.push(Integer.parseInt(str));
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0, length = strArray.length; i < length; i++) {
            final int data = s.pop();
            if (i % 2 == 0) {
                if (i != 0) {
                    sb.append(" ");
                }
                sb.append(data);
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

class Stack {
    private final int SIZE = 1024;
    private int p;
    private int[] stack;

    public Stack() {
        stack = new int[SIZE];
        p = 0;
    }

    public void push(int data) {
        stack[p++] = data;
    }

    public int pop() {
        return stack[--p];
    }
}