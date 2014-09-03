package easy.e46_racing_chars;

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
        int non_checkpoint, checkpoint, position;
        int previousPosition = -1;

        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                non_checkpoint = line.indexOf('_');
                checkpoint = line.indexOf('C');

                position = checkpoint != -1 ? checkpoint : non_checkpoint;
                char[] charArray = line.toCharArray();
                if (previousPosition == -1 || previousPosition == position) {
                    charArray[position] = '|';
                } else if (previousPosition > position) {
                    charArray[position] = '/';
                } else {
                    charArray[position] = '\\';
                }
                previousPosition = position;

                System.out.println(charArray);
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

