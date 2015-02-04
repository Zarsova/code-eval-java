package mdrt.m10_sum_of_integers

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["-10, 2, 3, -2, 0, 5, -15", "8"],
                ["2,3,-2,-1,10", "12"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
