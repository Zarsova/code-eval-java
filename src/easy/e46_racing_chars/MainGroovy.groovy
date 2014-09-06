package easy.e46_racing_chars

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/easy/e46_racing_chars.txt"] as String[], Main)
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
