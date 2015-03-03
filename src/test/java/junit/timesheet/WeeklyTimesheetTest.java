package junit.timesheet;
import timesheet.WeeklyTimesheet;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeeklyTimesheetTest {

	@Test
	public void test() {
		WeeklyTimesheet timesheet = new WeeklyTimesheet(10, 10);
		assertEquals(20, timesheet.getTotalHours(), 0.001);
		assertEquals(200, timesheet.calculatePay(10), 0.001);
	}

}
