package zofuthan.excelreport.validation.rule;

import zofuthan.excelreport.exception.InvalidException;

public interface ValidationRule {

	public void test(Object value) throws InvalidException;

	public void test(Object value, String errMessage) throws InvalidException;
}
