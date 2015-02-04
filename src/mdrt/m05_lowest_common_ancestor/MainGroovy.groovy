package mdrt.m05_lowest_common_ancestor

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["8 52",
                                   "3 29"
        ], Main, true)
    }
}
