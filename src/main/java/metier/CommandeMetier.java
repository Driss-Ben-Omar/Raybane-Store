package metier;

import entities.Commande;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommandeMetier {

	public Date stringToDate(String dateString) {
		String format = "yyyy-MM-dd";

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			date = dateFormat.parse(dateString);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public String dateToString(Date date) {
		date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		return strDate;
	}

	public String status(Date date) {
		String format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String dateNowString = dateFormat.format(new Date());
		System.out.println(dateNowString);
		Date dateNow = stringToDate(dateNowString);
		int result = date.compareTo(dateNow);
		if (result < 0) {
			return "delevered";
		} else if (result > 0) {
			return "proccess";
		} else {
			return "shipped";
		}
	}

	public Date formatDate(Date date) {
		String format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String dateNowString = dateFormat.format(new Date());
		Date dateNow = stringToDate(dateNowString);
		System.out.println("hello " + dateNow.toString());
		return dateNow;
	}

}
