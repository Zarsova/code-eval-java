package mdrt.m12_trailing_string

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["Hello World,World", "1"],
                ["Hello CodeEval,CodeEval", "1"],
                ["San Francisco,San Jose", "0"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
