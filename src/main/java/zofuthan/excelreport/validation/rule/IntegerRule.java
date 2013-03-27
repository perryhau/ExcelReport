package zofuthan.excelreport.validation.rule;

import zofuthan.excelreport.exception.InvalidException;

public class IntegerRule implements ValidationRule {

	public void test(Object value) throws InvalidException {
		this.test(value, "数据应该为整数");
	}

	public void test(Object value, String errMessage) throws InvalidException {
		try {
			if (!value.toString().matches("^-?[0-9]+$")) {
				throw new InvalidException(errMessage);
			} else {
				Integer.parseInt(value.toString());
			}
		} catch (Exception e) {
			throw new InvalidException(errMessage);
		}
	}
}
