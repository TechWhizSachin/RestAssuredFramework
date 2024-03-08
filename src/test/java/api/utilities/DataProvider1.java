package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvider1 {
	String file="E:\\workspace\\RestAssuredFramework\\TestData\\Book1.xlsx";
	ExcelUtility eu=new ExcelUtility(file);
	
	@DataProvider(name="allData")
	public String[][] getAllData() throws IOException{
		
		int rowCount=eu.getRowCount("Sheet1");
		int cellCount=eu.getCellCount("Sheet1", 1);
		System.out.println("row count "+rowCount+" cell count "+cellCount);
		String[][] excelData=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				excelData[i-1][j]=eu.getCellData("Sheet1", i, j);
			}
		}
		return excelData;
	}
	
	@DataProvider(name="userNames")
	public String[] getUserNames() throws IOException {
		int rowCount=eu.getRowCount("Sheet1");
		System.out.println("row count in delete"+rowCount);
//		int cellCount=eu.getCellCount("Sheet1", 1);
		String[] excelData=new String[rowCount];
		for(int i=1;i<=rowCount;i++) {
			excelData[i-1]=eu.getCellData("Sheet1", i, 1);
		}
		return excelData;
	}
	
}
