package zofuthan.excelreport.validation;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

import zofuthan.excelreport.utils.ExcelRuleTag;
import zofuthan.excelreport.utils.ExcelUtils;
import zofuthan.excelreport.validation.rule.ValidationRule;


public class ExcelValidation extends AbstractValidation {

	@Override
	public void prepareRule(Class<?> clazz) {
	}

	@Override
	public void prepareRule(Sheet sheet) {
		for (int r = 0; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null)
				continue;
			for (int c = 0; c < row.getLastCellNum(); c++) {
				Cell cell = row.getCell(c);
				if (cell == null)
					continue;
				/** 获取单元格配置的校验规则 */
				ArrayList<ValidationRule> cellRules = getCellRule(ExcelUtils
						.tryParseCell(cell));

				if (cellRules.size() > 0) {
					super.rules.put(new CellReference(cell).formatAsString(),
							cellRules);
				}
			}
		}
	}

	private ArrayList<ValidationRule> getCellRule(String ruleString) {
		String[] ruleStrings = ruleString.split(";");
		ArrayList<ValidationRule> ruleList = new ArrayList<ValidationRule>();
		for (String s : ruleStrings) {
			ExcelRuleTag.parseRuleTag(ruleList, s);
		}
		return ruleList;
	}
}
