package util

/**
 * Created by develop on 2014/09/02.
 */
class CodeEvalRunner {
    static void run(String[] inputs, Class<?> mainClass, eachLine = false, long timeout = 1000) {
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
        long end
        while ((end = System.currentTimeMillis()) < (start + timeoutMillis)) {
            def lapTime = callMain(inputs, mainClass)
            count++
            if (count < 4) {
                lap.add(lapTime)
            }
        }
        System.setOut(org)
        println("Millis: ${end - start} Times: ${count}, Millis/Process: ${(end - start) * 1.0 / count}, LapTime: ${lap.join(", ")} ..")

        if (eachLine) {
            inputs.eachWithIndex { input, idx ->
                println "<-- case ${idx} -->"
                println input
                callMain([input] as String[], mainClass)
            }
        }
        println "<-- case all -->"
        inputs.each { input ->
            println input
        }
        println "<-- result   -->"
        callMain(inputs, mainClass)
    }

    static long callMain(String[] inputs, Class<?> mainClass) {
        File tmp
        if (inputs != null && inputs.length > 0) {
            if (!new File(inputs[0]).exists()) {
                tmp = File.createTempFile("codeEval", "txt")
                tmp.withPrintWriter { w ->
                    inputs.each { input ->
                        w.println(input)
                    }
                }
                inputs = [tmp.absolutePath] as String[]
            }
        }
        String main = "main"
        long start = System.currentTimeMillis()
        mainClass."$main"(inputs)
        long duration = System.currentTimeMillis() - start
        if (tmp) {
            tmp.deleteOnExit()
        }
        return duration
    }
}
