package com.web.services;

public class StockQuoteProxy implements com.web.services.StockQuote {
  private String _endpoint = null;
  private com.web.services.StockQuote stockQuote = null;
  
  public StockQuoteProxy() {
    _initStockQuoteProxy();
  }
  
  public StockQuoteProxy(String endpoint) {
    _endpoint = endpoint;
    _initStockQuoteProxy();
  }
  
  private void _initStockQuoteProxy() {
    try {
      stockQuote = (new com.web.services.StockQuoteServiceLocator()).getStockQuote();
      if (stockQuote != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)stockQuote)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)stockQuote)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (stockQuote != null)
      ((javax.xml.rpc.Stub)stockQuote)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.web.services.StockQuote getStockQuote() {
    if (stockQuote == null)
      _initStockQuoteProxy();
    return stockQuote;
  }
  
  public com.web.services.QuoteData getQuote(java.lang.String stockSymbol) throws java.rmi.RemoteException{
    if (stockQuote == null)
      _initStockQuoteProxy();
    return stockQuote.getQuote(stockSymbol);
  }
  
  
}