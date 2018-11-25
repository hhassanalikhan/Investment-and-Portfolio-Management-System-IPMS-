/**
 * StockQuote.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.web.services;

public interface StockQuote extends java.rmi.Remote {
    public com.web.services.QuoteData getQuote(java.lang.String stockSymbol) throws java.rmi.RemoteException;
}
