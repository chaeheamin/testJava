package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	int id;
	String name;
	String phone;
	int year;
	
	Department department;
	ArrayList<Lecture> registeredList = new ArrayList<>();
	
	Student(int id, Department department) {
		this.id = id;
		this.department = department;
	}
	
	void read(Scanner scan) {
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
		String code = null;
		Lecture lec = null;
		while (true) {
			code = scan.next();
			if (code.contentEquals("0"))
				break;
			lec = department.findLecture(code);
			if (lec == null) {
				System.out.println("잘못된 코드입니다 - " + code);
				continue;
			}
			registeredList.add(lec);
		}
	}
	
	void print(boolean bool) {
		System.out.printf("%d %s %s %d학년\n", id, name, phone, year);
		if (bool == true)
			for (Lecture lec: registeredList) {
				System.out.print(" \t ");
				lec.print();
			}
	}
	
	
	boolean matches(String kwd) {
		if (name.contains(kwd))
			return true;
		if (kwd.length() > 3 && (id + "").contains(kwd))
			return true;
		if (kwd.equals("" + year))
			return true;
		if (kwd.length() > 3 && phone.contains(kwd))
			return true;
		for (Lecture lec: registeredList)
			if (kwd.length() > 3 && lec.matches(kwd))
				return true;
		return false;
	}
	
	boolean matches(String[] kwds) {
		for (String kwd: kwds) {
			if (!matches(kwd))
				return false;
		}
		return true;
	}
	
	boolean containsLecture(Lecture lecture) {
		for (Lecture lec: registeredList) {
			if (lec == lecture)
				return true;
		}
		return false;
	}
	
	boolean matchDays(String day) {
		for (Lecture lec: registeredList) {
			if (lec.matches(day))
				return true;
		}
		return false;
	}

	boolean differYear(int year) {
		return this.year != year;
	}
		
}