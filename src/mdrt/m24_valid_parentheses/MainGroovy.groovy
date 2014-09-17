package mdrt.m24_valid_parentheses

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["()", "True"],
                ["([)]", "False"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
