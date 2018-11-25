package com.cdyne.ws;

public class DelayedStockQuoteSoapProxy implements com.cdyne.ws.DelayedStockQuoteSoap {
  private String _endpoint = null;
  private com.cdyne.ws.DelayedStockQuoteSoap delayedStockQuoteSoap = null;
  
  public DelayedStockQuoteSoapProxy() {
    _initDelayedStockQuoteSoapProxy();
  }
  
  public DelayedStockQuoteSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initDelayedStockQuoteSoapProxy();
  }
  
  private void _initDelayedStockQuoteSoapProxy() {
    try {
      delayedStockQuoteSoap = (new com.cdyne.ws.DelayedStockQuoteLocator()).getDelayedStockQuoteSoap();
      if (delayedStockQuoteSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)delayedStockQuoteSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)delayedStockQuoteSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (delayedStockQuoteSoap != null)
      ((javax.xml.rpc.Stub)delayedStockQuoteSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cdyne.ws.DelayedStockQuoteSoap getDelayedStockQuoteSoap() {
    if (delayedStockQuoteSoap == null)
      _initDelayedStockQuoteSoapProxy();
    return delayedStockQuoteSoap;
  }
  
  public com.cdyne.ws.QuoteData getQuote(java.lang.String stockSymbol, java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (delayedStockQuoteSoap == null)
      _initDelayedStockQuoteSoapProxy();
    return delayedStockQuoteSoap.getQuote(stockSymbol, licenseKey);
  }
  
  public java.math.BigDecimal getQuickQuote(java.lang.String stockSymbol, java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (delayedStockQuoteSoap == null)
      _initDelayedStockQuoteSoapProxy();
    return delayedStockQuoteSoap.getQuickQuote(stockSymbol, licenseKey);
  }
  
  public com.cdyne.ws.GetQuoteDataSetResponseGetQuoteDataSetResult getQuoteDataSet(java.lang.String stockSymbols, java.lang.String licenseKey) throws java.rmi.RemoteException{
    if (delayedStockQuoteSoap == null)
      _initDelayedStockQuoteSoapProxy();
    return delayedStockQuoteSoap.getQuoteDataSet(stockSymbols, licenseKey);
  }
  
  
}