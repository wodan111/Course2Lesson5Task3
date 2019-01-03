package ua.testov.test; 

public class Student extends Human {
	private boolean stipend;
	private int numberOfGradebook;
	private double gradePoint;


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int numberOfGradebook, String secondName) {
		super();
		this.numberOfGradebook = numberOfGradebook;
		super.setSecondName(secondName);
	}

	public Student(int numberOfGradebook, String secondName, boolean gender, double age) {
		super();
		this.numberOfGradebook = numberOfGradebook;
		super.setSecondName(secondName);
		super.setGender(gender);
		super.setAge(age);
	}

	public Student(String firstName, String secondName, boolean gender, double age, int numberOfGradebook,
			double gradePoint) {
		super(firstName, secondName, gender, age);
		this.numberOfGradebook = numberOfGradebook;
		this.gradePoint = gradePoint;
		super.setAge(age);
	}

	public int getNumberOfGradebook() {
		return numberOfGradebook;
	}

	public void setNumberOfGradebook(int numberOfGradebook) {
		this.numberOfGradebook = numberOfGradebook;
	}

	public double getGradePoint() {
		return gradePoint;
	}

	public void setGradePoint(double gradePoint) {
		gradePoint = -1;
		if (gradePoint > 0 & gradePoint < 5.0) {
			this.gradePoint = gradePoint;
		}
	}

	public boolean isStipend() {
		stipend = false;
		if (this.getGradePoint() > 4.0) {
			stipend = true;
		}
		return stipend;
	}

	@Override
	public String toString() {
		return "Student [FirstName=" + getFirstName() + ", SecondName=" + getSecondName() + ", getGender()="
				+ isGender() + ", getAge()=" + getAge() + ", numberOfGradebook=" + numberOfGradebook + ", Stipend="
				+ stipend + ", Income=" + getIncome() + "]\n";
	}
}
