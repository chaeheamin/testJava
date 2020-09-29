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
			System.out.print("��з�  (1) �л�  (2) ����  (3) �����˻�  ");
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
			System.out.print("�л����θ޴�   (1) �л� ��ü ���  (2) ��ƼŰ����˻�  ");
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
			System.out.print("���񼼺θ޴�  (1) ������ü���   (2) Ű����˻�  ");
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
			System.out.print("�����˻��޴�  (1) ���� ������   (2) ���Ϻ� ������  "
					+ "(3) Ÿ�г� ���� ������ �� ����  ");
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
