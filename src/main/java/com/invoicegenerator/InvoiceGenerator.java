package com.invoicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceGenerator {
    private static final int RATE_PER_MINUTE = 1;
    private static final double RATE_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;
    List<RideRepository> rideRepository = new ArrayList<>();


    public double totalFare(double distance, int time) {
        double totalFare = distance * RATE_PER_KILOMETER + time * RATE_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceDetails totalFareList(List<Ride> rides) {
        double totalFare = rides.stream()
                .mapToDouble(ride -> totalFare(ride.distance, ride.time))
                .sum();

        return new InvoiceDetails(rides.size(), totalFare);
    }

    public InvoiceDetails enterUserId(String userId) {
        RideRepository rider = rideRepository.stream().filter(user -> user.userID.equals(userId)).findFirst().get();
        return totalFareList(rider.rideList);
    }

    public void addRepository(String userId, List<Ride> rides) {
        rideRepository.add(new RideRepository(userId, rides));
    }
}
