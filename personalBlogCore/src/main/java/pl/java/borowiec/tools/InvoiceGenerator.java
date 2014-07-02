package pl.java.borowiec.tools;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.google.inject.internal.Lists;

import pl.java.borowiec.simple.Invoice;
import pl.java.borowiec.simple.InvoiceType;

public final class InvoiceGenerator {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private InvoiceGenerator() {
    }

    public static List<Invoice> generate() {
        List<Invoice> invoices = Lists.newArrayList();
        Invoice invoice = new Invoice();
        invoice.setAmount(new BigDecimal("99"));

        try {
            invoice.setCreataDate(sdf.parse("1999-10-01"));
        } catch (ParseException e) {
        }

        try {
            invoice.setPayDate(sdf.parse("2014-08-01"));
        } catch (ParseException e) {
        }

        invoice.setDescription("description.....");
        invoice.setPayed(true);
        invoice.setType(InvoiceType.BUSINESS);
        invoice.setUser("slawek borowiec");
        invoice.setName("computers");
        invoices.add(invoice);

        invoice = new Invoice();
        invoice.setAmount(new BigDecimal("992"));

        try {
            invoice.setCreataDate(sdf.parse("1999-10-01"));
        } catch (ParseException e) {
        }

        try {
            invoice.setPayDate(sdf.parse("2014-08-01"));
        } catch (ParseException e) {
        }

        invoice.setDescription("etst....");
        invoice.setPayed(true);
        invoice.setType(InvoiceType.CUSTOMER);
        invoice.setUser("mike tyson");
        invoice.setName("pens");
        invoices.add(invoice);

        invoice = new Invoice();
        invoice.setAmount(new BigDecimal("139"));

        try {
            invoice.setCreataDate(sdf.parse("2000-10-01"));
        } catch (ParseException e) {
        }

        try {
            invoice.setPayDate(sdf.parse("2014-12-01"));
        } catch (ParseException e) {
        }

        invoice.setDescription("hhhhh....");
        invoice.setPayed(true);
        invoice.setType(InvoiceType.CUSTOMER);
        invoice.setUser("andrzej golowa");
        invoice.setName("boxer");
        invoices.add(invoice);
        return invoices;
    }


    
}
