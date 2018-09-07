package com.apulbere.codejam17

import spock.lang.Specification

class PancakeFlipperSpec extends Specification {

    def pancakeFlipper

    def setup() {
        pancakeFlipper = new PancakeFlipper()
    }

    def "it solves the pancake flipper problem"() {
        expect:
            pancakeFlipper.solve(testCase) == result
        where:
            testCase        || result
            "---+-++- 3"    || "3"
            "+++++ 4"       || "0"
            "-+-+- 4"       || "IMPOSSIBLE"
    }

    def "it solves the pancake flipper problem for large file"() {
        given:
            def expectedOutputFilePath = getClass().getResource("/pancake-flipper/A-large-practice.out").path
            def outputFilePath = "out/A-large-practice.out"
        when:
            pancakeFlipper.solve(getClass().getResource("/pancake-flipper/A-large-practice.in").path, outputFilePath)
        then:
            new File(outputFilePath).text == new File(expectedOutputFilePath).text
    }
}
