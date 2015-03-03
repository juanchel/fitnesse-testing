package fit.date;

import fit.ColumnFixture;
import date.Date;

public class DateCheck extends ColumnFixture {
	public int day;
	public int month;
	public int year;
	
	public int nextDay() throws Exception {
		Date myDate = new Date(day, month, year);
		return myDate.nextDate().getDay();
	}
	
	public int nextMonth() throws Exception {
		Date myDate = new Date(day, month, year);
		return myDate.nextDate().getMonth();
	}
	
	public int nextYear() throws Exception {
		Date myDate = new Date(day, month, year);
		return myDate.nextDate().getYear();
	}
	
	public boolean isLeapYear() throws Exception {
		Date myDate = new Date(day, month, year);
		return myDate.isLeapYear();
	}
}
