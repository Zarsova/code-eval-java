package easy.e22_beautiful_strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        char[] chars = line.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : chars) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        List<Integer> charCounts = new ArrayList<>(charCountMap.values());
        Collections.sort(charCounts, Collections.reverseOrder());
        int sum = 0;
        int i, ope;
        for (i = 0, ope = 26; i < charCounts.size(); i++, ope--) {
            sum += ope * charCounts.get(i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
