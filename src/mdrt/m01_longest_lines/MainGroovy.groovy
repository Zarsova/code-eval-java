package mdrt.m01_longest_lines

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/easy/e52_roller_coaster.txt"] as String[], Main)
        CodeEvalRunner.runAndPerf(["2",
                            "Hello World",
                            "CodeEval",
                            "Quick Fox",
                            "A",
                            "San Francisco"
        ] as String[], Main)
    }
}

