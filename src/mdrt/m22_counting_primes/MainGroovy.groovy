package mdrt.m22_counting_primes

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                "2,10\n20,30"
        ]
        CodeEvalRunner.run(inputs, Main, ["4\n2"])
    }
}
