package easy.e45_the_major_element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int i, idx;
        int[] intArray = new int[100];
        String line;
        try {
            final BufferedReader in = new BufferedReader(new FileReader(args[0]));
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    final String[] strArray = line.split(",");
                    final int length = strArray.length;
                    final int count = strArray.length / 2;

                    for (i = 0, Arrays.fill(intArray, 0); i < length; i++) {
                        idx = Integer.parseInt(strArray[i]);
                        intArray[idx]++;
                        if (intArray[idx] > count) {
                            System.out.println(idx);
                            break;
                        }
                    }
                    System.out.println("None");
                }
            }
            in.close();
        } catch (IOException e) {
        }
    }
}
