import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

//    public

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        Student s1 = new Student("s3878023", "Nguyen Duc Dai", "16/08/2002");
        Student s2 = new Student("s3878707", "Tran Ly The Quang", "01/04/2002");
        studentList.add(s1);
        studentList.add(s2);
        List<Course> courseList = new ArrayList<Course>();
        List<String> semesterList = new ArrayList<String>();

        StudentEnrolmentManager manager = new StudentEnrolmentManager(studentList, courseList, semesterList);
        Scanner askScanner = new Scanner(System.in);

        //

        while (true) {
            System.out.println("Menu");
            System.out.println("1. ADD Student Enrolment");
            System.out.println("2. UPDATE Student Enrolment");
            System.out.println("3. DELETE Student Enrolment");
            System.out.println("4. Print ONE Student Enrolment");
            System.out.println("5. Print ALL Student Enrolment");
            System.out.println("6. CSV Print ALL course of ONE student ONE semester ");
            System.out.println("7. CSV Print ALL Student of ONE course ONE semester");
            System.out.println("8. Print All Course in ONE semester");
            System.out.println("0. Sign out the earth");
            System.out.print("Please enter your option: ");
            int askValue = askScanner.nextInt();

            if (askValue == 0) {
                break;
            }

            switch (askValue) {
                case 1:
                    System.out.println(">> ADD STUDENT ENROLMENT <<");
                    manager.add();
                    break;
                case 2:
                    System.out.println(">> UPDATE STUDENT ENROLMENT <<");
                    manager.update();
                    break;
                case 3:
                    System.out.println(">> DELETE STUDENT ENROLMENT <<");
                    manager.delete();
                    break;
                case 4:
                    System.out.println(">> PRINT ONE STUDENT ENROLMENT <<");
                    manager.getStudentEnrolmentFromUserInput();
                    break;
                case 5:
                    System.out.println(">> PRINT ALL STUDENT ENROLMENT <<");
                    manager.printAll();
                    break;
                case 6:
                    System.out.println(">> PRINT ALL COURSE OF ONE STUDENT ONE SEMESTER <<");
                    manager.allCourseOfStudent();
                    break;
                case 7:
                    System.out.println(">> PRINT ALL STUDENT OF ONE COURSE ONE SEMESTER <<");

                    break;
                case 8:
                    break;
                default:
                    System.out.println("Please chose option exist in menu!!!");
                    break;
            }
        }

    }
}