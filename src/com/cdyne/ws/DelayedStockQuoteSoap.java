/**
 * DelayedStockQuoteSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cdyne.ws;

public interface DelayedStockQuoteSoap extends java.rmi.Remote {

    /**
     * This method retrieves a current stock quote.  Use a license
     * key of 0 for testing.
     */
    public com.cdyne.ws.QuoteData getQuote(java.lang.String stockSymbol, java.lang.String licenseKey) throws java.rmi.RemoteException;

    /**
     * This method retrieves just a stock price.  Use a license key
     * of 0 for testing.
     */
    public java.math.BigDecimal getQuickQuote(java.lang.String stockSymbol, java.lang.String licenseKey) throws java.rmi.RemoteException;

    /**
     * This method retrieves the stock information and returns it
     * in a dataset.  Use a , to diplay multiple quotes.  Use a license key
     * of 0 for testing.
     */
    public com.cdyne.ws.GetQuoteDataSetResponseGetQuoteDataSetResult getQuoteDataSet(java.lang.String stockSymbols, java.lang.String licenseKey) throws java.rmi.RemoteException;
}
