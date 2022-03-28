import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentEnrolmentManager implements IStudentEnrolmentManager{

    List<StudentEnrolment> studentEnrolmentList = new ArrayList<StudentEnrolment>();

    @Override
    public void add() {
        Scanner studentInputID = new Scanner(System.in);
        Scanner studentInputName = new Scanner(System.in);
        Scanner courseInputID = new Scanner(System.in);
        Scanner studentInputBirthDate = new Scanner(System.in);
        Scanner enrollSemesterInput = new Scanner(System.in);
        Scanner courseNameInput = new Scanner(System.in);
        Scanner creditInput = new Scanner(System.in);
        System.out.println("Welcome to the Student Enrolment System");
        System.out.println("Please enter the student ID:");
        String studentID = studentInputID.nextLine();

        System.out.println("Please enter the student name:");
        String studentName = studentInputName.nextLine();

        System.out.println("Please enter the student birthdate");
        String studentBirthDate = studentInputBirthDate.nextLine();

        System.out.println("Please enter the ID of the course you want to enroll");
        String courseID = courseInputID.nextLine();

        System.out.println("Please enter the name of the course");
        String courseName = courseNameInput.nextLine();

        System.out.println("Please enter the number of credit");
        int creditNumber = creditInput.nextInt();

        System.out.println("Please choose your semester that you want to enroll:");
        String enrollSemester = enrollSemesterInput.nextLine();


        Student student = new Student(studentID,studentName,studentBirthDate);
        Course course = new Course(courseID,courseName,creditNumber);
        StudentEnrolment studentEnrolment = new StudentEnrolment(student, course, enrollSemester);
        studentEnrolmentList.add(studentEnrolment);
    }

    @Override
    public void getAll() {
        for (StudentEnrolment item : studentEnrolmentList) {
            System.out.println(item.getStudent().getName());
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void getOne() {

    }
}