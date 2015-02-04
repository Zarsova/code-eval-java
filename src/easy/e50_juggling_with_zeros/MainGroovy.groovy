package easy.e50_juggling_with_zeros

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["00 0 0 00 00 0",
                                   "00 0",
                                   "00 0 0 000 00 0000000 0 000",
                                   "0 000000000 00 00"
        ], Main, true)
    }
}

