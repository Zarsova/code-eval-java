package easy.e19_n_mod_m;

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
                    int[] values = split(line, ",");
                    System.out.println(mod(values[0], values[1]));
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int mod(final int n, final int m) {
        return n - (n / m) * m;
    }

    private static int[] split(final String str, final CharSequence delimiter) {
        String[] strings = str.split(delimiter.toString());
        int[] values = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            values[i] = Integer.parseInt(strings[i]);
        }
        return values;
    }

    private static String join(final int[] elements, final CharSequence delimiter) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            if (sb.length() > 0) {
                sb.append(delimiter);
            }
            sb.append(Integer.toString(elements[i]));
        }
        return sb.toString();
    }
}
