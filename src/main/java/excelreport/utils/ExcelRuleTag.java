package excelreport.utils;

import java.util.ArrayList;

import excelreport.validation.rule.DateRule;
import excelreport.validation.rule.IntegerRule;
import excelreport.validation.rule.LengthRule;
import excelreport.validation.rule.NotNullRule;
import excelreport.validation.rule.NumberRule;
import excelreport.validation.rule.ValidationRule;



public class ExcelRuleTag {

	public final static String NULLABLE = "^NOTNULL$";
	public final static String NUMBER = "^[#]+.[#]+$";
	public final static String INTEGER = "^[#]+$";
	public final static String NUMBER_LENGTH = "^[#]+.[0]+$";
	public final static String INTEGER_LENGTH = "^[0]+$";
	public final static String DATE = "^YYYY-MM-DD$";

	public static void parseRuleTag(ArrayList<ValidationRule> ruleList,
			String ruleString) {
		if (ruleString.matches(NULLABLE)) {
			ruleList.add(new NotNullRule());
		} else if (ruleString.matches(NUMBER)) {
			ruleList.add(new NumberRule());
		} else if (ruleString.matches(NUMBER_LENGTH)) {
			ruleList.add(new NumberRule());
			ruleList.add(new LengthRule(ruleString.substring(ruleString
					.indexOf(".") + 1)));
		} else if (ruleString.matches(INTEGER)) {
			ruleList.add(new IntegerRule());
		} else if (ruleString.matches(INTEGER_LENGTH)) {
			ruleList.add(new IntegerRule());
			ruleList.add(new LengthRule(ruleString.substring(ruleString
					.indexOf(".") + 1)));
		} else if (ruleString.matches(DATE)) {
			ruleList.add(new DateRule());
		}
	}
}
