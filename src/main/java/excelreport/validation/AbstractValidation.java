package excelreport.validation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;

import excelreport.exception.InvalidException;
import excelreport.exception.UnInitRuleException;
import excelreport.validation.rule.ValidationRule;



public abstract class AbstractValidation implements Validation {

	private static final Logger logger = Logger
			.getLogger(AbstractValidation.class);

	protected Map<String, ArrayList<ValidationRule>> rules = new LinkedHashMap<String, ArrayList<ValidationRule>>();

	public abstract void prepareRule(Class<?> clazz);

	public abstract void prepareRule(Sheet sheet);

	public void verify(String target, Object value) throws InvalidException,
			UnInitRuleException {
		if (rules == null || rules.keySet() == null) {
			throw new UnInitRuleException("校验规则未初始化！");
		} else {
			if (rules.containsKey(target)) {
				for (ValidationRule rule : rules.get(target)) {
					logger.debug(target + "调用了"
							+ rule.getClass().getSimpleName() + "规则，实际值为："
							+ (value == null ? "Null" : value.toString()));
					rule.test(value);
				}
			} else {
				logger.warn(target + "没有相关的校验规则！");
			}
		}
	}

	public void verify(String target, Object value, String message)
			throws InvalidException, UnInitRuleException {
		if (rules == null || rules.keySet() == null) {
			throw new UnInitRuleException("校验规则未初始化！");
		} else {
			if (rules.containsKey(target)) {
				for (ValidationRule rule : rules.get(target)) {
					logger.debug(target + "调用了"
							+ rule.getClass().getSimpleName() + "规则，实际值为："
							+ (value == null ? "Null" : value.toString()));
					rule.test(value, message);
				}
			} else {
				logger.warn(target + "没有相关的校验规则！");
			}
		}
	}

	public Set<String> getColumns() {
		if (rules != null && rules.keySet() != null) {
			return rules.keySet();
		} else {
			logger.warn("规则列表为空，可能为事先未准备规则");
			return new LinkedHashSet<String>();
		}
	}
}
