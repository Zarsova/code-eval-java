package mdrt.m02_detecting_cycles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main implements Runnable {
    private final String fileName;

    public Main(String fileName) {
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
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                parseLine(line);
            }
        }
        in.close();
    }

    private void parseLine(String line) {
        final String[] strArray = line.split(" ");
        int[] sequence = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            sequence[i] = Integer.parseInt(strArray[i]);
        }
        for (int i = 0; i < sequence.length; i++) {
            try {
                final int[] ret = floyd(sequence, i);
                final int iam = ret[0];
                final int mu = ret[1];
                for (int j = 0; j < iam; j++) {
                    if (j != 0) {
                        System.out.print(" ");
                    }
                    System.out.print(sequence[mu + j]);
                }
                System.out.println();
                break;
            } catch (ArrayIndexOutOfBoundsException obe) {
            }
        }
    }

    private int[] floyd(final int[] sequence, final int x0) {
        int tortoise = x0 + 1;
        int hare = x0 + 2;
        while (sequence[tortoise] != sequence[hare]) {
            tortoise++;
            hare += 2;
        }

        int mu = x0;
        tortoise = x0;

        while (sequence[tortoise] != sequence[hare]) {
            tortoise++;
            hare++;
            mu += 1;
        }

        int iam = 1;
        hare = tortoise + 1;
        while (sequence[tortoise] != sequence[hare]) {
            hare++;
            iam++;
        }
        return new int[]{iam, mu};
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
