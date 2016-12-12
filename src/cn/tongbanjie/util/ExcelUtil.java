package cn.tongbanjie.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * 主要实现文件扩展名为.xlsx的Excel文件
 * 
 * @author sunaojie
 *
 */
public class ExcelUtil {
	private static XSSFSheet ExcelWsheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	// 设定要操作Excel的文件路径和Excel文件的sheet名称
	// 在读/写Excel的时候，均需要先调用此方法，设定要操作的Excel文件路径和要操作的sheet
	public static void setExcelFile(String Path, String sheetName) throws Exception {
		FileInputStream ExcelFile;
		try {
			// 实例化Excel文件的FileInputStream对象
			ExcelFile = new FileInputStream(Path);
			// 实例化Excel文件的XSSFWorkbook对象
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			/*
			 * 实例化XSSFSheet对象，指定Excel文件中的sheet名称，后续用于sheet中行、列和单元格的操作
			 */
			ExcelWsheet = ExcelWBook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	// 读取Excel文件指定单元格的
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			// 通过函数参数指定单元格的行号和列号，获取指定的单元格
			Cell = ExcelWsheet.getRow(RowNum).getCell(ColNum);
			/*
			 * 如果单元格的内容为字符串类型，则使用getStringCellValue方法获取单元格的内容
			 * 如果单元格的内容为数字类型，则使用getNumericCellValue()方法获取单元格的内容
			 * 注意getNumericCellValue方法返回值为double类型，转换字符串类型必须
			 * 在Cell.getNumericCellValue()前面增加“”，用于强制转换double类型到
			 * String类型，不加“”则会抛出double类型无法转换到String类型的异常
			 */
			String CellData = Cell.getCellType() == XSSFCell.CELL_TYPE_STRING ? Cell.getStringCellValue() + ""
					: String.valueOf(Math.round(Cell.getNumericCellValue()));
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	// 在Excel文件的执行单元格中写入数据
	@SuppressWarnings("static-access")
	public static void setCellData(int RowNum, int ColNum, String Result) throws Exception {
		try {
			// 获取Excel文件中的行和对象
			Row = ExcelWsheet.getRow(RowNum);
			// 如果单元格为空，则返回Null
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				// 当单元格对象是Null的时候，则创建单元格
				// 如果单元格为空，无法直接调用单元格对象的setCellValue方法设定单元格的值
				Cell = Row.createCell(ColNum);
				// 创建单元格后可以调用单元格对象的setCellvalue方法设定单元格的值
				Cell.setCellValue(Result);
			} else {
				// 单元格中有内容，则可以直接调用单元格对象的setCellvalue方法设定单元格的值
				Cell.setCellValue(Result);
			}
			// 实例化写入Excel文件的文件输出流对象
			FileOutputStream fileOut = new FileOutputStream(RaisePlanInfo.TestDataExcelFilePath);
			// 将内容写入Excel文件中
			ExcelWBook.write(fileOut);
			// 调用flushf方法强制刷新写入
			fileOut.flush();
			// 关闭文件输出流对象
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
}
