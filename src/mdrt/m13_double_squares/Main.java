package mdrt.m13_double_squares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main implements Runnable {
    private final String fileName;

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
        int i, count, c, sqrtA;
        double sqrtC, rad, sqrtB, rSqrtB;

        final BufferedReader in = new BufferedReader(new FileReader(fileName));
        final int n = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < n; i++) {
            count = 0;
            c = Integer.parseInt(in.readLine());
            sqrtC = Math.sqrt(c);
            for (sqrtA = 0; sqrtA < sqrtC; sqrtA++) {
                sqrtB = Math.sqrt((double) c - Math.pow(sqrtA, 2));
                if (sqrtA > sqrtB) {
                    break;
                }
                if (sqrtB - (int) sqrtB == 0.0) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        in.close();
    }


    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
