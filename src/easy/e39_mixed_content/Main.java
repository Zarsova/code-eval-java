package easy.e39_mixed_content;

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
            String[] strArray = line.split(",");
            StringBuilder result = new StringBuilder();
            StringBuilder numbers = new StringBuilder();
            for (String str : strArray) {
                if (Character.isLetter(str.charAt(0))) {
                    if (result.length() > 0) {
                        result.append(",");
                    }
                    result.append(str);
                } else {
                    if (numbers.length() > 0) {
                        numbers.append(",");
                    }
                    numbers.append(str);
                }
            }
            if (numbers.length() > 0) {
                if (result.length() > 0) {
                    result.append("|");
                }
                result.append(numbers);
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

