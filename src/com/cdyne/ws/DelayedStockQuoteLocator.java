/**
 * DelayedStockQuoteLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cdyne.ws;

public class DelayedStockQuoteLocator extends org.apache.axis.client.Service implements com.cdyne.ws.DelayedStockQuote {

    public DelayedStockQuoteLocator() {
    }


    public DelayedStockQuoteLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DelayedStockQuoteLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DelayedStockQuoteSoap
    private java.lang.String DelayedStockQuoteSoap_address = "http://ws.cdyne.com/delayedstockquote/delayedstockquote.asmx";

    public java.lang.String getDelayedStockQuoteSoapAddress() {
        return DelayedStockQuoteSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DelayedStockQuoteSoapWSDDServiceName = "DelayedStockQuoteSoap";

    public java.lang.String getDelayedStockQuoteSoapWSDDServiceName() {
        return DelayedStockQuoteSoapWSDDServiceName;
    }

    public void setDelayedStockQuoteSoapWSDDServiceName(java.lang.String name) {
        DelayedStockQuoteSoapWSDDServiceName = name;
    }

    public com.cdyne.ws.DelayedStockQuoteSoap getDelayedStockQuoteSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DelayedStockQuoteSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDelayedStockQuoteSoap(endpoint);
    }

    public com.cdyne.ws.DelayedStockQuoteSoap getDelayedStockQuoteSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cdyne.ws.DelayedStockQuoteSoapStub _stub = new com.cdyne.ws.DelayedStockQuoteSoapStub(portAddress, this);
            _stub.setPortName(getDelayedStockQuoteSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDelayedStockQuoteSoapEndpointAddress(java.lang.String address) {
        DelayedStockQuoteSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cdyne.ws.DelayedStockQuoteSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cdyne.ws.DelayedStockQuoteSoapStub _stub = new com.cdyne.ws.DelayedStockQuoteSoapStub(new java.net.URL(DelayedStockQuoteSoap_address), this);
                _stub.setPortName(getDelayedStockQuoteSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DelayedStockQuoteSoap".equals(inputPortName)) {
            return getDelayedStockQuoteSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.cdyne.com/", "DelayedStockQuote");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.cdyne.com/", "DelayedStockQuoteSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DelayedStockQuoteSoap".equals(portName)) {
            setDelayedStockQuoteSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
