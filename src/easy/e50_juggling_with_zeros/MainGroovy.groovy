package easy.e50_juggling_with_zeros

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.run(["input/easy/e50_juggling_with_zeros.txt"] as String[], Main)
        CodeEvalRunner.run(["00 0 0 00 00 0",
                            "00 0",
                            "00 0 0 000 00 0000000 0 000",
                            "0 000000000 00 00"
        ] as String[], Main, true)
    }
}

