package mdrt.m08_endianness

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["how are you, abc",
                                   "hello world, def"
        ], Main, true)
    }
}
