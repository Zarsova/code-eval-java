package easy.e15_set_intersection;

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
                    setIntersection(line);
                }
            }
        } catch (Exception ignored) {
        }
    }

    private static void setIntersection(String line) {
        String[] strArrays = line.split(";");

        String[] strArray0 = strArrays[0].split(",");
        HashSet<Integer> intSet0 = new HashSet<>();
        for (String s : strArray0) {
            intSet0.add(Integer.parseInt(s));
        }

        String[] strArray1 = strArrays[1].split(",");
        HashSet<Integer> retSet = new HashSet<>();
        for (String s : strArray1) {
            int i = Integer.parseInt(s);
            if (intSet0.contains(i)) {
                retSet.add(i);
            }
        }

        if (retSet.isEmpty()) {
            System.out.println();
        } else {
            Integer[] retArray = retSet.toArray(new Integer[retSet.size()]);
            Arrays.sort(retArray);
            StringBuilder sb = new StringBuilder();
            for (int i : retArray) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(Integer.toString(i));
            }
            System.out.println(sb.toString());
        }
    }
}
