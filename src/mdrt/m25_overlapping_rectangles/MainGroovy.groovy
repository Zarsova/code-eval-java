package mdrt.m25_overlapping_rectangles

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["-3,3,-1,1,1,-1,3,-3", "False"],
                ["-3,3,-1,1,-2,4,2,2", "True"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
