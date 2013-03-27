package zofuthan.excelreport.validation.rule;

import zofuthan.excelreport.exception.InvalidException;

public class NotNullRule implements ValidationRule {

	public void test(Object value, String errMessage) throws InvalidException {
		if (null == value || value.toString().matches("")) {
			throw new InvalidException(errMessage);
		}
	}

	public void test(Object value) throws InvalidException {
		test(value, "不能为空值！");
	}

}
