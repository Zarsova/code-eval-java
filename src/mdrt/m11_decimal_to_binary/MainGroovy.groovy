package mdrt.m11_decimal_to_binary

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["2", "10"],
                ["10", "1010"],
                ["67", "1000011"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
