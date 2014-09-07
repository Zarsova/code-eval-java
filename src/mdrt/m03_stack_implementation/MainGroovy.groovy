package mdrt.m03_stack_implementation

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m03_stack_implementation.txt"] as String[], Main)
        CodeEvalRunner.runAndPerf(["1 2 3 4",
                            "10 -2 3 4"
        ], Main, true)
    }
}
