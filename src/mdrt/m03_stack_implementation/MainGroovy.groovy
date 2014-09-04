package mdrt.m03_stack_implementation

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.run(["input/mdrt/m02_detecting_cycles.txt"] as String[], Main)
        CodeEvalRunner.run(["1 2 3 4",
                            "10 -2 3 4"
        ] as String[], Main, true)
    }
}
