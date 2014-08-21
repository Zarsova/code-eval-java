package easy.e16_rightmost_char

import spock.lang.Specification

class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main(['input/easy/e16_rightmost_char.txt'] as String[])

        then:
        1 * ps.println('8')

        then:
        1 * ps.println('10')

        then:
        1 * ps.println('-1')

        cleanup:
        System.out = savedSystemOut
    }
}
