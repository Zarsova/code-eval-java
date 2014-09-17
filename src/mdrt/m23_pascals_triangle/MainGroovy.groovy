package mdrt.m23_pascals_triangle

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["6", "1 1 1 1 2 1 1 3 3 1 1 4 6 4 1 1 5 10 10 5 1"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
