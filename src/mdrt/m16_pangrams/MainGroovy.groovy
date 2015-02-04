package mdrt.m16_pangrams

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["A quick brown fox jumps over the lazy dog", "NULL"],
                ["A slow yellow fox crawls under the proactive dog", "bjkmqz"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
