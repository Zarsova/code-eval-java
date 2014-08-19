package e02_reverse_words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lineArray = line.split(" ");
            if (lineArray.length > 0) {
                StringBuilder sb = new StringBuilder("");
                for (int i = lineArray.length; i > 0; i--) {
                    if (i != lineArray.length) {
                        sb.append(" ");
                    }
                    sb.append(lineArray[i - 1]);
                }
                System.out.println(sb);
            }
        }
    }
}
