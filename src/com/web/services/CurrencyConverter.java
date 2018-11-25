/**
 * CurrencyConverter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.web.services;

public interface CurrencyConverter extends java.rmi.Remote {
    public com.web.services.CurrencyConversionData getRate(java.lang.String baseCurrencyCode, java.lang.String conversionCurrenyCode) throws java.rmi.RemoteException;
}
