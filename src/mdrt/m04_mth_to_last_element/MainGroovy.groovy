package mdrt.m04_mth_to_last_element

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["a b c d 4",
                                   "e f g h 2"
        ], Main, true)
    }
}
