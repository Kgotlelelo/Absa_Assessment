package dataReader;

import java.io.IOException;

public class DataFunction {
    //Define instance variables
    static ExcelReader data = new ExcelReader();

    public static  String Browser;
    public static  String Url;



    //Get the Excel data and Assign to the correct variable
    public static void dataFunction(String sheetName,int rowNum) throws IOException {
        data.initializeWorkbook("Data/data.xlsx");
        Browser = data.getCellData(sheetName,"browser",rowNum);
        Url = data.getCellData(sheetName,"url",rowNum);



    }
}
