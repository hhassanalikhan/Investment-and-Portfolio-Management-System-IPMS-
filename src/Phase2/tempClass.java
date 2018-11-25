package Phase2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Phase2.Class3rdPartyServices;
public class tempClass {

	
	public String sellShares(String str) throws SQLException
	{
		String result = "";int x = 0;
		if(str.length() > 2)
		{
			List<String> items = new ArrayList<String>();
			List<String>  cats = new ArrayList<String>();
			
			String str1[]= str.split(",");
			for(int i =0;i<str1.length;)
			{
				items.add(str1[i]);
				i++;
				cats.add(str1[i]);	
				i++;
			}
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			for(int i1 =0; i1<cats.size();i1++)
			{
				int j = 0;
				float min = 1;
				String symbol = "";
				float sp = 1;
				String ta = aggregateAmountPerItemCategory1(items.get(i1), cats.get(i1));
				List<String>  symbols = new ArrayList<String>(); 
				Class3rdPartyServices cps = new Class3rdPartyServices();
				Statement myStmt;
				myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where Category = '"+cats.get(i1)+"'");
					//process results
				while(myRs.next())
					{
					String t1 = myRs.getString("TradingCurrency");
					float c = 1;
					if(!t1.equals("USD"))
					{
						String t2 = cps.converToFrom(t1,"USD");
						t2 = t2.replace("Result: ","");
						c = Float.parseFloat(t2);
					}
					if(j!=0)
					{
						if(c<min)
						{
							min = c;
							if(items.get(i1).equals("stock"))
								symbol = myRs.getString("StockSymbol");
							else
								symbol = myRs.getString("CommoditySymbol");
							
							String s = cps.getQuotePr(symbol);
							s = s.replace("Result: ","");
							sp = Float.parseFloat(s);
						}
					}
					
					else
					{
						min = c;
						if(items.get(i1).equals("stock"))
							symbol = myRs.getString("StockSymbol");
						else
							symbol = myRs.getString("CommoditySymbol");
						
						
						String s = cps.getQuotePr(symbol);
						s = s.replace("Result: ","");
						sp = Float.parseFloat(s);

					}
					
					j++;
						
				}
				
				min = min *sp;
				int ts = (int) (Float.parseFloat(ta)/min);
				result +=" "+ta+" "+ts+" "+min+" "+j+" "+symbol+",";
				updateSharePerEmployee(items.get(i1),cats.get(i1),symbol,(ts+""),ta,"sell");
				myRs.close();
					}
					
						
			
		}
			return result;
			
	}
	
	
	public String buyShares(String str)
	{
		String result = "";
		if(str.length() > 2)
		{
		List<String> items = new ArrayList<String>();
		List<String>  cats = new ArrayList<String>();
		
		String str1[]= str.split(",");
		for(int i =0;i<str1.length;)
		{
			items.add(str1[i]);
			i++;
			cats.add(str1[i]);	
			i++;
		}
		
		for(int i =0;i<cats.size();i++)
		{
			int j = 0;
			float min = 1;
			String symbol = "";
			float sp = 1;
			String ta = aggregateAmountPerItemCategory1(items.get(i), cats.get(i));
			List<String>  symbols = new ArrayList<String>(); 
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
				ResultSet myRs;
				Class3rdPartyServices cps = new Class3rdPartyServices();
				Statement myStmt = myConn.createStatement();
				if(items.get(i).equals("stock"))
					myRs = myStmt.executeQuery("SELECT * FROM demo.StockInfo where  Category ='"+cats.get(i)+"'");
				else
					myRs = myStmt.executeQuery("SELECT * FROM demo.CommodityInfo where  Category ='"+cats.get(i)+"'");

				while(myRs.next())
				{
					String t1 = myRs.getString("TradingCurrency");
					float c = 1;
					if(!t1.equals("USD"))
					{
						String t2 = cps.converToFrom(t1,"USD");
						t2 = t2.replace("Result: ","");
						c = Float.parseFloat(t2);
					}
					if(j!=0)
					{
						if(c<min)
						{
							min = c;
							if(items.get(i).equals("stock"))
								symbol = myRs.getString("StockSymbol");
							else
								symbol = myRs.getString("CommoditySymbol");
							
							String s = cps.getQuotePr(symbol);
							s = s.replace("Result: ","");
							sp = Float.parseFloat(s);
						}

					
					else
					{
						min = c;
						if(items.get(i).equals("stock"))
							symbol = myRs.getString("StockSymbol");
						else
							symbol = myRs.getString("CommoditySymbol");
						
						
						String s = cps.getQuotePr(symbol);
						s = s.replace("Result: ","");
						sp = Float.parseFloat(s);

					}
					
					j++;
						
				}
				
				min = min *sp;
				int ts = (int) (Float.parseFloat(ta)/min);
				result +=" "+ta+" "+ts+" "+min+" "+j+",";
				updateSharePerEmployee(items.get(i),cats.get(i),symbol,(ts+""),ta,"sell");
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//1 get connection

			//process results
				
		
			
		}
		}
		return result;
	}
	public String updateSharePerEmployee(String item,String cat,String symbol,String ts, String totalam,String ttype)
	{
		
		String result = "";
		Statement myStmt;
		try {
	
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.EmployeeInfo");
			//process results
				
			
			List<String> id = new ArrayList<String>();
			List<Float>  ps= new ArrayList<Float>();
			while(myRs.next())
			{
				id.add(myRs.getString("EmployeeId"));
				float x = (float) (( myRs.getInt("RetirementFundContributionPercentage")/100.0));
				ps.add(x);
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo where Item = '"+item+"' ");
			 float v = 0 ;
			 int c = 0;
				List<String> nid = new ArrayList<String>();
				List<Float>  nps= new ArrayList<Float>();
				List<Float>  stocks= new ArrayList<Float>();
				List<Float>  nst= new ArrayList<Float>();
				float add =2;
			while(myRs.next())
			{
				for(int i=0;i<id.size();i++ )
				{
					if(id.get(i).equals(myRs.getString("EmployeeId")))
					{
						nid.add(myRs.getString("EmployeeId"));
						float x = (float) (((myRs.getInt("PercentageContribution")/100.0)) * ps.get(i));
						nps.add(x);
						//int p = myRs.getInt("Profit");
						StockServices tps = new StockServices();
						
			
						//stocks.add((int)x);
						//myRs.updateInt( "Currentvalue", (int) x);
					
						//myRs.updateInt( "Currentvalue", (int) x);
						float nv = x/Float.parseFloat(totalam);
						
						
						int ns = -1*(int)(Integer.parseInt(ts));
						add =x* Float.parseFloat(totalam); //(int)(Float.parseFloat(ts) * nv);
						 
						if(ttype.equals("buy"))
	
						
						{
							add = -1 * add;
							ns = -1 * ns;
						}
						Random rn = new Random();
						//add = add/10000;
						stocks.add(add);
						ns = (int) (((float) ns) / 100);
						ns =    rn.nextInt(500) + 1;
						nst.add((float) ns);
						//add = add + p;
						//myRs.updateRow();
						
					}
				}
			}
			v = v/c;

			myRs.close();
			
			
			
			
			
			
			Statement stmt = myConn.createStatement();
	        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                   ResultSet.CONCUR_UPDATABLE);
	        ResultSet uprs = stmt.executeQuery("SELECT * FROM demo.AccountDetail ");
	        int f =0;
	    	while(uprs.next())
			{
				for(int i=0;i<nid.size();i++ )
				{
					if(nid.get(i).equals(uprs.getString("EmployeeId")) && uprs.getString("Item").equals("cash"))
					{
						add = uprs.getInt("Profit")+stocks.get(i);
			            uprs.updateInt( "Currentvalue", (int) (uprs.getInt("Currentvalue")+stocks.get(i)));
			            
			           // stocks.set(i, add);
			            uprs.updateRow();
						f=1;
					}
					else if(nid.get(i).equals(uprs.getString("EmployeeId")) && cat.equals(uprs.getString("Category"))  && item.equals(uprs.getString("Item")))
					{
						
			            uprs.updateInt( "Sharequantity", (int) (uprs.getInt("Sharequantity")+nst.get(i)));
			            
			           // stocks.set(i, add);
			            uprs.updateRow();
					}
				}
			}
	    	uprs.close();
	        stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	                   ResultSet.CONCUR_UPDATABLE);
		      uprs = stmt.executeQuery("SELECT * FROM demo.AccountSummary ");
		      int k =0;
		 	while(uprs.next())
				{
					for(int i=0;i<nid.size();i++ )
					{
						if(nid.get(i).equals(uprs.getString("EmployeeId")))
						{
					
				          uprs.updateInt( "CurrentBalance", (int) (uprs.getInt("CurrentBalance")+stocks.get(i)));
				            stocks.set(i, add);
				           uprs.updateRow();
							f=uprs.getInt("CurrentBalance");
							k = 8;
						}
					}
				}
 	uprs.close();
			result = "Agg. of"+item+" is :"+f;
		
	
			//result = "Agg. of";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return "done";
	}
	
	
	
	

	public String aggregateAmountPerItemCategory1(String item,String cat)
	{
		 float v = 0 ;
		String result = "";
		Statement myStmt;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			//1 get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "baboon");
		
			myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("SELECT * FROM demo.EmployeeInfo");
			//process results
				
			
			List<String> id = new ArrayList<String>();
			List<Float>  ps= new ArrayList<Float>();
			while(myRs.next())
			{
				id.add(myRs.getString("EmployeeId"));
				float x = (float) (myRs.getInt("Salary")*( myRs.getInt("RetirementFundContributionPercentage")/100.0));
				ps.add(x);
			}
			
			 myRs = myStmt.executeQuery("SELECT * FROM demo.PortfolioInfo where Item = '"+item+"' and Category ='"+cat+"'");
			  v = 0 ;
			 int c = 0;
			while(myRs.next())
			{
				for(int i=0;i<id.size();i++ )
				{
					if(id.get(i).equals(myRs.getString("EmployeeId")))
					{
						v+=((myRs.getInt("PercentageContribution")/100.0)) * ps.get(i);
						c++;
						i = id.size() + 2;
					}
				}
			}
			v = v/c;
			//result = "Agg. of"+item+" is :"+v;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return ""+v;
	}
}
