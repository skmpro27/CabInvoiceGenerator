package com.invoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTimeReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.totalFare(2.0, 5);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.totalFare(0.1, 2);
        Assert.assertEquals(5, fare, 0.0);
    }
}
