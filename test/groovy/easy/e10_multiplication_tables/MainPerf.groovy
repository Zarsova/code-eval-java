package easy.e10_multiplication_tables

class MainPerf {
    static main(args) {
        profile {
            100.times {
                Main.main()
            }
        }.prettyPrint()
    }
}
