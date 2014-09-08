package mdrt.m13_double_squares

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                "20",
                "437008825",
                "671961419",
                "219216030",
                "185676791",
                "29641625",
                "776448867",
                "773647993",
                "46791018",
                "72787279",
                "871932390",
                "814291666",
                "680758375",
                "249642863",
                "6856614",
                "331831330",
                "801125",
                "866950916",
                "300220305",
                "140804531",
                "575756527",
        ]
        CodeEvalRunner.run(inputs, Main, [
                "0",
                "0",
                "0",
                "32",
                "0",
                "2",
                "1",
                "0",
                "0",
                "0",
                "0",
                "0",
                "0",
                "4",
                "16",
                "4",
                "0",
                "0",
                "0"
        ])
    }
}
