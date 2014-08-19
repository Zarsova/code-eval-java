package e10_multiplication_tables

import spock.lang.Specification

class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main()

        then:
        1 * ps.println('1   2   3   4   5   6   7   8   9  10  11  12')

        then:
        1 * ps.println('2   4   6   8  10  12  14  16  18  20  22  24')

        then:
        1 * ps.println('3   6   9  12  15  18  21  24  27  30  33  36')

        cleanup:
        System.out = savedSystemOut
    }
}
