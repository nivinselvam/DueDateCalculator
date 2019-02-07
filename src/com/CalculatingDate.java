package com;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CalculatingDate {
	
	String dateStart;

	public String dateGenerator(String startDate, int effort) {
		// TODO Auto-generated method stub
		HashMap<String, String> holidayList = new HashMap<String, String>();
		

		Calendar Calend = Calendar.getInstance();
		SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");

		holidayList.put("New Year", "01/01/2019");
		holidayList.put("Sankranti", "01/15/2019");
		holidayList.put("Republic Day", "01/26/2019");
		holidayList.put("Maha Shivratri", "03/04/2019");
		holidayList.put("Good Friday", "04/19/2019");
		holidayList.put("May Day", "05/01/2019");
		holidayList.put("Idul Fitr", "06/05/2019");
		holidayList.put("Bakrid", "08/12/2019");
		holidayList.put("Independence Day", "08/15/2019");
		holidayList.put("Ganesh Chaturthi", "09/02/2019");
		holidayList.put("Gandhi Jayanthi", "10/02/2019");
		holidayList.put("Dussehra", "10/08/2019");
		holidayList.put("Diwali ", "10/29/2019");
		holidayList.put("Kannada Rajyotsava ", "11/01/2019");
		holidayList.put("Christmas", "12/25/2019");

		try {
			Calend.setTime(SDF.parse(startDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int workDays = 0;
		int totalDays = 0;
		do {

			int dayOfWeek = Calend.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {

				boolean wasHoliday = false;

				Set<Map.Entry<String, String>> holidays = holidayList.entrySet();
				
				dateStart = SDF.format(Calend.getTime());
				for (Map.Entry<String, String> holiday : holidays) {
					if (holiday.getValue().equalsIgnoreCase(dateStart)) {
						wasHoliday = true;
						break;
					}
				}
				if (!wasHoliday) {
					workDays++;
				}
			}

			Calend.add(Calendar.DAY_OF_MONTH, 1);
			totalDays++;
		} while (workDays < effort);

		try {
			Calend.setTime(SDF.parse(startDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calend.add(Calendar.DAY_OF_MONTH, totalDays - 1);
		SDF.applyPattern(" EEE    MM/dd/yyyy");
		String finalDate = SDF.format(Calend.getTime());
		return finalDate;		

	}
	
	public String toString(){
		return dateStart;
	}
	
	

}
