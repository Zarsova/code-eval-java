package mdrt.m04_mth_to_last_element

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m04_mth_to_last_element.txt"] as String[], Main)
        CodeEvalRunner.runAndPerf(["a b c d 4",
                            "e f g h 2"
        ], Main, true)
    }
}
