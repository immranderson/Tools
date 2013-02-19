package com.futaba.tools;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.futaba.tools.FileOpener;




public class CV{   //CV stands for "Cell Value"



    //    public static String Read(Workbook wb, int sheet, int row, int column) throws Exception{
    //
    //	try {
    //	    return Double.toString(ReadDouble(wb,sheet,row,column));
    //	}
    //	catch (Exception e)
    //	    {
    //		return ReadString(wb,sheet,row,column);
    //	    }
    //
    //    }

    public static String MasterRead(Workbook wb, int sheet, int row, int column)
	{

	Sheet sheetRead = wb.getSheetAt(sheet);
	String str = null;
	Cell cell = wb.getSheetAt(sheet).getRow(row).getCell(column);
	int cellType = cell.getCellType();
	
	
try
    {
	if (cellType==Cell.CELL_TYPE_STRING)
	    {
		str = cell.toString().trim();
	    }
	else if (cellType==Cell.CELL_TYPE_NUMERIC)
	    {
		if (DateUtil.isCellDateFormatted(cell))
		    {

		    }
		else
		    {
			str = String.valueOf(cell.getNumericCellValue());
		    }
	    }
	else if (cellType==Cell.CELL_TYPE_BLANK)
	    {
		str = "";
	    }
	else if (cellType==Cell.CELL_TYPE_ERROR)
	    {
		str = "";
	    }
	else if (cellType==Cell.CELL_TYPE_BOOLEAN)
	    {
		str = String.valueOf(cell.getBooleanCellValue());
	    }
	return str;
    }
	catch (Exception e)
	    {
		e.printStackTrace();
		str = "0";
		return str;
	    }

    }

    public static String Read(Workbook wb, int sheet, int row, int column) throws Exception{

	Sheet sheetRead = wb.getSheetAt(sheet);

	try 
	    {
		Row rowRead = sheetRead.getRow(row);
		Cell cellRead = rowRead.getCell(column, Row.CREATE_NULL_AS_BLANK);
		cellRead.setCellType(Cell.CELL_TYPE_STRING);
		String cellReadValue = cellRead.getRichStringCellValue().getString();
		return cellReadValue;	
	    }

	catch (NullPointerException E)
	    {
		return " ";
	    }
	//	if (rowRead == null)
	//	    rowRead = sheetRead.createRow(row);




	//System.out.println(cellRead.getCellType());

    }


    public static double ReadDouble(Workbook wb, int sheet, int row, int column){

	double cellReadValue = 0.0;

	Sheet sheetRead = wb.getSheetAt(sheet);
	Row rowRead = sheetRead.getRow(row);
	//	if (rowRead == null)
	//	    rowRead = sheetRead.createRow(row);


	Cell cellRead = rowRead.getCell(column, Row.CREATE_NULL_AS_BLANK);
	cellRead.setCellType(Cell.CELL_TYPE_NUMERIC);


	cellReadValue = cellRead.getNumericCellValue();

	//	if (cellReadValue == 361.0) // why 361?!!??!?!?!?!?
	//	    cellReadValue=0;

	return cellReadValue;



    }





    //	public static String Read(HSSFWorkbook wb, int sheet, int row, int column) throws IOException{
    //
    //		HSSFSheet sheetRead = wb.getSheetAt(sheet);
    //		HSSFRow rowRead = sheetRead.getRow(row);
    //		if (rowRead == null)
    //			rowRead = sheetRead.createRow(row);
    //		HSSFCell cellRead = rowRead.getCell(column, Row.CREATE_NULL_AS_BLANK);
    //
    //		cellRead.setCellType(Cell.CELL_TYPE_STRING);
    //
    //		//System.out.println(cellRead.getCellType());
    //
    //		String cellReadValue = cellRead.getRichStringCellValue().getString();
    //
    //		return cellReadValue;	
    //
    //	}

    public static void Write(String cellWriteValue, Workbook wb, int sheet, int row, int column) throws IOException{


	Sheet sheetWrite = wb.getSheetAt(sheet);
	Row rowWrite = sheetWrite.getRow(row);
	if (rowWrite == null)
	    rowWrite = sheetWrite.createRow(row);
	Cell cellWrite = rowWrite.createCell(column);
	cellWrite.setCellValue(cellWriteValue);

    }

    public static void Write(double cellWriteValue, Workbook wb, int sheet, int row, int column) throws IOException{


	Sheet sheetWrite = wb.getSheetAt(sheet);
	Row rowWrite = sheetWrite.getRow(row);
	if (rowWrite == null)
	    rowWrite = sheetWrite.createRow(row);
	Cell cellWrite = rowWrite.createCell(column);
	cellWrite.setCellValue(cellWriteValue);

    }



    public static void QuickWrite(String filename, String cellWriteValue, Workbook wb, int sheet, int row, int column) throws Exception{



	InputStream fileRead = new FileInputStream(filename);
	wb = WorkbookFactory.create(fileRead);

	Sheet sheetWrite = wb.getSheetAt(sheet);

	Row rowWrite = sheetWrite.getRow(row);
	if (rowWrite == null)
	    rowWrite = sheetWrite.createRow(row);
	Cell cellWrite = rowWrite.createCell(column);
	cellWrite.setCellValue(cellWriteValue);

	FileOutputStream fileSave = new FileOutputStream(filename);
	wb.write(fileSave);

    }


    public static Cell Search(String SearchValue, Workbook wb, int sheet) throws IOException
    {

	Sheet sheet1 = wb.getSheetAt(sheet);

	boolean found_check = false;

	for (Row row : sheet1) {
	    for (Cell cell : row) {
		CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:

		    if (cell.getRichStringCellValue().getString().equals(SearchValue))
			{
			    System.out.println(SearchValue + " found at "+ cellRef.formatAsString());
			    found_check = true;

			    return cell;
			}
		    break;


		    //				case Cell.CELL_TYPE_NUMERIC:
		    //					if (DateUtil.isCellDateFormatted(cell)) {
		    //						System.out.println(cell.getDateCellValue());
		    //					} else {
		    //						System.out.println(cell.getNumericCellValue());
		    //					}
		    //					break;
		    //
		    //
		    //				case Cell.CELL_TYPE_BOOLEAN:
		    //					System.out.println(cell.getBooleanCellValue());
		    //					break;
		    //
		    //
		    //				case Cell.CELL_TYPE_FORMULA:
		    //					System.out.println(cell.getCellFormula());
		    //					break;
		    //
		    //
		    //				default:
		    //					System.out.println();
		}
	    }
	}
	if (found_check == false)
	    {
		System.out.println(SearchValue + " Not found");
	    }
	return null;
    }


    public static Cell Search(double SearchValue, Workbook wb, int sheet) throws IOException
    {		

	boolean found_check = false;

	Sheet sheet1 = wb.getSheetAt(sheet);
	for (Row row : sheet1) {
	    for (Cell cell : row) {
		CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:

		    if (cell.getRichStringCellValue().getString().equals(SearchValue))
			{
			    System.out.println("found at "+ cellRef.formatAsString());
			    found_check = true;
			    return cell;
			}
		    break;

		case Cell.CELL_TYPE_NUMERIC:


		    if (DateUtil.isCellDateFormatted(cell)) {
			if (cell.getDateCellValue().equals(SearchValue))
			    {
				System.out.println(cell.getDateCellValue());
				System.out.println("found at "+ cellRef.formatAsString());
				found_check = true;
				return cell;
			    }

		    } else {
			if (cell.getNumericCellValue()==(SearchValue))
			    {
				System.out.println(cell.getNumericCellValue());
				System.out.println("found at "+ cellRef.formatAsString());
				found_check = true;
				return cell;
			    }
		    }
		    break;


		    //				case Cell.CELL_TYPE_BOOLEAN:
		    //					System.out.println(cell.getBooleanCellValue());
		    //					break;
		    //
		    //
		    //				case Cell.CELL_TYPE_FORMULA:
		    //					System.out.println(cell.getCellFormula());
		    //					break;
		    //
		    //
		    //				default:
		    //					System.out.println();
		}
	    }
	}

	if (found_check == false)
	    System.out.println("Not found");
	return null;
    }






    public static ArrayList<Cell> SearchAll(String SearchValue, Workbook wb, int sheet) throws IOException
    {	
	ArrayList<Cell> cellarray = new ArrayList<Cell>();
	Sheet sheet1 = wb.getSheetAt(sheet);
	for (Row row : sheet1) {
	    for (Cell cell : row) {
		CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:

		    if (cell.getRichStringCellValue().getString().equals(SearchValue))
			{
			    System.out.println("found at "+ cellRef.formatAsString());
			    cellarray.add(cell);
			}
		}
	    }
	}
	return cellarray;
    }



    public static ArrayList<Cell> SearchAll(double SearchValue, Workbook wb, int sheet) throws IOException
    {
	ArrayList<Cell> cellarray = new ArrayList<Cell>();
	Sheet sheet1 = wb.getSheetAt(sheet);
	for (Row row : sheet1) {
	    for (Cell cell : row) {
		CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:

		    if (cell.getRichStringCellValue().getString().equals(SearchValue))
			{
			    System.out.println("found at "+ cellRef.formatAsString());
			    cellarray.add(cell);
			}

		case Cell.CELL_TYPE_NUMERIC:


		    if (DateUtil.isCellDateFormatted(cell)) {
			if (cell.getDateCellValue().equals(SearchValue))
			    {
				System.out.println(cell.getDateCellValue());
				System.out.println("found at "+ cellRef.formatAsString());
				cellarray.add(cell);
			    }

		    } else {
			if (cell.getNumericCellValue()==(SearchValue))
			    {
				System.out.println(cell.getNumericCellValue());
				System.out.println("found at "+ cellRef.formatAsString());
				cellarray.add(cell);
			    }
		    }



		    //				case Cell.CELL_TYPE_BOOLEAN:
		    //					System.out.println(cell.getBooleanCellValue());
		    //					break;
		    //
		    //
		    //				case Cell.CELL_TYPE_FORMULA:
		    //					System.out.println(cell.getCellFormula());
		    //					break;
		    //
		    //
		    //				default:
		    //					System.out.println();
		}
	    }
	}
	return cellarray;
    }




    public static void main(String[] args) throws Exception 
    {
	FileOpener fileRead = new FileOpener();

	InputStream fileread = new FileInputStream(fileRead.getName());
	Workbook wbRead = WorkbookFactory.create(fileread);




    }
}




