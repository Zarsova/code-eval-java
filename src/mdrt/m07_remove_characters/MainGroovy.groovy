package mdrt.m07_remove_characters

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        /*
        CodeEvalRunner.run([
                ["how are you, abc", "how re you"],
                ["hello world, def", "hllo worl"]
        ], Main)
*/

        CodeEvalRunner.run([
                "how are you, abc",
                "hello world, def"
        ], Main, [
                "how re you",
                "hllo worl"
        ])
    }
}
