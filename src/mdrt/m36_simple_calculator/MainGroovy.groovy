package mdrt.m36_simple_calculator

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["250*14.3", "3575"],
                ["3^6 / 117", "6.23077"],
                ["(2.16 - 48.34)^-1", "−0.02165"],
                ["(59 - 15 + 3*6)/21", "2.95238"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
