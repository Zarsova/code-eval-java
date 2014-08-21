package easy.e14_unique_elements

class MainPerf {
    static main(args) {
        profile {
            100.times {
                Main.main(['input/easy/e14_unique_elements.txt'] as String[])
            }
        }.prettyPrint()
    }
}
