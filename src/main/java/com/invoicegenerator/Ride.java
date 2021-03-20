package com.invoicegenerator;

public class Ride {
    public RideType type;
    public int time;
    public double distance;

    public Ride(double distance, int time, RideType type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }
}
