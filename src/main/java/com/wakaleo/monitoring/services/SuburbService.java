package com.wakaleo.monitoring.services;

import com.wakaleo.monitoring.model.Status;

import static ch.lambdaj.Lambda.max;

import java.util.List;

/**
 * A description goes here.
 * User: john
 * Date: 12/11/2013
 * Time: 1:57 PM
 */
public class SuburbService {
    private final HouseMonitoringService houseMonitoringService;

    public SuburbService(HouseMonitoringService houseMonitoringService) {
        this.houseMonitoringService = houseMonitoringService;
    }

    public Status getOverallStatusFor(String suburb) {
        return max(houseMonitoringService.reportStatusFor(suburb));
    }
}
