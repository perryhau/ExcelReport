package excelreport.validation;

import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;

import excelreport.exception.InvalidException;
import excelreport.exception.UnInitRuleException;



public interface Validation {

	public void prepareRule(Class<?> clazz);

	public void prepareRule(Sheet sheet);

	public void verify(String target, Object value, String message)
			throws InvalidException, UnInitRuleException;

	public void verify(String target, Object value) throws InvalidException,
			UnInitRuleException;

	public Set<String> getColumns();

}
