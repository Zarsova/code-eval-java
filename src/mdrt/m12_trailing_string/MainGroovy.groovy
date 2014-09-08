package mdrt.m12_trailing_string

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["Hello World,World", "1"],
                ["Hello CodeEval,CodeEval", "1"],
                ["San Francisco,San Jose", "0"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
