package ua.testov.test;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Student st1 = new Student(12345, "Bondar",false,18);
		Student st2 = new Student(12342, "Zhyravel",true,19);
		Student st3 = new Student(12347, "Kvasha",false,19);
		Student st4 = new Student(12343, "Zelenenko",true,17);
		Student st5 = new Student(12341, "Melnyk",true,18);

		Group gr1 = new Group("Group One");

		gr1.addStudent(1, st1, st2, st3, st4, st5);
//		System.out.println(Arrays.toString(gr1.sortWithParam(2,En.reverse)));
//		System.out.println(Arrays.toString(gr1.getDraftees(gr1.sortWithParam(2,En.reverse))));
	//	System.out.println(gr1);
	//	gr1.writeGroupToFile(".");
		Group groupOfStudent=Group.groupFromFile("result.csv");
		System.out.println(groupOfStudent);
	//	System.out.println(Arrays.asList(Group.groupFromFile("result.csv")));
//		Group.groupFromFile("result.csv");

	}
}
