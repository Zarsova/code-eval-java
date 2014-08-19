package e09_fibonacci_series

import spock.lang.Specification

class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main(["input/e09_fibonacci_series.txt"] as String[])

        then:
        1 * ps.println("5")

        then:
        1 * ps.println("144")

        cleanup:
        System.out = savedSystemOut
    }
}
