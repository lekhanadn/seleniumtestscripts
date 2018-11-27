package excellibrary;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldataconfig {
	
	public XSSFWorkbook Workbook;
	XSSFSheet sheet1;
	

	public exceldataconfig(String excelpath) throws Exception
	{
		File src=new File(excelpath);
        FileInputStream fis=new FileInputStream(src);
      
		XSSFWorkbook Workbook = new XSSFWorkbook(fis);
        
	}
	
	
	public String getdata(int sheetnumber,int row,int column) throws Exception
	{
		XSSFSheet sheet1=Workbook.getSheetAt(sheetnumber);
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		 
		return data;
	
	}
}
