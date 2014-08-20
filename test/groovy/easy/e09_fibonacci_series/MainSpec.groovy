package easy.e09_fibonacci_series

import spock.lang.Specification

class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main(["input/easy.e09_fibonacci_series.txt"] as String[])

        then:
        1 * ps.println("5")

        then:
        1 * ps.println("144")

        cleanup:
        System.out = savedSystemOut
    }

    def "check peformance"() {
        given:
        def loop =  100000
        def printErr = System.err.&println
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        def start = System.currentTimeMillis()
        (1..100000).each {
            Main.main(["input/easy.e09_fibonacci_series.txt"] as String[])
        }
        def duration = System.currentTimeMillis() - start
        printErr("${loop} time: ${duration} msec (${duration * 1.0 / loop} msec)")

        then:
        true

        cleanup:
        System.out = savedSystemOut
    }
}
