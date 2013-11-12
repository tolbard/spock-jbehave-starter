package com.wakaleo.calculator.stories.jbehave;

import com.wakaleo.monitoring.model.Status;
import com.wakaleo.monitoring.services.HouseMonitoringService;
import com.wakaleo.monitoring.services.SuburbService;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A description goes here.
 * User: john
 * Date: 12/11/2013
 * Time: 1:45 PM
 */
public class MonitoringASuburbSteps {

    String suburb;
    SuburbService suburbService;
    HouseMonitoringService houseMonitoringService;

    @Given("we are monitoring the suburb of <suburb>")
    public void givenWeAreMonitoringTheSuburbOf(String suburb) {
        this.suburb = suburb;
    }

    @When("the houses report the status values of <house_status_values>")
    public void whenTheHousesReportTheStatusValuesOf(List<Status> house_status_values) {
        houseMonitoringService = mock(HouseMonitoringService.class);
        when(houseMonitoringService.reportStatusFor(suburb)).thenReturn(house_status_values);
        suburbService = new SuburbService(houseMonitoringService);
    }

    @Then("the overall value should be <suburb_status>")
    public void thenTheOverallValueShouldBe(@Named("suburb_status") Status expectedStatus) {
        Status calculatedStatus = suburbService.getOverallStatusFor(suburb);
        assertThat(calculatedStatus).isEqualTo(expectedStatus);
    }

}
