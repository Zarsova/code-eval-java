package easy.e52_roller_coaster;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main implements Runnable {
    private final String fileName;

    public Main(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            parseLines();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseLines() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                boolean toUpper = true;
                char[] charArray = line.toCharArray();
                for (int i = 0, length = charArray.length; i < length; i++) {
                    if (Character.isAlphabetic(charArray[i])) {
                        if (toUpper) {
                            charArray[i] = Character.toUpperCase(charArray[i]);
                        } else {
                            charArray[i] = Character.toLowerCase(charArray[i]);
                        }
                        toUpper = !toUpper;
                    }
                }
                System.out.println(charArray);
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
