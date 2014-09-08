package mdrt.m10_sum_of_integers

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["-10, 2, 3, -2, 0, 5, -15", "8"],
                ["2,3,-2,-1,10", "12"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
