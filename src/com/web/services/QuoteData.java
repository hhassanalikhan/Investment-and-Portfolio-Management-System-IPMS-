/**
 * QuoteData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.web.services;

public class QuoteData  implements java.io.Serializable {
    private java.lang.String stockSymbol;

    private double lastTradeAmount;

    private java.lang.String lastTradeDateTime;

    private double stockChange;

    private double openAmount;

    private double dayHigh;

    private double dayLow;

    private int stockVolume;

    private int prevCls;

    private double changePercent;

    private java.lang.String fiftyTwoWeekRange;

    private double earnPerShare;

    private double PE;

    private java.lang.String companyName;

    private boolean quoteError;

    public QuoteData() {
    }

    public QuoteData(
           java.lang.String stockSymbol,
           double lastTradeAmount,
           java.lang.String lastTradeDateTime,
           double stockChange,
           double openAmount,
           double dayHigh,
           double dayLow,
           int stockVolume,
           int prevCls,
           double changePercent,
           java.lang.String fiftyTwoWeekRange,
           double earnPerShare,
           double PE,
           java.lang.String companyName,
           boolean quoteError) {
           this.stockSymbol = stockSymbol;
           this.lastTradeAmount = lastTradeAmount;
           this.lastTradeDateTime = lastTradeDateTime;
           this.stockChange = stockChange;
           this.openAmount = openAmount;
           this.dayHigh = dayHigh;
           this.dayLow = dayLow;
           this.stockVolume = stockVolume;
           this.prevCls = prevCls;
           this.changePercent = changePercent;
           this.fiftyTwoWeekRange = fiftyTwoWeekRange;
           this.earnPerShare = earnPerShare;
           this.PE = PE;
           this.companyName = companyName;
           this.quoteError = quoteError;
    }


    /**
     * Gets the stockSymbol value for this QuoteData.
     * 
     * @return stockSymbol
     */
    public java.lang.String getStockSymbol() {
        return stockSymbol;
    }


    /**
     * Sets the stockSymbol value for this QuoteData.
     * 
     * @param stockSymbol
     */
    public void setStockSymbol(java.lang.String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }


    /**
     * Gets the lastTradeAmount value for this QuoteData.
     * 
     * @return lastTradeAmount
     */
    public double getLastTradeAmount() {
        return lastTradeAmount;
    }


    /**
     * Sets the lastTradeAmount value for this QuoteData.
     * 
     * @param lastTradeAmount
     */
    public void setLastTradeAmount(double lastTradeAmount) {
        this.lastTradeAmount = lastTradeAmount;
    }


    /**
     * Gets the lastTradeDateTime value for this QuoteData.
     * 
     * @return lastTradeDateTime
     */
    public java.lang.String getLastTradeDateTime() {
        return lastTradeDateTime;
    }


    /**
     * Sets the lastTradeDateTime value for this QuoteData.
     * 
     * @param lastTradeDateTime
     */
    public void setLastTradeDateTime(java.lang.String lastTradeDateTime) {
        this.lastTradeDateTime = lastTradeDateTime;
    }


    /**
     * Gets the stockChange value for this QuoteData.
     * 
     * @return stockChange
     */
    public double getStockChange() {
        return stockChange;
    }


    /**
     * Sets the stockChange value for this QuoteData.
     * 
     * @param stockChange
     */
    public void setStockChange(double stockChange) {
        this.stockChange = stockChange;
    }


    /**
     * Gets the openAmount value for this QuoteData.
     * 
     * @return openAmount
     */
    public double getOpenAmount() {
        return openAmount;
    }


    /**
     * Sets the openAmount value for this QuoteData.
     * 
     * @param openAmount
     */
    public void setOpenAmount(double openAmount) {
        this.openAmount = openAmount;
    }


    /**
     * Gets the dayHigh value for this QuoteData.
     * 
     * @return dayHigh
     */
    public double getDayHigh() {
        return dayHigh;
    }


    /**
     * Sets the dayHigh value for this QuoteData.
     * 
     * @param dayHigh
     */
    public void setDayHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    }


    /**
     * Gets the dayLow value for this QuoteData.
     * 
     * @return dayLow
     */
    public double getDayLow() {
        return dayLow;
    }


    /**
     * Sets the dayLow value for this QuoteData.
     * 
     * @param dayLow
     */
    public void setDayLow(double dayLow) {
        this.dayLow = dayLow;
    }


    /**
     * Gets the stockVolume value for this QuoteData.
     * 
     * @return stockVolume
     */
    public int getStockVolume() {
        return stockVolume;
    }


    /**
     * Sets the stockVolume value for this QuoteData.
     * 
     * @param stockVolume
     */
    public void setStockVolume(int stockVolume) {
        this.stockVolume = stockVolume;
    }


    /**
     * Gets the prevCls value for this QuoteData.
     * 
     * @return prevCls
     */
    public int getPrevCls() {
        return prevCls;
    }


    /**
     * Sets the prevCls value for this QuoteData.
     * 
     * @param prevCls
     */
    public void setPrevCls(int prevCls) {
        this.prevCls = prevCls;
    }


    /**
     * Gets the changePercent value for this QuoteData.
     * 
     * @return changePercent
     */
    public double getChangePercent() {
        return changePercent;
    }


    /**
     * Sets the changePercent value for this QuoteData.
     * 
     * @param changePercent
     */
    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }


    /**
     * Gets the fiftyTwoWeekRange value for this QuoteData.
     * 
     * @return fiftyTwoWeekRange
     */
    public java.lang.String getFiftyTwoWeekRange() {
        return fiftyTwoWeekRange;
    }


    /**
     * Sets the fiftyTwoWeekRange value for this QuoteData.
     * 
     * @param fiftyTwoWeekRange
     */
    public void setFiftyTwoWeekRange(java.lang.String fiftyTwoWeekRange) {
        this.fiftyTwoWeekRange = fiftyTwoWeekRange;
    }


    /**
     * Gets the earnPerShare value for this QuoteData.
     * 
     * @return earnPerShare
     */
    public double getEarnPerShare() {
        return earnPerShare;
    }


    /**
     * Sets the earnPerShare value for this QuoteData.
     * 
     * @param earnPerShare
     */
    public void setEarnPerShare(double earnPerShare) {
        this.earnPerShare = earnPerShare;
    }


    /**
     * Gets the PE value for this QuoteData.
     * 
     * @return PE
     */
    public double getPE() {
        return PE;
    }


    /**
     * Sets the PE value for this QuoteData.
     * 
     * @param PE
     */
    public void setPE(double PE) {
        this.PE = PE;
    }


    /**
     * Gets the companyName value for this QuoteData.
     * 
     * @return companyName
     */
    public java.lang.String getCompanyName() {
        return companyName;
    }


    /**
     * Sets the companyName value for this QuoteData.
     * 
     * @param companyName
     */
    public void setCompanyName(java.lang.String companyName) {
        this.companyName = companyName;
    }


    /**
     * Gets the quoteError value for this QuoteData.
     * 
     * @return quoteError
     */
    public boolean isQuoteError() {
        return quoteError;
    }


    /**
     * Sets the quoteError value for this QuoteData.
     * 
     * @param quoteError
     */
    public void setQuoteError(boolean quoteError) {
        this.quoteError = quoteError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QuoteData)) return false;
        QuoteData other = (QuoteData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.stockSymbol==null && other.getStockSymbol()==null) || 
             (this.stockSymbol!=null &&
              this.stockSymbol.equals(other.getStockSymbol()))) &&
            this.lastTradeAmount == other.getLastTradeAmount() &&
            ((this.lastTradeDateTime==null && other.getLastTradeDateTime()==null) || 
             (this.lastTradeDateTime!=null &&
              this.lastTradeDateTime.equals(other.getLastTradeDateTime()))) &&
            this.stockChange == other.getStockChange() &&
            this.openAmount == other.getOpenAmount() &&
            this.dayHigh == other.getDayHigh() &&
            this.dayLow == other.getDayLow() &&
            this.stockVolume == other.getStockVolume() &&
            this.prevCls == other.getPrevCls() &&
            this.changePercent == other.getChangePercent() &&
            ((this.fiftyTwoWeekRange==null && other.getFiftyTwoWeekRange()==null) || 
             (this.fiftyTwoWeekRange!=null &&
              this.fiftyTwoWeekRange.equals(other.getFiftyTwoWeekRange()))) &&
            this.earnPerShare == other.getEarnPerShare() &&
            this.PE == other.getPE() &&
            ((this.companyName==null && other.getCompanyName()==null) || 
             (this.companyName!=null &&
              this.companyName.equals(other.getCompanyName()))) &&
            this.quoteError == other.isQuoteError();
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
        if (getStockSymbol() != null) {
            _hashCode += getStockSymbol().hashCode();
        }
        _hashCode += new Double(getLastTradeAmount()).hashCode();
        if (getLastTradeDateTime() != null) {
            _hashCode += getLastTradeDateTime().hashCode();
        }
        _hashCode += new Double(getStockChange()).hashCode();
        _hashCode += new Double(getOpenAmount()).hashCode();
        _hashCode += new Double(getDayHigh()).hashCode();
        _hashCode += new Double(getDayLow()).hashCode();
        _hashCode += getStockVolume();
        _hashCode += getPrevCls();
        _hashCode += new Double(getChangePercent()).hashCode();
        if (getFiftyTwoWeekRange() != null) {
            _hashCode += getFiftyTwoWeekRange().hashCode();
        }
        _hashCode += new Double(getEarnPerShare()).hashCode();
        _hashCode += new Double(getPE()).hashCode();
        if (getCompanyName() != null) {
            _hashCode += getCompanyName().hashCode();
        }
        _hashCode += (isQuoteError() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QuoteData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://services.web.com", "QuoteData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockSymbol");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "StockSymbol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastTradeAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "LastTradeAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastTradeDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "LastTradeDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockChange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "StockChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "OpenAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayHigh");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "DayHigh"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayLow");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "DayLow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stockVolume");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "StockVolume"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prevCls");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "PrevCls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changePercent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "ChangePercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fiftyTwoWeekRange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "FiftyTwoWeekRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("earnPerShare");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "EarnPerShare"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "PE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "CompanyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quoteError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://services.web.com", "QuoteError"));
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
