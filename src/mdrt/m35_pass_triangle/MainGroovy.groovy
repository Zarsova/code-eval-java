package mdrt.m35_pass_triangle

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                "5\n" +
                        "9 6\n" +
                        "4 6 8\n" +
                        "0 7 1 5"
        ]
        CodeEvalRunner.run(inputs, Main, ["27"])
    }
}
