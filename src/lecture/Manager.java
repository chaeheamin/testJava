package lecture;

import java.util.Scanner;

public class Manager {

	static Scanner scan = new Scanner(System.in);
	Department department = new Department();
	
	void run() {
		department.run(scan);
		majorMenu();
	}
	
	void majorMenu() {
		int input = 0;
		while (true) {
			System.out.print("대분류  (1) 학생  (2) 과목  (3) 연관검색  ");
			input = scan.nextInt();
			switch (input) {
			case 1: studentMenu(); break;
			case 2: lectureMenu(); break;
			case 3: linkMenu(); break;
			default: break;
			}
			if (input == 0) break;
		}
	}
	
	void studentMenu() {
		int input = 0;
		while (true) {
			System.out.print("학생세부메뉴   (1) 학생 전체 출력  (2) 멀티키워드검색  ");
			input = scan.nextInt();
			switch (input) {
			case 1: department.printAllStudent(); break;
			case 2: department.search(scan); break;
			default: break;
			}
			if (input == 0) break;
		}
	}
	
	void lectureMenu() {
		int input = 0;
		while (true) {
			System.out.print("과목세부메뉴  (1) 과목전체출력   (2) 키워드검색  ");
			input = scan.nextInt();
			switch (input) {
			case 1: department.printAllLectures(); break;
			case 2: department.searchLecture(scan); break;
			default: break;
			}
			if (input == 0) break;
		}
	}

	void linkMenu() {
		int input = 0;
		while (true) {
			System.out.print("연관검색메뉴  (1) 과목별 수강생   (2) 요일별 수강생  "
					+ "(3) 타학년 과목 수강생 수 조사  ");
			input = scan.nextInt();
			switch (input) {
			case 1: department.searchStudentByLecture(scan); break;
			case 2: department.searchStudentByDays(scan); break;
			case 3: department.searchdifferYearInLectures(); break;
			default: break;
			}
			if (input == 0) break;
		} 
	}
	
	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.run();
	}

}
