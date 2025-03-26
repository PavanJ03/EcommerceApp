package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.ecom.testbase.BaseClass;

public class DataProviders extends BaseClass{

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path= ".\\TestData\\Testdata.xlsx";    //+prop.getProperty("testDataXLFilePath");//taking excel file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("sheet1");	
		int totalcols=xlutil.getCellCount("sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from excel storing in two dimensional array
		{	
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimensional array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
