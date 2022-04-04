import javax.naming.MalformedLinkException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {

//    public

    public static void main(String[] args) {
        List<String> container = CSVManager.read("./default.csv");
        List<Course> courseList = new ArrayList<Course>();
        List<String> semesterList = new ArrayList<String>();
        List<Student> studentList = new ArrayList<Student>();

        for (String item : container) {
            List<String> itemArr = List.of(item.split(","));
//            System.out.println(itemArr);
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
        }
        System.out.println(courseList);
        System.out.println(semesterList.);
        System.out.println(studentList.toString());


//        List<String> exportData = new ArrayList<String>();
//        exportData.add("S101312,Alex Mike,10/13/1998,PHYS1230,Introductory Human Physiology,4,2021A");
//        exportData.add("S103817,Thuy Thu Nguyen,3/4/2000,COSC4030,Theory of Computation,5,2020C");
//        CSVManager.write("./result.csv", exportData);

//        Student s1 = new Student("s3878023", "Nguyen Duc Dai", "16/08/2002");
//        Student s2 = new Student("s3878707", "Tran Ly The Quang", "01/04/2002");
//        studentList.add(s1);
//        studentList.add(s2);


            StudentEnrolmentManager manager = new StudentEnrolmentManager(studentList, courseList, semesterList);
            Scanner askScanner = new Scanner(System.in);
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
                        List<String> courseOfStud = manager.allCourseOfStudent();
                        CSVManager.write("./result.csv", courseOfStud);
                        break;
                    case 7:
                        System.out.println(">> PRINT ALL STUDENT OF ONE COURSE ONE SEMESTER <<");
                        List<String> studInCourse = manager.allStudentInCourse();
                        CSVManager.write("./result.csv", studInCourse);
                        break;
                    case 8:
                        System.out.println(">> PRINT ALL COURSE OF ONE SEMESTER <<");
                        List<String> courseinOneSem = manager.allCourseOneSem();
                        CSVManager.write("./result.csv", courseinOneSem);

                        break;
                    default:
                        System.out.println("Please chose option exist in menu!!!");
                        break;
                }
            }

        }
    }

