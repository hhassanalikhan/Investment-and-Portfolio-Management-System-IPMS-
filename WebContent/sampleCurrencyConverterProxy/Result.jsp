<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCurrencyConverterProxyid" scope="session" class="com.web.services.CurrencyConverterProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCurrencyConverterProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCurrencyConverterProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCurrencyConverterProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.web.services.CurrencyConverter getCurrencyConverter10mtemp = sampleCurrencyConverterProxyid.getCurrencyConverter();
if(getCurrencyConverter10mtemp == null){
%>
<%=getCurrencyConverter10mtemp %>
<%
}else{
        if(getCurrencyConverter10mtemp!= null){
        String tempreturnp11 = getCurrencyConverter10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String baseCurrencyCode_1id=  request.getParameter("baseCurrencyCode24");
            java.lang.String baseCurrencyCode_1idTemp = null;
        if(!baseCurrencyCode_1id.equals("")){
         baseCurrencyCode_1idTemp  = baseCurrencyCode_1id;
        }
        String conversionCurrenyCode_2id=  request.getParameter("conversionCurrenyCode26");
            java.lang.String conversionCurrenyCode_2idTemp = null;
        if(!conversionCurrenyCode_2id.equals("")){
         conversionCurrenyCode_2idTemp  = conversionCurrenyCode_2id;
        }
        com.web.services.CurrencyConversionData getRate13mtemp = sampleCurrencyConverterProxyid.getRate(baseCurrencyCode_1idTemp,conversionCurrenyCode_2idTemp);
if(getRate13mtemp == null){
%>
<%=getRate13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">currencyConversionError:</TD>
<TD>
<%
if(getRate13mtemp != null){
%>
<%=getRate13mtemp.isCurrencyConversionError()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">baseCurrencyCode:</TD>
<TD>
<%
if(getRate13mtemp != null){
java.lang.String typebaseCurrencyCode18 = getRate13mtemp.getBaseCurrencyCode();
        String tempResultbaseCurrencyCode18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebaseCurrencyCode18));
        %>
        <%= tempResultbaseCurrencyCode18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">conversionCurrenyCode:</TD>
<TD>
<%
if(getRate13mtemp != null){
java.lang.String typeconversionCurrenyCode20 = getRate13mtemp.getConversionCurrenyCode();
        String tempResultconversionCurrenyCode20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeconversionCurrenyCode20));
        %>
        <%= tempResultconversionCurrenyCode20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">rate:</TD>
<TD>
<%
if(getRate13mtemp != null){
%>
<%=getRate13mtemp.getRate()
%><%}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>