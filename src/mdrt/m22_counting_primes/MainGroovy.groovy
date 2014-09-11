package mdrt.m22_counting_primes

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                "2,10\n20,30"
        ]
        CodeEvalRunner.run(inputs, Main, ["4\n2"])
    }
}
