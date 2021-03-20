package com.invoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator;
    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTimeReturnTotalFare() {
        double fare = invoiceGenerator.totalFare(2.0, 5);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeReturnMinimumFare() {
        double fare = invoiceGenerator.totalFare(0.1, 2);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleDistanceAndTimeReturnInvoiceDetails() {
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 2)};
        InvoiceDetails details = invoiceGenerator.totalFare(rides);
        InvoiceDetails expectedDetails = new InvoiceDetails(2,30);
        Assert.assertEquals(expectedDetails, details);
    }
}
