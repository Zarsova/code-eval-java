package mdrt.m20_prime_numbers

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                //"9\n13\n15\n19\n21\n"
                //"7\n11\n13\n17\n19\n"
                "8\n12\n14\n18\n20\n"
        ]
        CodeEvalRunner.run(inputs, Main, ["", "", ""])
    }
}