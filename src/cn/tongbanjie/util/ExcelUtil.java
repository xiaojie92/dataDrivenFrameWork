package cn.tongbanjie.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

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

	// 在Excel文件的执行单元格中写入数据，此函数只支持扩展名为.xlsx的Excel文件写入
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

	// 从Excel文件获取测试数据的静态方法
	public static Object[][] getTestData(String excelFilepath, String sheetName) throws IOException {
		// 根据参数传入的数据文件路径和文件名称，组合出Excel数据文件的绝对路径
		// 声明一个File文件对象
		File file = new File(excelFilepath);
		// 创建FileInputStream对象用于读取Excel文件
		FileInputStream inputStream = new FileInputStream(file);
		// 声明Workbook对象
		Workbook Workbook = null;
		// 获取文件名参数的扩展名，判断是.xlsx文件还是.xls文件
		String fileExtensionName = excelFilepath.substring(excelFilepath.indexOf("."));
		// 判断文件类型如果是.xlsx，则使用XSSFWorkbook对象进行实例化
		// 判断文件类型如果是.xls，则使用SSFWorkbook对象进行实例化
		if (fileExtensionName.equals(".xlsx")) {
			Workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			Workbook = new HSSFWorkbook(inputStream);
		}
		// 通过sheetName参数，生成sheet对象
		Sheet Sheet = Workbook.getSheet(sheetName);
		// 获取Excel数据文件sheet1中数据的行数，getLastRowNum方法获取数据的最后行号
		// getFirstRowNum方法获取数据的第一行行号，相减之后算出数据的行数
		// 注意：Excel文件的行号和列号都是从0开始的
		int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
		// 创建名为records的list对象来存储从Excel数据文件读取的数据
		List<Object[]> records = new ArrayList<Object[]>();
		// 使用两个for循环遍历Excel数据文件的所有数据（除了第一行，第一行是数据列名称）
		// 所以i从1开始，而不是从0开始
		for (int i = 1; i < rowCount + 1; i++) {
			// 使用getRow方法获取行对象
			Row row = Sheet.getRow(i);
			/*
			 * 声明一个数组，用来存储Excel数据文件每行中的测试用例和数据，数组的大小用
			 * getLastCellNum－2来进行动态声明，实现测试数据个数和数组大小相一致，因为Excel
			 * 数据文件中的测试数据行的最后一个单元格为测试执行结果，倒数第二个单元格为此测试数据行
			 * 是否运行的状态位，所以最后两列的单元格数据并不需要传入测试方法中，所以使用
			 * getLastCellNum－2的方式去掉每行中的最后两个单元格数据，计算出需要存储的测试数据
			 * 个数，并作为测试数据数组的初始化大小
			 */
			String fields[] = new String[row.getLastCellNum() - 2];
			/*
			 * if用于判断数据行是否要参与测试的执行，Excel文件的倒数第二列为数据行的状态位，
			 * 标记为“y”表示此数据行要被测试脚本执行，标记为非“y”的数据行均被认为不会参与测试 脚本的执行，会被跳过
			 */
			if (row.getCell(row.getLastCellNum() - 2).getStringCellValue().equals("y")) {
				for (int j = 0; j < row.getLastCellNum() - 2; j++) {
					// 判断Excel的单元格字段是数字还是字符，字符串格式调用getStringCellValue方法
					// 数字格式调用getNumericeCellValue方法获取
					fields[j] = (String) (row.getCell(j).getCellType() == XSSFCell.CELL_TYPE_STRING
							? row.getCell(j).getStringCellValue() : "" + row.getCell(j).getNumericCellValue());
				}
				// fields的数据对象存储到rexords的list中
				records.add(fields);
			}
		}
		// 定义函数返回值，即Object[][]
		// 将存储测试数据的list转换为一个Object的二维数组
		Object[][] result = new Object[records.size()][];
		// 设置二维数组每行的值，每行是一个Object对象
		for (int i = 0; i < records.size(); i++) {
			result[i] = records.get(i);
		}
		return result;
	}

	public static int getLastColumnNum() {
		// 返回数据文件最后一列的列号，如果有12列，则结果返回11
		return ExcelWsheet.getRow(0).getLastCellNum() - 1;
	}
}