package com.wakaleo.calculator

import spock.lang.Specification

class WhenCalculatingSums extends Specification {

    def "should calculate zero for an empty string"() {
        given:
            def values = ""
        when:
            double sum = 0.0 // TODO: Replace this code with a working API call
        then:
            sum == 0.0
    }
}