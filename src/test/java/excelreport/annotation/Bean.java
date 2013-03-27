package excelreport.annotation;

import excelreport.annotation.Column;
import excelreport.annotation.Format;
import excelreport.annotation.Restrict;
import excelreport.annotation.RuleType;
import excelreport.annotation.Table;
import excelreport.utils.FormatType;

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
