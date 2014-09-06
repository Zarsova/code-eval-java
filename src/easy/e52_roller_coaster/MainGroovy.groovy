package easy.e52_roller_coaster

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/easy/e52_roller_coaster.txt"] as String[], Main)
        CodeEvalRunner.runAndPerf(["To be, or not to be: that is the question.",
                            "Whether 'tis nobler in the mind to suffer",
                            "The slings and arrows of outrageous fortune,",
                            "Or to take arms against a sea of troubles,",
                            "And by opposing end them? To die: to sleep."
        ] as String[], Main, true)
    }
}

