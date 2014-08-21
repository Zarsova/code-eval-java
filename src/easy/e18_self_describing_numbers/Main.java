package easy.e18_self_describing_numbers;

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
                    boolean ret = isSelfDescribingNumber(line);
                    if (ret) {
                        System.out.println('1');
                    } else {
                        System.out.println('0');
                    }
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isSelfDescribingNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (Integer.parseInt(str.substring(j, j + 1)) == i) {
                    count++;
                }
            }
            if (count != Integer.parseInt(str.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }
}
