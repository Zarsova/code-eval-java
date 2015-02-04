package easy.e01_fizz_buzz

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["3 5 10",
                                   "2 3 8"], Main, true)
    }
}
