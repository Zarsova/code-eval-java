package easy.e06_bit_positions

import spock.lang.Specification

class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main(["input/easy/e06_bit_positions.txt"] as String[])

        then:
        1 * ps.println("true")

        then:
        1 * ps.println("false")

        cleanup:
        System.out = savedSystemOut
    }
}
