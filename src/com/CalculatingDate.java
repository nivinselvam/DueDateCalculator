package com;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class CalculatingDate {

	public String dateGenerator(String startDate, int effort) {
		// TODO Auto-generated method stub

		Calendar Calend = Calendar.getInstance();
		SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");
		
		String holiday[] = new String[28];
		holiday[0] = "01/01/2018";
		holiday[1] = "01/15/2018";
		holiday[2] = "01/26/2018";
		holiday[3] = "03/30/2018";
		holiday[4] = "05/01/2018";
		holiday[5] = "06/15/2018";
		holiday[6] = "08/15/2018";
		holiday[7] = "09/13/2018";
		holiday[8] = "10/02/2018";
		holiday[9] = "10/19/2018";
		holiday[10] = "11/01/2018";
		holiday[11] = "11/07/2018";
		holiday[12] = "11/08/2018";
		holiday[13] = "12/25/2018";
		
		holiday[14] = "01/01/2019";
		holiday[15] = "01/15/2019";
		holiday[16] = "01/26/2019";
		holiday[17] = "03/30/2019";
		holiday[18] = "05/01/2019";
		holiday[19] = "06/15/2019";
		holiday[20] = "08/15/2019";
		holiday[21] = "09/13/2019";
		holiday[22] = "10/02/2019";
		holiday[23] = "10/19/2019";
		holiday[24] = "11/01/2019";
		holiday[25] = "11/07/2019";
		holiday[26] = "11/08/2019";
		holiday[27] = "12/25/2019";

		try{
			Calend.setTime(SDF.parse(startDate));
		}catch(ParseException e){
			e.printStackTrace();
		}

		int workDays = 0;
		int totalDays = 0;
		do {

			int dayOfWeek = Calend.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY){

				boolean wasHoliday=false;
				for(int j=0;j<holiday.length;j++){
					if(holiday[j].equalsIgnoreCase(SDF.format(Calend.getTime()))){
						wasHoliday= true;
						break;
					}
				}		
				if(!wasHoliday){
					workDays++;
				}
			}    

			Calend.add(Calendar.DAY_OF_MONTH, 1);
			totalDays++;
		} while (workDays < effort);

		try{
			Calend.setTime(SDF.parse(startDate));
		}catch(ParseException e){
			e.printStackTrace();
		}

		Calend.add(Calendar.DAY_OF_MONTH, totalDays-1);
		SDF.applyPattern(" EEE    MM/dd/yyyy");
		String finalDate = SDF.format(Calend.getTime());
		return finalDate;
		
	}

}
