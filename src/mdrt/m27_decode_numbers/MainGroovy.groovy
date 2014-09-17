package mdrt.m27_decode_numbers

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["12", "2"],
                ["123", "3"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
