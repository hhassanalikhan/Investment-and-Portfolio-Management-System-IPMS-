/**
 * CurrencyConversionData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.web.services;

public class CurrencyConversionData  implements java.io.Serializable {
    private java.lang.String baseCurrencyCode;

    private java.lang.String conversionCurrenyCode;

    private double rate;

    private boolean currencyConversionError;

    public CurrencyConversionData() {
    }

    public CurrencyConversionData(
           java.lang.String baseCurrencyCode,
           java.lang.String conversionCurrenyCode,
           double rate,
           boolean currencyConversionError) {
           this.baseCurrencyCode = baseCurrencyCode;
           this.conversionCurrenyCode = conversionCurrenyCode;
           this.rate = rate;
           this.currencyConversionError = currencyConversionError;
    }


    /**
     * Gets the baseCurrencyCode value for this CurrencyConversionData.
     * 
     * @return baseCurrencyCode
     */
    public java.lang.String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }


    /**
     * Sets the baseCurrencyCode value for this CurrencyConversionData.
     * 
     * @param baseCurrencyCode
     */
    public void setBaseCurrencyCode(java.lang.String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }


    /**
     * Gets the conversionCurrenyCode value for this CurrencyConversionData.
     * 
     * @return conversionCurrenyCode
     */
    public java.lang.String getConversionCurrenyCode() {
        return conversionCurrenyCode;
    }


    /**
     * Sets the conversionCurrenyCode value for this CurrencyConversionData.
     * 
     * @param conversionCurrenyCode
     */
    public void setConversionCurrenyCode(java.lang.String conversionCurrenyCode) {
        this.conversionCurrenyCode = conversionCurrenyCode;
    }


    /**
     * Gets the rate value for this CurrencyConversionData.
     * 
     * @return rate
     */
    public double getRate() {
        return rate;
    }


    /**
     * Sets the rate value for this CurrencyConversionData.
     * 
     * @param rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }


    /**
     * Gets the currencyConversionError value for this CurrencyConversionData.
     * 
     * @return currencyConversionError
     */
    public boolean isCurrencyConversionError() {
        return currencyConversionError;
    }


    /**
     * Sets the currencyConversionError value for this CurrencyConversionData.
     * 
     * @param currencyConversionError
     */
    public void setCurrencyConversionError(boolean currencyConversionError) {
        this.currencyConversionError = currencyConversionError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CurrencyConversionData)) return false;
        CurrencyConversionData other = (CurrencyConversionData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.baseCurrencyCode==null && other.getBaseCurrencyCode()==null) || 
             (this.baseCurrencyCode!=null &&
              this.baseCurrencyCode.equals(other.getBaseCurrencyCode()))) &&
            ((this.conversionCurrenyCode==null && other.getConversionCurrenyCode()==null) || 
             (this.conversionCurrenyCode!=null &&
              this.conversionCurrenyCode.equals(other.getConversionCurrenyCode()))) &&
            this.rate == other.getRate() &&
            this.currencyConversionError == other.isCurrencyConversionError();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getBaseCurrencyCode() != null) {
            _hashCode += getBaseCurrencyCode().hashCode();
        }
        if (getConversionCurrenyCode() != null) {
            _hashCode += getConversionCurrenyCode().hashCode();
        }
        _hashCode += new Double(getRate()).hashCode();
        _hashCode += (isCurrencyConversionError() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CurrencyConversionData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.web.com", "CurrencyConversionData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseCurrencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "BaseCurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conversionCurrenyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "ConversionCurrenyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "Rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyConversionError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "CurrencyConversionError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
