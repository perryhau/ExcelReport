package zofuthan.excelreport;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import zofuthan.excelreport.exception.InvalidException;
import zofuthan.excelreport.exception.UnInitRuleException;
import zofuthan.excelreport.utils.ExcelUtils;
import zofuthan.excelreport.validation.ExcelValidation;
import zofuthan.excelreport.validation.Validation;


public class VolidationExcel {

	public void verifyWorkBook(Workbook workbook) throws InvalidException,
			UnInitRuleException {
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (!workbook.getSheetAt(i).getSheetName().equals("DataTemplate")) {
				Sheet dataSheet = workbook.getSheetAt(i);
				Sheet templateSheet = ExcelUtils.getTmeplateSheet(dataSheet);
				this.verifySheet(dataSheet, templateSheet);
			} else {
				continue;
			}
		}
	}

	public void verifySheet(Sheet dataSheet, Sheet templateSheet)
			throws InvalidException, UnInitRuleException {
		Validation validation = new ExcelValidation();
		validation.prepareRule(templateSheet);
		for (String cell : validation.getColumns()) {
			CellReference reference = new CellReference(cell);
			validation.verify(cell, ExcelUtils.tryParseCell(dataSheet.getRow(
					reference.getRow()).getCell(reference.getCol())), "错误");
		}
	}
}
