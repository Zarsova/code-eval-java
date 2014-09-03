package mdrt.m01_longest_lines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main implements Runnable {
    private final String fileName;

    public Main(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            parseLines();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseLines() throws Exception {
        final Comparator<String> comparator = new LengthComparator();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;

        String[] strArray = null;
        int n = -1;
        int count = 0;

        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                if (n == -1) {
                    n = Integer.parseInt(line);
                    strArray = new String[n];
                } else if (count < n) {
                    strArray[count++] = line;
                    if (count == n) {
                        Arrays.sort(strArray, comparator);
                    }
                } else {
                    if (line.length() > strArray[n - 1].length()) {
                        strArray[n - 1] = line;
                        Arrays.sort(strArray, comparator);
                    }
                }
            }
        }
        for (String str : strArray) {
            System.out.println(str);
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }

    class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            final int l1 = o1.length();
            final int l2 = o2.length();
            if (l1 > l2) {
                return -1;
            } else if (l1 < l2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
