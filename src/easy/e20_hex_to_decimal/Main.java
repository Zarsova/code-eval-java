package easy.e20_hex_to_decimal;

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
                    System.out.println(Integer.parseInt(line, 16));
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
