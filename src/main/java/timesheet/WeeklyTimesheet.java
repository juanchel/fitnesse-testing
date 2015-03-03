package timesheet;

public class WeeklyTimesheet {
	private double standardHours = 0;
	private double holidayHours = 0; 

	public WeeklyTimesheet(double standardHours, double holidayHours) {
		this.holidayHours  = holidayHours;
		this.standardHours = standardHours;
	}

	public double calculatePay(double wage) {
		return wage*getTotalHours();
	}

	public double getTotalHours() {
		return standardHours + holidayHours;
	}
}
