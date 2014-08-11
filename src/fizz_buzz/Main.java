package fizz_buzz;
/*Sample code to read in test cases:
public class Main {
    public static void main (String[] args) {
    ...
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split("\s");
        if (lineArray.length > 0) {
            //Process line of input Here
        }
    }
  }
}
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private int[] intArray;

    public Main(int[] intArray) {
        this.intArray = intArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        boolean fizzOrBuzz;
        for (int i = 1; i <= intArray[2]; i++) {
            fizzOrBuzz = false;
            if (i > 1) {
                sb.append(" ");
            }
            if (i % intArray[0] == 0) {
                sb.append("F");
                fizzOrBuzz = true;
            }
            if (i % intArray[1] == 0) {
                sb.append("B");
                fizzOrBuzz = true;
            }
            if (!fizzOrBuzz) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        File file = new File(args[0]);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line;
            int[] intArray = new int[3];
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(" ");
                if (lineArray.length > 0) {
                    for (int i = 0; i < 3; i++) {
                        intArray[i] = Integer.parseInt(lineArray[i]);
                    }
                    System.out.println(new Main(intArray));
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
