package mdrt.m08_endianness;

import java.nio.ByteOrder;

public class Main implements Runnable {

    @Override
    public void run() {
        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            System.out.println("BigEndian");
        } else {
            System.out.println("LittleEndian");
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
