package mdrt.m03_stack_implementation

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["1 2 3 4",
                                   "10 -2 3 4"
        ], Main, true)
    }
}
