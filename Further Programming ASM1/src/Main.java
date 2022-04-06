import javax.naming.MalformedLinkException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Ask the user to choose the file or automatically choose the default file for them//
        System.out.println("Please input an option: 1 => (Input file) || 2 => (Default file)");
        String response = in.nextLine();
        String fileName = "";
        if (response.equals("1")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please input the file name");
            String newsc = sc.nextLine();
            fileName = newsc;
            System.out.println(fileName);
        }
        if (response.equals("2")){
            fileName = "default";
        }
        //create the list to contain//
        List<String> container = CSVManager.read("./" + fileName + ".csv");
        List<Course> courseList = new ArrayList<Course>();
        List<String> semesterList = new ArrayList<String>();
        List<Student> studentList = new ArrayList<Student>();
        List<StudentEnrolment> studentEnrolmentList = new ArrayList<StudentEnrolment>();

        //run the loop through the container to get the data and add to the list//
        for (String item : container) {
            List<String> itemArr = List.of(item.split(","));
            String studentID = itemArr.get(0);
            String studentName = itemArr.get(1);
            String birthDate = itemArr.get(2);
            String courseID = itemArr.get(3);
            String courseName = itemArr.get(4);
            String credit = itemArr.get(5);
            String semester = itemArr.get(6);
            Student std = new Student(studentID, studentName, birthDate);
            studentList.add(std);
            Course crs = new Course(courseID, courseName, credit);
            courseList.add(crs);
            semesterList.add(semester);
            StudentEnrolment enrolment = new StudentEnrolment(std, crs, semester);
            studentEnrolmentList.add(enrolment);

        }
        //Create student enrolment (manager)//
        StudentEnrolmentManager manager = new StudentEnrolmentManager(studentList, courseList, semesterList, studentEnrolmentList);
        Scanner askScanner = new Scanner(System.in);
        //main menu function//
        while (true) {
            System.out.println("\nMenu");
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
                    System.out.println(">> ---- ADD STUDENT ENROLMENT ---- <<");
                    manager.add();
                    break;
                case 2:
                    System.out.println(">> ---- UPDATE STUDENT ENROLMENT ---- <<");
                    manager.update();
                    break;
                case 3:
                    System.out.println(">> ---- DELETE STUDENT ENROLMENT ---- <<");
                    manager.delete();
                    break;
                case 4:
                    System.out.println(">> ---- PRINT ONE STUDENT ENROLMENT ---- <<");
                    manager.getStudentEnrolmentFromUserInput();
                    break;
                case 5:
                    System.out.println(">> ---- PRINT ALL STUDENT ENROLMENT ---- <<");
                    manager.printAll();
                    break;
                case 6:
                    System.out.println(">> ---- PRINT ALL COURSE OF ONE STUDENT ONE SEMESTER ---- <<");
                    List<String> courseOfStud = manager.allCourseOfStudent();
                    System.out.println(courseOfStud);
                    CSVManager.write("./result.csv", courseOfStud);
                    break;
                case 7:
                    System.out.println(">> ---- PRINT ALL STUDENT OF ONE COURSE ONE SEMESTER ---- <<");
                    List<String> studInCourse = manager.allStudentInCourse();
                    System.out.println(studInCourse);
                    CSVManager.write("./result.csv", studInCourse);
                    break;
                case 8:
                    System.out.println(">> ---- PRINT ALL COURSE OF ONE SEMESTER ---- <<");
                    List<String> courseinOneSem = manager.allCourseOneSem();
                    System.out.println(courseinOneSem);
                    CSVManager.write("./result.csv", courseinOneSem);
                    break;
                default:
                    System.out.println("Please chose option exist in menu!!!");
                    break;
            }
        }

    }
}

