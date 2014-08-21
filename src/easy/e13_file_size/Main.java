package easy.e13_file_size;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println(new File(args[0]).length());
    }
}
