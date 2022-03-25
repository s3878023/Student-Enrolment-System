import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner studentInputID = new Scanner(System.in);
        Scanner enrollSemester = new Scanner(System.in);
        Scanner courseInputID = new Scanner(System.in);
        System.out.println("Welcome to the Student Enrolment System");

        System.out.println("Please Enter The Student ID:");
        String studentIDObj = studentInputID.nextLine();

        System.out.println("Please Enter the Semester:");
        String enrollSemesterObj = enrollSemester.nextLine();

        System.out.println("Please Enter The Course ID");
        String courseIDObj = courseInputID.nextLine();


        System.out.println("Confirm your choice as listed:"+ " " + "Student ID: " + studentIDObj+ " " + "Semester: " + enrollSemesterObj + " " + "Course ID: " + courseIDObj);
        System.out.println("Confirm your enrolment ?   Y/N ");

        Student s1 = new Student("","","");

    }
}
