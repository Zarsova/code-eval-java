package mdrt.m27_decode_numbers

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["12", "2"],
                ["123", "3"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
