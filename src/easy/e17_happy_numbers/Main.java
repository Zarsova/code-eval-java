package easy.e17_happy_numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
            String line;
            HappyNumbers hn = new HappyNumbers();
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    boolean ret = hn.calc(Integer.parseInt(line), new ArrayList<Integer>());
                    if (ret) {
                        System.out.println('1');
                    } else {
                        System.out.println('0');
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class HappyNumbers {
    private final HashSet<Integer> happyNumbers = new HashSet<>();
    private final HashSet<Integer> unHappyNumbers = new HashSet<>();

    public HappyNumbers() {
        happyNumbers.add(1);
    }

    public boolean calc(int n, List<Integer> seq) {
        if (n == 1 || happyNumbers.contains(n)) {
            for (int i : seq) {
                happyNumbers.add(i);
            }
            return true;
        } else if (unHappyNumbers.contains(n) || seq.contains(n)) {
            for (int i : seq) {
                unHappyNumbers.add(i);
            }
            return false;
        } else {
            seq.add(n);
            return calc(squaresOfDigits(n), seq);
        }
    }

    private int squaresOfDigits(int n) {
        if (n < 10) {
            return (int) Math.pow(n, 2);
        } else {
            return squaresOfDigits(n / 10) + (int) Math.pow(n % 10, 2);
        }
    }
}
