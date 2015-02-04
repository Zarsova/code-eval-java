package mdrt.m07_remove_characters

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
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
