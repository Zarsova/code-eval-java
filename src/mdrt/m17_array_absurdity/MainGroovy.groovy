package mdrt.m17_array_absurdity

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["5;0,1,2,3,0", "0"],
                ["20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14", "4"],
                ["26;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14,18,17,14,18,17,14,18,17,14", "4"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
