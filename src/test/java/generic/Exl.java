package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exl 
{
	public String path;
	public String sheet;
	public int r;
	public int c;
	public void getExcelData(String path,String sheet,int r, int c) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		String v="";
	try {
		Workbook b= WorkbookFactory.create(new FileInputStream(path));
		v=b.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
