package easy.e38_multiply_lists;

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
            String[] strArray = line.split(" \\| ");
            String[] list1 = strArray[0].split(" ");
            String[] list2 = strArray[1].split(" ");
            int[] result = new int[list1.length];
            for (int i = 0; i < list1.length; i++) {
                int x = Integer.parseInt(list1[i]);
                int y = Integer.parseInt(list2[i]);
                result[i] = x * y;
            }
            StringBuilder sb = new StringBuilder();
            for (int number : result) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(Integer.toString(number));
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

