package easy.e34_romain_numerals;

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

    private final Map<Integer, String> ROMAN_SYMBOLS = new HashMap<Integer, String>() {
        {
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(1000, "M");
        }
    };

    private String toRomanNumber(int n, int base) {
        if (n >= 10) {
            return toRomanNumber(n / 10, base * 10) + toRomanNumber(n % 10, base);
        } else if (n == 4) {
            return ROMAN_SYMBOLS.get(base) + ROMAN_SYMBOLS.get(base * 5);
        } else if (n == 9) {
            return ROMAN_SYMBOLS.get(base) + ROMAN_SYMBOLS.get(base * 10);
        } else if (n > 4) {
            return ROMAN_SYMBOLS.get(base * 5) + toRomanNumber(n - 5, base);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ROMAN_SYMBOLS.get(base));
            }
            return sb.toString();
        }
    }

    private String toRomanNumber(int n) {
        return toRomanNumber(n, 1);
    }

    private void parseLine(String line) {
        if (line.length() > 0) {
            int number = Integer.parseInt(line);
            System.out.println(toRomanNumber(number));
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

