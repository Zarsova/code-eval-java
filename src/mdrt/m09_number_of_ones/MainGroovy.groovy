package mdrt.m09_number_of_ones

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["10", "2"],
                ["22", "3"],
                ["56", "3"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
