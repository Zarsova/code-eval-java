package mdrt.m01_longest_lines

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["2",
                                   "Hello World",
                                   "CodeEval",
                                   "Quick Fox",
                                   "A",
                                   "San Francisco"
        ] as String[], Main)
    }
}

