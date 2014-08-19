package e05_multiples_of_a_number;

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
            String[] lineArray = line.split(",");
            if (lineArray.length > 0) {
                int x = Integer.parseInt(lineArray[0]);
                int n = Integer.parseInt(lineArray[1]);
                multi(x, n, 1);
            }
        }
    }

    public static void multi(int x, int n, int multiple) {
        int result = n * multiple;
        if (x <= result) {
            System.out.println(result);
        } else {
            multi(x, n, multiple + 1);
        }
    }
}
