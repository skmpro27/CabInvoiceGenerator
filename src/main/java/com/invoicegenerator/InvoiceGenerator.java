package com.invoicegenerator;

public class InvoiceGenerator {
    private static final int RATE_PER_MINUTE = 1;
    private static final double RATE_PER_KILOMETER = 10;

    public double totalFare(double distance, int time) {
        return distance * RATE_PER_KILOMETER + time * RATE_PER_MINUTE;
    }
}
