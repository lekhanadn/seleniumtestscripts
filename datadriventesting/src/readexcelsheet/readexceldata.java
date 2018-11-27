package readexcelsheet;

import excellibrary.exceldataconfig;

public class readexceldata {

	public static void main(String[] args) throws Exception {
		
		exceldataconfig excel=new exceldataconfig("E:\\eclipse workspace\\datadriventesting\\excelsheet\\testdata.xlsx");
		
        System.out.println(excel.getdata(1,0,1));
        
        
      
	}

}
