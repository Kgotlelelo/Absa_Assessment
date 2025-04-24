package dataReader;

import java.io.IOException;

public class DataFunction {
    //Define instance variables
    static ExcelReader data = new ExcelReader();
    public static  String Username;
    public static  String Password;



    //Get the Excel data and Assign to the correct variable
    public static void dataFunction(String sheetName,int rowNum) throws IOException {
        data.initializeWorkbook("Data/BookStore.xlsx");
        Username = data.getCellData(sheetName,"UserName",rowNum);
        Password = data.getCellData(sheetName,"Password",rowNum);


    }
}
