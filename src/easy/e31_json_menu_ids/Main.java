package easy.e31_json_menu_ids;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        Pattern pattern = Pattern.compile("\"id\": (\\d+), \"label\"");
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                parseLine(line, pattern);
            }
        }
        in.close();
    }

    private void parseLine(String line, Pattern pattern) {
        if (line.length() > 0) {
            Matcher m = pattern.matcher(line);
            int sum = 0;
            while (m.find()) {
                sum += Integer.parseInt(m.group(1));
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}