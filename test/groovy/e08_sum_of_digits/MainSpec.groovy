package e08_sum_of_digits

import spock.lang.Specification

class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main(["input/e08_sum_of_digits.txt"] as String[])

        then:
        1 * ps.println("5")

        then:
        1 * ps.println("19")

        cleanup:
        System.out = savedSystemOut
    }
}
