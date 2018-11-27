package readexcelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver","E:\\eclipse workspace\\demo\\driver\\geckodriver.exe");

		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
	}
	@DataProvider(name="Test")
	public Object[][] getData() throws Exception
	{
		
		
		File src=new File("E:\\eclipse workspace\\datadriventesting\\excelsheet\\testdata1.xlsx");
        FileInputStream fis=new FileInputStream(src);
         XSSFWorkbook Workbook = new XSSFWorkbook(fis);
         XSSFSheet sheet1=Workbook.getSheetAt(0);
         int rowcount= sheet1.getLastRowNum();
         Object [][]data=new Object[rowcount+1][2];
	     
         System.out.println("total row count"+rowcount);
	      for(int i=0;i<=rowcount;i++)
	      {
	    	 data[i][0]=sheet1.getRow(i).getCell(0).getStringCellValue();
	    	 data[i][1]=sheet1.getRow(i).getCell(1).getStringCellValue();
	    	   System.out.println(data[i][0]);
	    	   System.out.println(data[i][1]);
	    	  
	      }
		  Workbook.close();
		return data;
	   
	}

	@Test(dataProvider="Test")
	public void testFacebook(String url,String uname,String pwd)
	{
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys(uname);
		
		driver.findElement(By.id("pass")).sendKeys(pwd);
		driver.findElement(By.id("loginbutton")).click();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
