package mdrt.m05_lowest_common_ancestor

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m04_mth_to_last_element.txt"] as String[], Main)
        CodeEvalRunner.runAndPerf(["8 52",
                            "3 29"
        ] as String[], Main, true)
    }
}
