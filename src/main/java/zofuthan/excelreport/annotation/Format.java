package zofuthan.excelreport.annotation;

import zofuthan.excelreport.utils.FormatType;

public @interface Format {

	FormatType FormatType();

	String FormatString();

}
