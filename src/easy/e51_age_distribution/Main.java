package easy.e51_age_distribution;

import java.io.BufferedReader;
import java.io.FileReader;

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
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                final int age = Integer.parseInt(line);
                if (age < 0) {
                    System.out.println("This program is for humans");
                } else if (age < 3) {
                    System.out.println("Still in Mama's arms");
                } else if (age < 5) {
                    System.out.println("Preschool Maniac");
                } else if (age < 12) {
                    System.out.println("Elementary school");
                } else if (age < 15) {
                    System.out.println("Middle school");
                } else if (age < 19) {
                    System.out.println("High school");
                } else if (age < 23) {
                    System.out.println("College");
                } else if (age < 66) {
                    System.out.println("Working for the man");
                } else if (age < 101) {
                    System.out.println("The Golden Years");
                } else {
                    System.out.println("This program is for humans");
                }
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
