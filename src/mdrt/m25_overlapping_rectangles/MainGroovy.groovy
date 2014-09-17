package mdrt.m25_overlapping_rectangles

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["-3,3,-1,1,1,-1,3,-3", "False"],
                ["-3,3,-1,1,-2,4,2,2", "True"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
