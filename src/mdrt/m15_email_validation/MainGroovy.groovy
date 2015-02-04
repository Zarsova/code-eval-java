package mdrt.m15_email_validation

import util.CodeEvalRunner

class MainGroovy {
    static main(argv) {
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
