package fit.timesheet;

import fit.ColumnFixture;
import timesheet.WeeklyTimesheet;

public class WeeklyCompensation extends ColumnFixture{
	public double standardHours; 
	public double holidayHours;
	public double wage;

	
	public double pay() {
		WeeklyTimesheet timesheet = new WeeklyTimesheet(standardHours, holidayHours);
		return timesheet.calculatePay(wage);
	}
	
	public double totalHours() {
		WeeklyTimesheet timesheet = new WeeklyTimesheet(standardHours, holidayHours);
		return timesheet.getTotalHours();
	}
	
}
