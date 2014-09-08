package mdrt.m14_number_pairs

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["1,2,3,4,6;5", "1,4;2,3"],
                ["2,4,5,6,9,11,15;20", "5,15;9,11"],
                ["1,2,3,4;50", "NULL"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
