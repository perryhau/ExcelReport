package excelreport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import excelreport.VolidationExcel;
import excelreport.exception.InvalidException;
import excelreport.exception.UnInitRuleException;



public class VolidationExcelTest {

	Sheet dataSheet = null;
	Sheet templateSheet = null;

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {
		Workbook dataWB = new HSSFWorkbook(new FileInputStream(new File(
				"src/test/java/1d.xls")));
		dataSheet = dataWB.getSheetAt(0);
		Workbook templateWB = new HSSFWorkbook(new FileInputStream(new File(
				"src/test/java/1.xls")));
		templateSheet = templateWB.getSheetAt(0);
	}

	@Test(expectedExceptions = { InvalidException.class,
			UnInitRuleException.class })
	public void verifySheet() throws InvalidException, UnInitRuleException {
		VolidationExcel excel = new VolidationExcel();
		excel.verifySheet(dataSheet, templateSheet);
	}
}
