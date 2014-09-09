package mdrt.m35_pass_triangle

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                "5\n" +
                        "9 6\n" +
                        "4 6 8\n" +
                        "0 7 1 5"
        ]
        CodeEvalRunner.run(inputs, Main, ["27"])
    }
}
