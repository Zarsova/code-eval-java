package easy.e16_rightmost_char;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    String[] strArray = line.split(",");
                    System.out.println(Integer.toString(strArray[0].lastIndexOf(strArray[1])));
                }
            }
        } catch (Exception ignored) {
        }
    }
}
