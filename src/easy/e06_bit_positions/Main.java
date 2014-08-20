package easy.e06_bit_positions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            String[] strArray = line.split(",");
            if (strArray.length > 0) {
                int n = Integer.parseInt(strArray[0]);
                int p1 = Integer.parseInt(strArray[1]);
                int p2 = Integer.parseInt(strArray[2]);
                if (isSameBitPosition(n, p1, p2)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }

    public static boolean isSameBitPosition(int n, int p1, int p2) {
        String binStr = Integer.toBinaryString(n);
        return binStr.charAt(binStr.length() - p1) == binStr.charAt(binStr.length() - p2);
    }
}
