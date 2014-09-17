package mdrt.m25_overlapping_rectangles;

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
        String[] strArray = line.split(",");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        Rectangle a = new Rectangle(intArray[0], intArray[1], intArray[2], intArray[3]);
        Rectangle b = new Rectangle(intArray[4], intArray[5], intArray[6], intArray[7]);
        for (int[] corner : a.corners()) {
            if (b.isOverLap(corner[0], corner[1])) {
                System.out.println("True");
                return;
            }
        }
        for (int[] corner : b.corners()) {
            if (a.isOverLap(corner[0], corner[1])) {
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

class Rectangle {
    int upper, lower, left, right;

    public Rectangle(int left, int upper, int right, int lower) {
        this.upper = upper;
        this.lower = lower;
        this.left = left;
        this.right = right;
    }

    public int[][] corners() {
        return new int[][]{
                {this.left, this.upper},
                {this.right, this.upper},
                {this.left, this.lower},
                {this.right, this.lower}
        };
    }

    public boolean isOverLap(int x, int y) {
        return x >= left && x <= right && y >= lower && y <= upper;
    }
}