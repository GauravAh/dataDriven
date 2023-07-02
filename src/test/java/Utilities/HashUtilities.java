package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashUtilities {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	String Filepath;
	XSSFRow xsffrows;
	XSSFCell xsffcells;
	int rows;
	int cellss;
	
	public HashUtilities(String filePath){
		this.Filepath = filePath;
	}
	

	public int getRows(String sheetname) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(Filepath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetname);
		rows= sheet.getLastRowNum();
		return rows;
	}
	
	public int getCells(String sheetname, int rownum) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(Filepath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetname);
		xsffrows = sheet.getRow(rownum);
		cellss = xsffrows.getLastCellNum();
		return cellss;
	}
	
	public String getData(String sheetname, int rownum, int cellnum) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(Filepath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetname);
		xsffrows = sheet.getRow(rownum);
		xsffcells = xsffrows.getCell(cellnum);
		String data;
		DataFormatter formatter = new DataFormatter();
		try {
		data = formatter.formatCellValue(xsffcells);
		}catch(Exception e) {
			data ="";
		}
		return data;
	}
	
	
/*	public Map<String, String> readHash() throws Exception {
		
		String filePath = System.getProperty("user.dir") + "\\Reports\\DataFilesExcel.xlsx";
		FileInputStream fileInputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet("EmpInfo");
		int rows = sheet.getLastRowNum();
		Map<String, String> hashfForget = new HashMap<String, String>();
		DataFormatter formatter = new DataFormatter();
		for(int i=0;i<=rows;i++) {
			String kkey = formatter.formatCellValue(sheet.getRow(i).getCell(0));
			String kval = formatter.formatCellValue(sheet.getRow(i).getCell(1));
			hashfForget.put(kkey, kval);
		}
		return hashfForget;
		
	} */	

}
