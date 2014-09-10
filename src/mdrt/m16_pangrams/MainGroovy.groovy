package mdrt.m16_pangrams

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["A quick brown fox jumps over the lazy dog" , "NULL"],
                ["A slow yellow fox crawls under the proactive dog", "bjkmqz"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
