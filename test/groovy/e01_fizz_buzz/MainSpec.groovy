package e01_fizz_buzz

import spock.lang.Specification


class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main(["input/e01-fizz_buzz.txt"] as String[])

        then:
        1 * ps.println("1 2 F 4 B F 7 8 F B")

        then:
        1 * ps.println("1 F 3 F 5 F B F 9 F 11 F 13 FB 15")

        cleanup:
        System.out = savedSystemOut
    }
}
