package mdrt.m08_endianness

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        CodeEvalRunner.runAndPerf(["how are you, abc",
                            "hello world, def"
        ], Main, true)
    }
}
