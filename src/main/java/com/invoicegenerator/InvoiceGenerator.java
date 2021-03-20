package com.invoicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceGenerator {
    private static int RATE_PER_MINUTE = 1;
    private static double RATE_PER_KILOMETER = 10;
    private static double MINIMUM_FARE = 5;

    List<RideRepository> rideRepository = new ArrayList<>();

    private void chooseRide(RideType type) {
        if (type == RideType.PREMIUM) {
            RATE_PER_KILOMETER = 15;
            RATE_PER_MINUTE = 2;
            MINIMUM_FARE = 20;
        } else {
            RATE_PER_KILOMETER = 10;
            RATE_PER_MINUTE = 1;
            MINIMUM_FARE = 5;
        }
    }

    public double totalFare(double distance, int time, RideType typeOfRide) {
        chooseRide(typeOfRide);
        double totalFare = distance * RATE_PER_KILOMETER + time * RATE_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceDetails totalFareList(List<Ride> rides) {
        double totalFare = rides.stream()
                .mapToDouble(ride -> totalFare(ride.distance, ride.time, ride.type))
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
