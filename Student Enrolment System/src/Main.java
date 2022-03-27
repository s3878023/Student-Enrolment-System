import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner studentInputID = new Scanner(System.in);
        Scanner studentInputName = new Scanner(System.in);
        Scanner courseInputID = new Scanner(System.in);
        Scanner studentInputBirthDate = new Scanner(System.in);
        Scanner enrollSemester = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);

        System.out.println("Welcome to the Student Enrolment System");

        System.out.println("Please enter the student ID:");
        String studentIDObj = studentInputID.nextLine();

        System.out.println("Please enter the student name:");
        String studentName = studentInputName.nextLine();

        System.out.println("Please enter the student birthdate");
        String studentBirthDate = studentInputBirthDate.nextLine();

        System.out.println("Please enter the ID of the course you want to enroll");
        String courseIDObj = courseInputID.nextLine();

        System.out.println("Please choose your semester that you want to enroll:");
        String enrollSemesterObj = enrollSemester.nextLine();


        Student s1 = new Student(studentIDObj, studentName,studentBirthDate);
        Course c1 = new Course("PYSP1221", "Intro to Programming", 12);

        System.out.println("Confirm your choice as listed:" + "\nStudent ID: " + studentIDObj + "\nStudent name: " + studentName +"\nStudent Birthdate:" + studentBirthDate  +"\nSemester: " + enrollSemesterObj  + "\nCourse ID: " + courseIDObj);
        System.out.println("Confirm your enrolment ?   Y/N ");
        String userChoiceYN = choice.nextLine();
        if (userChoiceYN == "Y"){
            if (c1.add(s1)){
                System.out.println("Student Successfully Enrolled");
            }
            else {
                System.out.println("The student is currently in the course");
            }
        }else {
            System.out.println("You choose nothing");
        }






    }
}
