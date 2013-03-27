package excelreport.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelUtils {

	public static String tryParseCell(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			return "";
		case Cell.CELL_TYPE_BOOLEAN:
			return Boolean.toString(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_ERROR:
			return "";
		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		case Cell.CELL_TYPE_NUMERIC:
			return Double.toString(cell.getNumericCellValue());
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		default:
			return "";
		}
	}

	public static Sheet getTmeplateSheet(Sheet dataSheet) {
		return null;
	}

}
