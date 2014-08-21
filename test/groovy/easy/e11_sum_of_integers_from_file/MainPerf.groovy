package easy.e11_sum_of_integers_from_file

class MainPerf {
    static main(args) {
        profile {
            100.times {
                Main.main(['input/easy/e11_sum_of_integers_from_file.txt'] as String[])
            }
        }.prettyPrint()
    }
}
