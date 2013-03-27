package excelreport;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import excelreport.exception.InvalidException;
import excelreport.exception.UnInitRuleException;
import excelreport.utils.ExcelUtils;
import excelreport.validation.ExcelValidation;
import excelreport.validation.Validation;



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
