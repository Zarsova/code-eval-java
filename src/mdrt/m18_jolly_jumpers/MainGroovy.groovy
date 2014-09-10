package mdrt.m18_jolly_jumpers

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["5;0,1,2,3,0", "0"],
                ["20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14", "4"],
                ["20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14,18,17,14,18,17,14,18,17,14", "4"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
