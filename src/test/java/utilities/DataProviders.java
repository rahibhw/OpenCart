package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException
	{
		String path = ".\\testdata\\Opencart_LoginData.xlsx";
		
		ExcelUtility xl = new ExcelUtility(path);
		
		int total_row= xl.getRowCount("Sheet1");
		int total_col= xl.getCellCount("Sheet1", 1);
		
		String loginData[][]= new String[total_row][total_col];
		
		for(int i=1; i<=total_row; i++)
		{
			for(int j=0; j<total_col; j++)
			{
				loginData[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;
		
	}
	

}
