package Phase2;


import java.rmi.RemoteException;

import com.web.services.CurrencyConversionData;
import com.web.services.CurrencyConverter;
import com.web.services.CurrencyConverterProxy;

public class ThirdPartServices implements CurrencyConverter{

	
	String conertCrrency(String baseCurrencyCode, String conversionCurrenyCode)
	{
		double res = 0;
		try {
			CurrencyConversionData cd = getRate( baseCurrencyCode,conversionCurrenyCode);
			res = cd.getRate();
		} catch (RemoteException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ""+res;
	}

	public CurrencyConversionData getRate(String baseCurrencyCode, String conversionCurrenyCode) throws RemoteException {
		CurrencyConverterProxy pr = new CurrencyConverterProxy();
		CurrencyConversionData cd = pr.getRate(baseCurrencyCode, conversionCurrenyCode);
		return cd;
	}
}
