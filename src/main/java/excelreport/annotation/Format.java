package excelreport.annotation;

import excelreport.utils.FormatType;

public @interface Format {

	FormatType FormatType();

	String FormatString();

}
