package mdrt.m21_cash_register

import util.CodeEvalRunner

/**
 * Created by develop on 2014/09/02.
 */
class MainGroovy {
    static main(argv) {
        //CodeEvalRunner.runAndPerf(["input/mdrt/m06_first_non_repeated_character.txt"] as String[], Main)
        def inputs = [
                ["15.94;16.00", "NICKEL,PENNY"],
                ["17;16", "ERROR"],
                ["35;35", "ZERO"],
                ["45;50", "FIVE"],
                ["41;50", "FIVE"],
                ["100;100", "hoge"],
                ["30.15;30.15", "hoge"],
                ["398.50;400.25", "hoge"],
                ["173;173", "hoge"],
                ["142.06;217.67", "hoge"],
                ["311.02;429.02", "hoge"],
                ["349;268", "hoge"],
                ["38.57;38.57", "hoge"],
                ["63.00;89.00", "hoge"],
                ["362;473.94", "hoge"],
                ["196.37;115.37", "hoge"],
                ["15.94;16.00", "hoge"],
                ["296.17;297", "hoge"],
                ["329.08;329.08", "hoge"],
                ["63;89.35", "hoge"],
                ["63.00;89.35", "hoge"],
                ["127.36;127.36", "hoge"],
                ["57.41;77.59", "hoge"],
                ["139.28;139.28", "hoge"],
                ["142;221.30", "hoge"]
        ]
        CodeEvalRunner.run(inputs, Main)
    }
}
