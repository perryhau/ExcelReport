package zofuthan.excelreport.validation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zofuthan.excelreport.exception.InvalidException;
import zofuthan.excelreport.exception.UnInitRuleException;
import zofuthan.excelreport.validation.AnnotationValidation;
import zofuthan.excelreport.validation.Validation;


public class NoInitValidationTest {

	private Validation validation = null;

	@BeforeMethod
	public void beforeMethod() {
		validation = new AnnotationValidation();
	}

	@Test
	public void getColumns() {
		Assert.assertEquals(validation.getColumns().size(), 0);
	}

	@Test(expectedExceptions = UnInitRuleException.class)
	public void verify() throws InvalidException, UnInitRuleException {
		validation.verify("name", 1);
	}
}
