package mdrt.m18_jolly_jumpers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static byte[] buff;
    static int buffIndex;
    static int buffLimit = Integer.MAX_VALUE;

    static String readLine(final char delimiter) {
        int i, c;
        for (i = buffIndex; i < buffLimit; i++) {
            c = buff[i];
            if ((c == delimiter) || (c == '\n') || (c == '\r')) {
                break;
            }
        }
        String str;
        str = new String(buff, buffIndex, i - buffIndex);
        buffIndex = ++i;
        return str;
    }

    static int readInt(final char delimiter) {
        return Integer.parseInt(readLine(delimiter));
    }

    static double readDouble(final char delimiter) {
        return Double.parseDouble(readLine(delimiter));
    }

    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        try {
            buff = Files.readAllBytes(path);
            buffLimit = buff.length;
        } catch (Exception e) {
        }
        System.out.println(readLine('\n'));
        readInt('\n');
    }
}
