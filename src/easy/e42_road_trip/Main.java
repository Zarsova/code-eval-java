package easy.e42_road_trip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile(",(\\d+);");
        List<Integer> distances = new ArrayList<>();

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    distances.add(Integer.parseInt(matcher.group(1)));
                }
                Collections.sort(distances);
                StringBuilder stringBuilder = new StringBuilder();
                int trip = 0;
                for (int distance : distances) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(distance - trip);
                    trip = distance;
                }
                System.out.println(stringBuilder);
                distances.clear();
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}