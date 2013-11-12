package com.wakaleo.calculator

import com.wakaleo.monitoring.services.HouseMonitoringService
import com.wakaleo.monitoring.services.SuburbService
import spock.lang.Specification
import spock.lang.Unroll

import static com.wakaleo.monitoring.model.Status.*

class WhenDeterminingSuburbStatus extends Specification {

    def houseMonitoringService = Mock(HouseMonitoringService)

    @Unroll
    def "overall status should return highest weight status for a set of status values"() {
        given:
            def suburbService = new SuburbService(houseMonitoringService)
        and:
            houseMonitoringService.reportStatusFor("Balmain") >> statusValues
        when:
            def overallStatus = suburbService.getOverallStatusFor("Balmain")
        then:
            overallStatus == expectedStatus
        where:
        statusValues                | expectedStatus
        [GREEN]                     | GREEN
        [GREEN, RED]                | RED
        [GREEN, ORANGE, RED]        | ORANGE
        [GREEN, GREEN, YELLOW]      | YELLOW
    }
}