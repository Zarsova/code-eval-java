package easy.e50_juggling_with_zeros

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/easy/e50_juggling_with_zeros.txt"] as String[], Main)
        CodeEvalRunner.runAndPerf(["00 0 0 00 00 0",
                            "00 0",
                            "00 0 0 000 00 0000000 0 000",
                            "0 000000000 00 00"
        ], Main, true)
    }
}

