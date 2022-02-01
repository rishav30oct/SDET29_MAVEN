package com.crm.GenericUtility_Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.result.Row;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author rishav ranjan
 *
 */

public class ExcelUtility {
	
	/**
	 * its used read the data from excel base don below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * its used to get the last used row number on specified sheet 
	 * @param sheetName
	 * @param rowNum
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheetName , int rowNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastRow = wb.getSheet(sheetName).getLastRowNum();
		return lastRow;
		
	}
	
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
		FileInputStream fis  = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		FileOutputStream fos= new FileOutputStream(IpathConstants.Excelpath);
		wb.write(fos);
		wb.close();
		
	}



}
