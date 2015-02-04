package easy.e46_racing_chars

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["#########_##\n" +
                                           "########C_##\n" +
                                           "#######_####\n" +
                                           "######_#C###\n" +
                                           "#######_C###\n" +
                                           "#######_####\n" +
                                           "######C#_###\n" +
                                           "######C_####\n" +
                                           "#######_####\n" +
                                           "#######_####"
        ] as String[], Main)
    }
}
