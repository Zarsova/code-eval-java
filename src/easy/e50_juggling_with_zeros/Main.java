package easy.e50_juggling_with_zeros;

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
                String[] strArray = line.split(" ");
                long result = 0;
                for (int i = 0, length = strArray.length; i < length; i += 2) {
                    final int ope = strArray[i].length();
                    final int value = strArray[i + 1].length();
                    if (ope == 1) {
                        result <<= value;
                    } else {
                        for (int j = 0; j < value; j++) {
                            result <<= 1;
                            result++;
                        }
                    }
                }
                System.out.println(result);
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
