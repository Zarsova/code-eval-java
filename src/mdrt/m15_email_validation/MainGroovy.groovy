package mdrt.m15_email_validation

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["foo@bar.com", "true"],
                ["this is not an email id", "false"],
                ["admin#codeeval.com", "false"],
                // ["admin@codeeval..com", "false"],
                // ["admin@codeeval.com.", "false"],
                // ["ad<min@codeeval.com.", "false"],
                // ["ad(min@codeeval.com.", "false"],
                // ["\"admin\"@codeeval.com", "true"],
                // ["\"admin\\\"@codeeval.com", "true"],
                ["good123@bad.com", "true"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
