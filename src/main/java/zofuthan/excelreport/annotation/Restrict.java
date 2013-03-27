package zofuthan.excelreport.annotation;

public @interface Restrict {

	RuleType Type();

	int Length();

	boolean Nullable();

}
