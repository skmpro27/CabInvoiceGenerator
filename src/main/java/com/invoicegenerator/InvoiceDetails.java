package com.invoicegenerator;

public class InvoiceDetails {
    private final int numberOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceDetails(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDetails details = (InvoiceDetails) o;
        return numberOfRides == details.numberOfRides &&
                Double.compare(details.totalFare, totalFare) == 0 &&
                Double.compare(details.averageFare, averageFare) == 0;
    }
}
