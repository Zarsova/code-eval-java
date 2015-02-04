package easy.e52_roller_coaster

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        CodeEvalRunner.runAndPerf(["To be, or not to be: that is the question.",
                                   "Whether 'tis nobler in the mind to suffer",
                                   "The slings and arrows of outrageous fortune,",
                                   "Or to take arms against a sea of troubles,",
                                   "And by opposing end them? To die: to sleep."
        ], Main, true)
    }
}

