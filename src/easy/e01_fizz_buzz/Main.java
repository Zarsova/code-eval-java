package easy.e01_fizz_buzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private int fizz;
    private int buzz;
    private int last;

    public Main(int fizz, int buzz, int last) {
        this.fizz = fizz;
        this.buzz = buzz;
        this.last = last;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        boolean fizzOrBuzz;
        for (int i = 1; i <= last; i++) {
            fizzOrBuzz = false;
            if (i > 1) {
                sb.append(" ");
            }
            if (i % fizz == 0) {
                sb.append("F");
                fizzOrBuzz = true;
            }
            if (i % buzz == 0) {
                sb.append("B");
                fizzOrBuzz = true;
            }
            if (!fizzOrBuzz) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lineArray = line.split(" ");
            if (lineArray.length > 0) {
                int fizz = Integer.parseInt(lineArray[0]);
                int buzz = Integer.parseInt(lineArray[1]);
                int last = Integer.parseInt(lineArray[2]);
                System.out.println(new Main(fizz, buzz, last).toString());
            }
        }
    }
}
