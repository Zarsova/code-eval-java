package easy.e40_morse_code;

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
        if (line.length() > 0) {
            System.out.println(Morse.decode(line));
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

class Morse {
    final static Map<String, Character> CODE = new HashMap<String, Character>() {
        {
            put("-", 'T');
            put(".", 'E');
            put("--", 'M');
            put("-.", 'N');
            put(".-", 'A');
            put("..", 'I');
            put("---", 'O');
            put("--.", 'G');
            put("-.-", 'K');
            put("-..", 'D');
            put(".--", 'W');
            put(".-.", 'R');
            put("..-", 'U');
            put("...", 'S');
            put("--.-", 'Q');
            put("--..", 'Z');
            put("-.--", 'Y');
            put("-.-.", 'C');
            put("-..-", 'X');
            put("-...", 'B');
            put(".---", 'J');
            put(".--.", 'P');
            put(".-..", 'L');
            put("..-.", 'F');
            put("...-", 'V');
            put("....", 'H');
            put(".----", '1');
            put("..---", '2');
            put("...--", '3');
            put("....-", '4');
            put(".....", '5');
            put("-....", '6');
            put("--...", '7');
            put("---..", '8');
            put("----.", '9');
            put("-----", '0');
        }
    };

    public static String decode(String line) {
        String[] strArray = line.split("  ");
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String[] letters = str.split(" ");
            for (String letter : letters) {
                sb.append(CODE.get(letter));
            }
        }
        return sb.toString();
    }
}