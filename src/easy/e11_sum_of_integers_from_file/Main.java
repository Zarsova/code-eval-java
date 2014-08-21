package easy.e11_sum_of_integers_from_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    sum += Integer.parseInt(line);
                }
            }
            in.close();
        } catch (IOException e) {
        }
        System.out.println(Integer.toString(sum));
    }
}
