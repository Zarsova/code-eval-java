package easy.e11_sum_of_integers_from_file

import spock.lang.Specification

class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main(['input/easy/e11_sum_of_integers_from_file.txt'] as String[])

        then:
        1 * ps.println('17')

        cleanup:
        System.out = savedSystemOut
    }
}
