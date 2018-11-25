package Phase2;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import com.cdyne.ws.DelayedStockQuoteSoap;
import com.cdyne.ws.DelayedStockQuoteSoapProxy;
import com.cdyne.ws.GetQuoteDataSetResponseGetQuoteDataSetResult;
import com.cdyne.ws.QuoteData;
import com.web.services.StockQuote;
import com.web.services.StockQuoteProxy;

import sun.security.util.BigInt;

public class StockServices implements DelayedStockQuoteSoap{


	public String stockQueryAm(String symbol)
	{
		int res = 0;
		try {
			QuoteData data  = getQuote(symbol,"0");
			res = data.getStockVolume();
		} catch (RemoteException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ""+res;
	}


	public String stockQueryPs(String symbol)
	{
		BigDecimal res = null ;
		try {
			QuoteData data  = getQuote(symbol,"0");
			res = data.getOpenAmount();
		} catch (RemoteException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ""+res;
	}
	

	@Override
	public com.cdyne.ws.QuoteData getQuote(String stockSymbol, String licenseKey) throws RemoteException {
		DelayedStockQuoteSoapProxy pr = new DelayedStockQuoteSoapProxy();
		QuoteData data = pr.getQuote(stockSymbol, "0");
	
		return data;
	}

	@Override
	public BigDecimal getQuickQuote(String stockSymbol, String licenseKey) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetQuoteDataSetResponseGetQuoteDataSetResult getQuoteDataSet(String stockSymbols, String licenseKey)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
