package mdrt.m20_prime_numbers

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["8000", "2,3,5,7"],
                ["9000", "2,3,5,7,11,13,17,19"],
                ["3000", "2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
