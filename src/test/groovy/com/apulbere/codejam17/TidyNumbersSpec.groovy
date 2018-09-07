package com.apulbere.codejam17

import spock.lang.Specification

class TidyNumbersSpec extends Specification {
    def tidyNumbers

    def setup() {
        tidyNumbers = new TidyNumbers()
    }

    def "it finds all tidy numbers"() {
        expect:
            tidyNumbers.solve(testCase) == result
        where:
            testCase                || result
            "441"                   || "399"
            "132"                   || "129"
            "1000"                  || "999"
            "7"                     || "7"
    }

    def "it finds tidy numbers"() {
        when:
            tidyNumbers.solve(getClass().getResource(inFilePath).path, outputFilePath)
        then:
            new File(outputFilePath).text == new File(getClass().getResource(expectedOutputFilePath).path).text
        where:
            inFilePath                          | outputFilePath                || expectedOutputFilePath
            "/tidy-numbers/B-small-practice.in" | "out/B-small-practice.out"    || "/tidy-numbers/B-small-practice.out"
            "/tidy-numbers/B-large-practice.in" | "out/B-large-practice.out"    || "/tidy-numbers/B-large-practice.out"
    }
}

