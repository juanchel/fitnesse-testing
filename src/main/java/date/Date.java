package date;

public class Date {
	private int month, day, year;
	
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	
	private boolean isValid() {
		if (month <= 0 || month > 12)
			return false;
		int monthMax = 0;
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			monthMax = 31;
			break;
		case 2:
			try {
				monthMax = (isLeapYear() ? 29 : 28);
			} catch (Exception e) {
			}
			break;
		default:
			monthMax = 30;
		}
		if (day <= 0 || day > monthMax)
			return false;
		if (year < 1900 || year > 2200)
			return false;
		return true;
	}
	
	public Date (int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	public Date nextDate() throws Exception {
		if (!isValid()) {
			throw new Exception();
		}
		int monthMax;
		int nextDay = day;
		int nextMonth = month;
		int nextYear = year;
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			monthMax = 31;
			break;
		case 2:
			monthMax = (isLeapYear() ? 29 : 28);
			break;
		default:
			monthMax = 30;
		}
		nextDay++;
		if (nextDay > monthMax) {
			nextDay = 1;
			nextMonth++;
		}
		if (nextMonth > 12) {
			nextMonth = 1;
			nextYear++;
		}
		if (nextYear > 2200) {
			nextYear = 1900;
		}
		return new Date(nextDay, nextMonth, nextYear);
	}
	
	public boolean isLeapYear() throws Exception {
		if (year % 4 == 0 && year != 2000)
			return true;
		else
			return false;
	}
}
