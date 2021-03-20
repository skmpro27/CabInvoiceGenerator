package com.invoicegenerator;

public class InvoiceGenerator {
    private static final int RATE_PER_MINUTE = 1;
    private static final double RATE_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;

    public double totalFare(double distance, int time) {
        double totalFare = distance * RATE_PER_KILOMETER + time * RATE_PER_MINUTE;;
        if (totalFare > MINIMUM_FARE)
            return totalFare;
        return MINIMUM_FARE;
    }
}
