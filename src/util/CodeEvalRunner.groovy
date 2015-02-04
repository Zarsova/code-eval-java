package util

class CodeEvalRunner {
    static def run(List inputs, Class<?> mainClass, expects = null) {
        if (expects == null) {
            inputs.eachWithIndex { List testCase, i ->
                testCase[0].eachLine { line ->
                    println "case ${i + 1} <-- ${line}"
                }
                testCase[1].eachLine { line ->
                    println "case ${i + 1} --> ${line}"
                }
                callMain([testCase[0]], mainClass)
            }
        } else {
            inputs.eachWithIndex { def line, int i ->
                line.eachLine { def ll ->
                    println "in  ${i + 1} <-- ${ll}"
                }
            }
            expects.eachWithIndex { def line, int i ->
                line.eachLine { def ll ->
                    println "out ${i + 1} --> ${ll}"
                }
            }
            callMain(inputs, mainClass)
        }
    }

    static long callMain(List inputs, Class<?> mainClass) {
        File tmp
        if (inputs != null && inputs.size() > 0) {
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
        mainClass."$main"(inputs as String[])
        long duration = System.currentTimeMillis() - start
        if (tmp) {
            tmp.deleteOnExit()
        }
        return duration
    }

    static void runAndPerf(List inputs, Class<?> mainClass, eachLine = false, long timeout = 1000) {
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
                input.eachLine { line -> println "case ${idx} <-- ${line}" }
                callMain([input], mainClass)
            }
        }
        inputs.each { input ->
            println "case all <-- ${input}"
        }
        callMain(inputs, mainClass)
    }
}
