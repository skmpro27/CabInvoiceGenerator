package com.invoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator;
    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTimeReturnTotalFare() {
        double fare = invoiceGenerator.totalFare(2.0, 5, RideType.NORMAL);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeReturnMinimumFare() {
        double fare = invoiceGenerator.totalFare(0.1, 2, RideType.NORMAL);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleDistanceAndTimeReturnInvoiceDetails() {
        List<Ride> rides = Arrays.asList(new Ride(2.0, 5, RideType.NORMAL), new Ride(0.1, 2, RideType.NORMAL));
        InvoiceDetails details = invoiceGenerator.totalFareList(rides);
        InvoiceDetails expectedDetails = new InvoiceDetails(2,30);
        Assert.assertEquals(expectedDetails, details);
    }

    @Test
    public void givenUserIDReturnInvoiceDetails() {
        //adding list of rides
        List<Ride> ride1 = Arrays.asList(new Ride(2.0, 5, RideType.NORMAL), new Ride(0.1, 2, RideType.NORMAL));
        List<Ride> ride2 = Arrays.asList(new Ride(3.0, 5, RideType.NORMAL), new Ride(0.2, 4, RideType.NORMAL));
        //adding user and there rides
        invoiceGenerator.addRepository("1", ride1);
        invoiceGenerator.addRepository("2", ride2);
        //to check for userId = "1"
        InvoiceDetails details = invoiceGenerator.enterUserId("1");
        InvoiceDetails expectedDetails = new InvoiceDetails(2,30);
        Assert.assertEquals(expectedDetails, details);
    }

    @Test
    public void givenUserTypeReturnInvoiceDetails() {
        //adding list of rides
        List<Ride> ride1 = Arrays.asList(new Ride(2.0, 5, RideType.NORMAL), new Ride(0.1, 2, RideType.PREMIUM));
        List<Ride> ride2 = Arrays.asList(new Ride(3.0, 5, RideType.PREMIUM), new Ride(0.2, 4, RideType.NORMAL));
        //adding user and there rides
        invoiceGenerator.addRepository("1", ride1);
        invoiceGenerator.addRepository("2", ride2);
        //to check for userId = "1" and calculating Premium and Normal rides fare
        InvoiceDetails details = invoiceGenerator.enterUserId("1");
        InvoiceDetails expectedDetails = new InvoiceDetails(2,45);
        Assert.assertEquals(expectedDetails, details);
    }
}
