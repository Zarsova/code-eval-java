package easy.e23_query_board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
        Matrix matrix = new Matrix(256, 256);
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                parseLine(line, matrix);
            }
        }
        in.close();
    }

    private void parseLine(String line, Matrix matrix) {
        String[] strArray = line.split(" ");
        matrix.ope(strArray);
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}

class Matrix {
    private final int[][] data;

    Matrix(int x, int y) {
        data = new int[y][x];
        for (int[] row : data) {
            Arrays.fill(row, 0);
        }
    }

    public void ope(String[] strArray) {
        OpeEnum ope = OpeEnum.getEnum(strArray[0]);
        switch (ope) {
            case SetCol:
                setCol(Integer.parseInt(strArray[1]), Integer.parseInt(strArray[2]));
                break;
            case SetRow:
                setRow(Integer.parseInt(strArray[1]), Integer.parseInt(strArray[2]));
                break;
            case QueryCol:
                int a = queryCol(Integer.parseInt(strArray[1]));
                System.out.println(a);
                break;
            case QueryRow:
                int b = queryRow(Integer.parseInt(strArray[1]));
                System.out.println(b);
                break;
        }
    }

    private int queryRow(int row) {
        int sum = 0;
        for (int val : data[row]) {
            sum += val;
        }
        return sum;
    }

    private int queryCol(int col) {
        int sum = 0;
        for (int[] row : data) {
            sum += row[col];
        }
        return sum;
    }

    private void setRow(int row, int val) {
        Arrays.fill(data[row], val);
    }

    private void setCol(int col, int val) {
        for (int[] row : data) {
            row[col] = val;
        }
    }
}

enum OpeEnum {
    SetCol("SetCol"),
    SetRow("SetRow"),
    QueryCol("QueryCol"),
    QueryRow("QueryRow");

    private final String name;

    private OpeEnum(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public static OpeEnum getEnum(String str) {
        OpeEnum[] opes = OpeEnum.values();
        for (OpeEnum ope : opes) {
            if (str.equals(ope.name)) {
                return ope;
            }
        }
        return null;
    }
}