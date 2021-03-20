package com.invoicegenerator;

import java.util.List;

public class RideRepository {
    String userID;
    List<Ride> rideList;

    public RideRepository(String userID, List<Ride> rideList) {
        this.userID = userID;
        this.rideList = rideList;
    }
}
