package readexcelsheet;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel1 {

	
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			File src=new File("E:\\eclipse workspace\\datadriventesting\\excelsheet\\testdata1.xlsx");
	        FileInputStream fis=new FileInputStream(src);
	        XSSFWorkbook Workbook = new XSSFWorkbook(fis);
	             XSSFSheet sheet1=Workbook.getSheetAt(0);
	     // String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
	      //String data1=sheet1.getRow(0).getCell(1).getStringCellValue();

	     // System.out.println(data0);

	      
	      int rowcount= sheet1.getLastRowNum();
	      System.out.println("total row count"+rowcount);
	      for(int i=0;i<=rowcount;i++)
	      {
	    	
	    	  String data1=  sheet1.getRow(i).getCell(0).getStringCellValue();
	    	  String data2=  sheet1.getRow(i).getCell(1).getStringCellValue();
	    	  System.out.println("data from row "+i+" is "+data1);
	    	  System.out.println("data from row "+i+" is "+data2);
	      }
	    
	      
	      Workbook.close();
	}

}
