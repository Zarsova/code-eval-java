package mdrt.m24_valid_parentheses

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["()", "True"],
                ["([)]", "False"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
