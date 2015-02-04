package mdrt.m26_reverse_groups

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["1,2,3,4,5;2", "2,1,4,3,5"],
                ["1,2,3,4,5;3", "3,2,1,4,5"],
                ["1,2,3,4,5,6,7,8;2", " "],
                ["1,2,3,4,5,6,7,8;3", " "],
                ["1,2,3,4,5,6,7,8;4", " "],
                ["1,2,3,4,5,6,7,8;5", " "]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
