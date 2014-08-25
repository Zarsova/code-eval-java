package easy.e37_swap_elements;

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
            String[] strArray = line.split(" : ");

            String[] numbersStrArray = strArray[0].split(" ");
            int[] numbers = new int[numbersStrArray.length];
            for (int i = 0; i < numbersStrArray.length; i++) {
                numbers[i] = Integer.parseInt(numbersStrArray[i]);
            }

            String[] opeStrArray = strArray[1].split(", ");
            for (String opeStr : opeStrArray) {
                String[] fromTo = opeStr.split("-");
                int from = Integer.parseInt(fromTo[0]);
                int to = Integer.parseInt(fromTo[1]);
                int tmpInt = numbers[from];
                numbers[from] = numbers[to];
                numbers[to] = tmpInt;
            }

            StringBuilder sb = new StringBuilder();
            for (int number : numbers) {
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

