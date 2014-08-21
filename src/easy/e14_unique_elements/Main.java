package easy.e14_unique_elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    HashSet<Integer> intSet = new HashSet<>();
                    String[] strArray = line.split(",");
                    for (String str : strArray) {
                        intSet.add(Integer.parseInt(str));
                    }
                    Integer[] intArray = intSet.toArray(new Integer[intSet.size()]);
                    Arrays.sort(intArray);
                    StringBuilder sb = new StringBuilder();
                    for (Integer i : intArray) {
                        if (sb.length() > 0) {
                            sb.append(',');
                        }
                        sb.append(Integer.toString(i));
                    }
                    System.out.println(sb.toString());
                }
            }
        } catch (Exception e) {
        }
    }
}
