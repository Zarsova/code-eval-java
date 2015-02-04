package mdrt.m20_prime_numbers

import util.CodeEvalRunner


class MainGroovy {
    static main(argv) {
        def inputs = [
                //"9\n13\n15\n19\n21\n"
                //"7\n11\n13\n17\n19\n"
                "8\n12\n14\n18\n20\n"
        ]
        CodeEvalRunner.run(inputs, Main, ["", "", ""])
    }
}
