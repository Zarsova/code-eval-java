package easy.e49_lettercase_percentage_ratio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

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
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                char[] charArray = line.toCharArray();
                int lower = 0, upper = 0, total = 0;
                for (char c : charArray) {
                    if (Character.isLowerCase(c)) {
                        lower++;
                        total++;
                    } else if (Character.isUpperCase(c)) {
                        upper++;
                        total++;
                    }
                }
                System.out.println("lowercase: " + decimalFormat.format((double) 100 * lower / total)
                        + " uppercase: " + decimalFormat.format((double) 100 * upper / total));
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
