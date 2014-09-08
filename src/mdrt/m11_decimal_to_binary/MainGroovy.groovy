package mdrt.m11_decimal_to_binary

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["2", "10"],
                ["10", "1010"],
                ["67", "1000011"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
