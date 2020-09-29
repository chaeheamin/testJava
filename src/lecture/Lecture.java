package lecture;

import java.util.Scanner;

public class Lecture {
	// DD746    창의기초설계    1 월 123
	String code;
	String title;
	int year;
	String date;
	String time;
	
	Lecture(String code) {
		this.code = code;
	}

	void read(Scanner scan) {
		title = scan.next();
		year = scan.nextInt();
		date = scan.next();
		time = scan.next();
	}

	void print() {
		System.out.printf("[%s] %s %d학년 %s %s\n",
				code, title, year, date, time);
	}

	boolean matches(String code) {
		if (code.length() >3 && code.contentEquals(this.code))
			return true;
		if (title.contains(code))
			return true;
		if (code.contentEquals("" + year))
			return true;
		if (code.contentEquals(date))
			return true;
		if (code.contentEquals(time))
			return true;
		return false;
	}
	
	boolean matches(String[] codes) {
		for (String code: codes) {
			if (!matches(code))
				return false;
		}
		return true;
	}
}
