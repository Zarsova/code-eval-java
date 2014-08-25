package easy.e32_lowest_unique_number;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
            String[] strArray = line.split(" ");
            Integer[] intArray = new Integer[strArray.length];

            Map<Integer, Integer> intCount = new HashMap<>();
            for (int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
                if (intCount.containsKey(intArray[i])) {
                    intCount.put(intArray[i], intCount.get(intArray[i]) + 1);
                } else {
                    intCount.put(intArray[i], 1);
                }
            }

            int minVal = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> e : intCount.entrySet()) {
                if (e.getValue() == 1 && minVal > e.getKey()) {
                    minVal = e.getKey();
                }
            }
            if (minVal == Integer.MAX_VALUE) {
                System.out.println(0);
                return;
            }
            System.out.println(Arrays.asList(intArray).indexOf(minVal) + 1);
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}