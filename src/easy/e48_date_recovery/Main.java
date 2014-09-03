package easy.e48_date_recovery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

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
        int i;
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                final String[] strArray = line.split(";");

                final String[] words = strArray[0].split(" ");
                final int length = words.length;
                final String[] places = strArray[1].split(" ");

                int[] tmp = new int[words.length];
                String[] result = new String[length];
                for (i = 0; i < length - 1; i++) {
                    final int index = Integer.parseInt(places[i]);
                    tmp[i] = index;
                    result[index - 1] = words[i];
                }
                Arrays.sort(tmp);
                for (i = 1; i <= length; i++) {
                    if (Arrays.binarySearch(tmp, i) < 0) {
                        result[i - 1] = words[length - 1];
                        break;
                    }
                }

                for (i = 0; i < length; i++) {
                    if (i != 0) {
                        System.out.print(" ");
                    }
                    System.out.print(result[i]);
                }
                System.out.println();
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
