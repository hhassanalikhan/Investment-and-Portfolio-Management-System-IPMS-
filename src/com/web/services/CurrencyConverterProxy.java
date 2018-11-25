package com.web.services;

public class CurrencyConverterProxy implements com.web.services.CurrencyConverter {
  private String _endpoint = null;
  private com.web.services.CurrencyConverter currencyConverter = null;
  
  public CurrencyConverterProxy() {
    _initCurrencyConverterProxy();
  }
  
  public CurrencyConverterProxy(String endpoint) {
    _endpoint = endpoint;
    _initCurrencyConverterProxy();
  }
  
  private void _initCurrencyConverterProxy() {
    try {
      currencyConverter = (new com.web.services.CurrencyConverterServiceLocator()).getCurrencyConverter();
      if (currencyConverter != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)currencyConverter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)currencyConverter)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (currencyConverter != null)
      ((javax.xml.rpc.Stub)currencyConverter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.web.services.CurrencyConverter getCurrencyConverter() {
    if (currencyConverter == null)
      _initCurrencyConverterProxy();
    return currencyConverter;
  }
  
  public com.web.services.CurrencyConversionData getRate(java.lang.String baseCurrencyCode, java.lang.String conversionCurrenyCode) throws java.rmi.RemoteException{
    if (currencyConverter == null)
      _initCurrencyConverterProxy();
    return currencyConverter.getRate(baseCurrencyCode, conversionCurrenyCode);
  }
  
  
}