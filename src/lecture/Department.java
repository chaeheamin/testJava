package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Lecture> lectureList = new ArrayList<>();
	
	void run(Scanner scan) {
		readAllLectures(scan);
		readAllStudent(scan);
	}

	void readAllLectures(Scanner scan) {
		String code;
		while (true) {
			code = scan.next();
			if (code.contentEquals("end")) 
				break;
			Lecture lec = new Lecture(code);
			lec.read(scan);
			lectureList.add(lec);
		}
	}
	
	void printAllLectures() {
		for (Lecture lec: lectureList)
			lec.print();
		System.out.println();
	}

	void readAllStudent(Scanner scan) {
		Student st = null;
		int id;
		while (true) {
			id = scan.nextInt();
			if (id == 0) break;
			st = new Student(id, this);
			st.read(scan);
			studentList.add(st);
		}
	}
	
	void printAllStudent() {
		for (Student st: studentList)
			st.print(true);
	}
	
	Lecture findLecture(String code) {
		for (Lecture lec: lectureList)
			if (lec.matches(code))
				return lec;
		return null;
	}
	
	// 학생 - 멀티키워드 검색
	void search(Scanner scan) {
		String kwd;
		kwd = scan.nextLine();
		String[] kwdArr;
		while (true) {
			System.out.print("검색 키워드 여러개 (빈칸으로 구분/바로 엔터시 종료): ");
			kwd = scan.nextLine();
			if (kwd.contentEquals(""))
				break;
			kwdArr = kwd.split(" ");
			for (Student st: studentList)
				if (st.matches(kwdArr))
					st.print(false);
		}
	}
	
	// 과목 - 키워드 검색
	void searchLecture(Scanner scan) {
		String kwd;
		kwd = scan.nextLine();
		while (true) {
			System.out.print("과목 검색 키워드: ");
			kwd = scan.next();
			if (kwd.contentEquals("end"))
				break;
			for (Lecture lec: lectureList)
				if (lec.matches(kwd))
					lec.print();
		}
	}
	
	// 연관 검색 - 과목별 수강생
	void searchStudentByLecture(Scanner scan) {
		String kwd;
		kwd = scan.nextLine();
		Lecture lecture = null;
		while (true) {
			System.out.print("과목 검색 키워드: ");
			kwd = scan.next();
			if(kwd.contentEquals("end")) break;
			for (Lecture lec: lectureList) {
				if (lec.matches(kwd)) {
					lecture = lec;
					lecture.print();
					for (Student st: studentList)
						if(st.containsLecture(lecture))
							st.print(false);
				}
			}
			if(lecture == null) {
				System.out.println("없는 과목명입니다.");
				return;
			}
		}
	}
	
	// 연관 검색 - 요일별 수강생
	void searchStudentByDays(Scanner scan) {
		String kwd;
		kwd = scan.nextLine();
		while (true) {
			System.out.print("요일: ");
			kwd = scan.next();
			if(kwd.contentEquals("end")) break;
			System.out.printf("%s요일 수강생: ", kwd);
			for (Student st: studentList) 
				if (st.matchDays(kwd))
					System.out.printf("%s ", st.name);
			System.out.println();
					
		}
	}
	
	// 연관 검색 - 타학년 과목 수강생 수 조사
	void searchdifferYearInLectures() {
		for (Lecture lec: lectureList) {
			int diffNum = 0;
			for (Student st: studentList) {
				if (st.containsLecture(lec) && st.differYear(lec.year)) {
					diffNum++;
					System.out.printf("%s ", st.name);
				}
			}
			if (diffNum != 0) {
				System.out.printf(" (%d명)\n", diffNum);
				lec.print();
			}
			
		}
	}
}
