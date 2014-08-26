package easy.e43_compressed_sequence;

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
        String[] strArray = line.split(" ");
        StringBuilder sb = new StringBuilder();
        int seqCount = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (i == 0 || strArray[i - 1].equals(strArray[i])) {
                seqCount++;
            } else {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(seqCount).append(" ").append(strArray[i - 1]);
                seqCount = 1;
            }
        }
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(seqCount).append(" ").append(strArray[strArray.length - 1]);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}