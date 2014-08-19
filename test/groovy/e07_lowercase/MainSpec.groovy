package e07_lowercase

import spock.lang.Specification

class MainSpec extends Specification {
    def "should return correct test outputs given test input"() {
        given:
        def savedSystemOut = System.out
        def ps = Mock(PrintStream)
        System.out = ps

        when:
        Main.main(["input/e07_lowercase.txt"] as String[])

        then:
        1 * ps.println("hello codeeval")

        then:
        1 * ps.println("this is some text")

        cleanup:
        System.out = savedSystemOut
    }
}
