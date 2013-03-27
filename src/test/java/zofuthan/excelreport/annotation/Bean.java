package zofuthan.excelreport.annotation;

import zofuthan.excelreport.annotation.Column;
import zofuthan.excelreport.annotation.Format;
import zofuthan.excelreport.annotation.Restrict;
import zofuthan.excelreport.annotation.RuleType;
import zofuthan.excelreport.annotation.Table;
import zofuthan.excelreport.utils.FormatType;

@Table(Name = "DM_BA", HasRow = true)
public class Bean {

	@Restrict(Type = RuleType.String, Length = 8, Nullable = true)
	@Format(FormatType = FormatType.Date, FormatString = "##.##")
	@Column(Name = "Name", Cell = "A5", Comment = "姓名")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
