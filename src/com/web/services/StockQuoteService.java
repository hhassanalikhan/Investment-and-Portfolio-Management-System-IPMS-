/**
 * StockQuoteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.web.services;

public interface StockQuoteService extends javax.xml.rpc.Service {
    public java.lang.String getStockQuoteAddress();

    public com.web.services.StockQuote getStockQuote() throws javax.xml.rpc.ServiceException;

    public com.web.services.StockQuote getStockQuote(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
