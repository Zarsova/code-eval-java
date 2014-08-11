package e01fizz_buzz;

import java.io.*;

public class MainBk {
    int fizz = 0;
    int buzz = 0;
    int last = 0;

    public MainBk(String[] array) {
        fizz = Integer.parseInt(array[0]);
        buzz = Integer.parseInt(array[1]);
        last = Integer.parseInt(array[2]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i <= last; i++) {
            String sep = (i == 1) ? "" : " ";
            if (i % fizz == 0 && i % buzz == 0) {
                sb.append(sep).append("FB");
            } else if (i % fizz == 0) {
                sb.append(sep).append("F");
            } else if (i % buzz == 0) {
                sb.append(sep).append("B");
            } else {
                sb.append(sep).append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            File file = new File(args[0]);
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(file));
                String line;
                while ((line = in.readLine()) != null) {
                    String[] lineArray = line.split(" ");
                    if (lineArray.length > 0) {
                        new MainBk(lineArray).toString();
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
