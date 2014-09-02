package util

import easy.e01_fizz_buzz.Main

/**
 * Created by develop on 2014/09/02.
 */
class CodeEvalRunner {
    static void run(Object[] inputs, Class<Main> mainClass, long timeout = 200) {
        ArrayList lap = []
        PrintStream org = System.out
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            void write(int b) throws IOException {
                // Do nothing
            }
        }))
        int timeoutMillis = timeout
        long start = System.currentTimeMillis()
        int count = 0
        String main = "main"
        long end
        while ((end = System.currentTimeMillis()) < (start + timeoutMillis)) {
            mainClass."$main"(inputs)
            count++
            if (count < 4) {
                lap.add(System.currentTimeMillis() - start)
            }
        }
        System.setOut(org)
        println("Millis: ${end - start} Times: ${count}, Millis/Process: ${(end - start) * 1.0 / count}, LapTime: ${lap.join(", ")} ..")

        inputs.eachWithIndex { input, idx ->
            println "<-- case ${idx} -->"
            println input
            mainClass."$main"(inputs)
        }
    }
}
