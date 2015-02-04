package mdrt.m21_cash_register;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main implements Runnable {
    private final String fileName;
    private final Map<Integer, String> billAndCoins = new HashMap<Integer, String>() {{
        put(1, "PENNY");
        put(5, "NICKEL");
        put(10, "DIME");
        put(25, "QUARTER");
        put(50, "HALF DOLLAR");
        put(100, "ONE");
        put(200, "TWO");
        put(500, "FIVE");
        put(1000, "TEN");
        put(2000, "TWENTY");
        put(5000, "FIFTY");
        put(10000, "ONE HUNDRED");
    }};

    public Main(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            parseLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLines() throws IOException {
        final BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                parseLine(line);
            }
        }
        in.close();
    }

    private void parseLine(String line) {
        final String[] strArray = line.split(";");
        final int pp = (int) (Double.parseDouble(strArray[0]) * 100);
        final int ch = (int) (Double.parseDouble(strArray[1]) * 100);

        Integer[] keys = billAndCoins.keySet().toArray(new Integer[billAndCoins.size()]);
        Arrays.sort(keys);

        final StringBuffer sb = new StringBuffer();
        if (ch > pp) {
            int x = ch - pp;
            while (x > 0) {
                for (int i = keys.length - 1; i >= 0; i--) {
                    if (x >= keys[i]) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(billAndCoins.get(keys[i]));
                        x -= keys[i];
                        i++;
                    }
                }
            }
        } else if (ch < pp) {
            sb.append("ERROR");
        } else {
            sb.append("ZERO");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
