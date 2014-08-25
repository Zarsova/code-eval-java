package easy.e24_simple_sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

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
        String[] strArray = line.split(" ");
        HashMap<Double, String> map = new HashMap<>();
        for (String str : strArray) {
            map.put(Double.parseDouble(str), str);
        }
        Object[] keyList = map.keySet().toArray();
        Arrays.sort(keyList);
        StringBuilder sb = new StringBuilder();
        for (Object key : keyList) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(map.get(key));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}