package mdrt.m09_number_of_ones

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["10", "2"],
                ["22", "3"],
                ["56", "3"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
