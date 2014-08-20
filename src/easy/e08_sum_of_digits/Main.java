package easy.e08_sum_of_digits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            int result = 0;
            for (int i = 0; i < line.length(); i++) {
                String c = line.substring(i, i + 1);
                result += Integer.parseInt(c);
            }
            System.out.println(Integer.toString(result));
        }
    }
}
