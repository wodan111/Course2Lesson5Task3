package ua.testov.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileReader;

public class Group implements Military {

	private String name;
	private Student[] st = new Student[10];

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addStudent() throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			int x;
			String str = "";
			try {
				for (int i = 0; i < st.length; i++) {
					System.out.println("Введіть номер залікової книжки для студента " + (i + 1) + ":");
					x = Integer.valueOf(sc.nextLine());

					System.out.println("Введіть прізвище студента " + (i + 1) + ":");
					str = sc.nextLine();
					Student st = new Student(x, str);
					this.st[i] = st;
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Не правильне введення");
			}
		}
	}

	public void addStudent(int n, Student... names) throws myException {
		if (names.length > 10 - (n - 1) || n < 1)
			throw new myException();
		for (int i = 0; i < names.length; i++) {
			if (st[n - 1] == null) {
				st[n - 1] = names[i];
			} else {
				System.out.print("Елемент " + (n - 1) + " не є пустим.");
			}
			n++;
		}
	}

	public void delStudent(int i) {
		st[i] = null;
	}

	public Student searchStudent(String str) {
		Student s = new Student();
		for (int i = 0; i < this.st.length; i++) {
			if (this.st[i] != null) {
				if (this.st[i].getSecondName().equals(str)) {
					s = this.st[i];
					break;
				}
			}
		}

		if (s.getSecondName() == null) {
			System.out.print("Студента не знайдено! ");
			return null;
		}
		return s;
	}

	public enum En {
		reverse, withoutReverse;
	}

	public Student[] sortWithParam(int p, En n) {
		if (p < 1 || p > 3) {
			throw new IllegalArgumentException();
		}
		try {
			if (n == En.reverse) {
				Arrays.sort(st, Collections.reverseOrder(new SortWithParameter(p)));
			} else {
				Arrays.sort(st, new SortWithParameter(p));
			}

		} catch (Exception e) {
			System.out.println("null element(-s) in massive");
		}

		return st;
	}

	public Student[] getDraftees(Student[] student) {
		Student[] recruits = new Student[10];
		int n = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i] == null) {
				continue;
			}
			if (student[i].getAge() >= 18 & student[i].isGender()) {
				recruits[n] = student[i];
				n++;
			}
		}
		return recruits;
	}

	public File saveStringToFile(String str, File file) {

		try (PrintWriter a = new PrintWriter(file)) {
			a.print(str);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}
		return file;
	}

	public File writeGroupToFile(String path) {
		String str = "";
		try {
			for (int i = 0; i < this.st.length; i++) {
//		str+=st[i].getFirstName()+" "+st[i].getSecondName()+" "+st[i].isGender()+" "+st[i].getAge()+" "+st[i].getNumberOfGradebook()+" "+
//				st[i].isStipend()+" "+st[i].getIncome();
				if(st[i]!=null) {
				str += this.st[i].getNumberOfGradebook() + "," + this.st[i].getSecondName() + ","
						+ this.st[i].isGender() + "," + this.st[i].getAge();
				str+=System.lineSeparator();
				}
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return saveStringToFile(str, new File(path, "result.csv"));
	}
	

	@Override
	public String toString() {
		for (int i = this.st.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (st[j] == null) {
					Student tmp = st[j];
					st[j] = st[j + 1];
					st[j + 1] = tmp;
				}
			}
		}
		for (int i = this.st.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (st[j] != null & st[j + 1] != null)
					if (st[j].getSecondName().compareToIgnoreCase(st[j + 1].getSecondName()) > 0) {
						Student tmp = st[j];
						st[j] = st[j + 1];
						st[j + 1] = tmp;
					}
			}
		}
		return "Group " + Arrays.toString(st);
	}

}
