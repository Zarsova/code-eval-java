package mdrt.m19_reverse_and_add

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
        def inputs = [
                ["195", "4 9339"],
                ["1439", "a"],
                ["8819", "a"],
                ["4103", "a"],
                ["1552", "a"],
                ["8275", "a"],
                ["9871", "a"],
                ["4843", "a"],
                ["609", "a"],
                ["8758", "a"],
                ["2017", "a"],
                ["3386", "a"],
                ["4420", "a"],
                ["8579", "a"],
                ["1027", "a"],
                ["102", "a"],
                ["5234", "a"],
                ["8054", "a"],
                ["3071", "a"],
                ["4276", "a"],
                ["2595", "a"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
