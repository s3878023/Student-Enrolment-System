import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentEnrolmentManager implements IStudentEnrolmentManager {

    List<StudentEnrolment> studentEnrolmentList = new ArrayList<StudentEnrolment>();
    List<Student> studentList = new ArrayList<Student>();
    List<Course> courseList = new ArrayList<Course>();
    List<String> semesterList = new ArrayList<String>();

    public StudentEnrolmentManager(List<Student> studentList, List<Course> courseList, List<String> semesterList) {
        this.studentList = studentList;
        this.courseList = courseList;
        this.semesterList = semesterList;

        // append dummy data
        Student s1 = new Student("s001", "Nguyen 1", "16/08/2002");
        Student s2 = new Student("s002", "Nguyen 2", "16/08/2002");
        Course c1 = new Course("c001", "OOP 1", 4);
        Course c2 = new Course("c002", "OOP 2", 4);

        StudentEnrolment se1 = new StudentEnrolment(s1, c1, "sem001");
        StudentEnrolment se2 = new StudentEnrolment(s2, c2, "sem002");
        this.studentEnrolmentList.add(se1);
        this.studentEnrolmentList.add(se2);
    }

    public boolean validateStudentById(String studentId) {
        for (Student student : this.studentList) {
            if (student.getId().equals(studentId)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateCourseById(String courseID) {
        for (Course course : this.courseList) {
            if (course.getCourseID().equals(courseID)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateSemester(String semester) {
        for (String semesterItem : semesterList) {
            if (semesterItem == semester) {
                return true;
            }
        }
        return false;
    }

    public Student getStudentByID(String studentID) {
        for (Student student : this.studentList) {
            if (student.getId().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

//    public Student getStudent

    public Course getCourseByID(String courseID) {
        for (Course course : courseList) {
            if (course.getCourseID() == courseID) {
                return course;
            }
        }
        return null;
    }

    public String getSemester(String semester) {
        for (String semesterItem : semesterList) {
            if (semesterItem == semester) {
                return semesterItem;
            }
        }
        return null;
    }

    public Student getFoundStudent() {
        Scanner newStudentIdScanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input the new Student ID: ");
            String newStudentId = newStudentIdScanner.nextLine();

            if (validateStudentById(newStudentId)) {
                return getStudentByID(newStudentId);
            }
            System.out.println("This student does not exist");
        }
    }

    public Course getFoundCourse() {
        Scanner newCourseIdScanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input the new Course ID: ");
            String newCourseId = newCourseIdScanner.nextLine();

            if (validateCourseById(newCourseId)) {
                return getCourseByID(newCourseId);
            }
            System.out.println("This course does not exist");
        }
    }

    public String getFoundSemester() {
        Scanner newSemesterScanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input the new Semester: ");
            String newSemester = newSemesterScanner.nextLine();

            if (validateSemester(newSemester)) {
                return getSemester(newSemester);
            }
            System.out.println("This semester does not exist");
        }
    }

    public StudentEnrolment getOne(String studentId, String courseId, String semester) {
        for (StudentEnrolment item : this.studentEnrolmentList) {
            if (item.isMatchingStudentEnrolment(studentId, courseId, semester)) {
                return item;
            }
        }
        return null;
    }

    //    @Override
    public List<StudentEnrolment> getAll() {
        return this.studentEnrolmentList;
    }

    public void printAll() {
        for (StudentEnrolment item : this.studentEnrolmentList) {
            item.printInfo();
        }
    }

    public StudentEnrolment getStudentEnrolmentFromUserInput() {
        while (true) {
            Scanner curStudentIdScanner = new Scanner(System.in);
            Scanner curCourseIdScanner = new Scanner(System.in);
            Scanner curSemesterScanner = new Scanner(System.in);

            System.out.println("Please enter the current enrolment info");
            System.out.print("Input the student ID: ");
            String curStudentId = curStudentIdScanner.nextLine();
            System.out.print("Input the course ID: ");
            String curCourseId = curCourseIdScanner.nextLine();
            System.out.print("Input the semester: ");
            String curSemester = curSemesterScanner.nextLine();

            StudentEnrolment studentEnrolment = getOne(curStudentId, curCourseId, curSemester);

            if (studentEnrolment == null) {
                Scanner retryScanner = new Scanner(System.in);
                System.out.println("[FAIL] Student Enrolment dose not exist!");
                System.out.print("Do you want input again? 1. Yes | 2. No: ");
                int retry = retryScanner.nextInt();
                if (retry == 2) {
                    return null;
                }
            } else {
                return studentEnrolment;
            }
        }
    }

    @Override
    public void add() {
        Scanner studentInputID = new Scanner(System.in);
        Scanner studentInputName = new Scanner(System.in);
        Scanner courseInputID = new Scanner(System.in);
        Scanner studentInputBirthDate = new Scanner(System.in);
        Scanner enrollSemesterInput = new Scanner(System.in);
        Scanner courseNameInput = new Scanner(System.in);
        Scanner creditInput = new Scanner(System.in);

        System.out.print("Please enter the student ID: ");
        String studentID = studentInputID.nextLine();

        System.out.print("Please enter the student name: ");
        String studentName = studentInputName.nextLine();

        System.out.print("Please enter the student birthdate: ");
        String studentBirthDate = studentInputBirthDate.nextLine();

        System.out.print("Please enter the ID of the course you want to enroll: ");
        String courseID = courseInputID.nextLine();

        System.out.print("Please enter the name of the course: ");
        String courseName = courseNameInput.nextLine();

        System.out.print("Please enter the number of credit: ");
        int creditNumber = creditInput.nextInt();

        System.out.print("Please choose your semester that you want to enroll: ");
        String enrollSemester = enrollSemesterInput.nextLine();

        Student student = new Student(studentID, studentName, studentBirthDate);
        Course course = new Course(courseID, courseName, creditNumber);
        StudentEnrolment studentEnrolment = new StudentEnrolment(student, course, enrollSemester);
        studentEnrolmentList.add(studentEnrolment);
    }

//    public void updateCourseBelongToStudentInSemester(studentId, semester) {
//        // get all course of student in semester
//        list<stuydentr enrolment> result;
//        for enrolment in enrolmentList :
//            if enrolment.getStudent.id === studentId and seester = mess
//                result.append
//
//        result =[record 1 record 2];
//
//            ask to user delete or iupdate copurse
//                delete
//                // asker input course info
//
//                for item in result;
//        item.setCourse
//                enrolment.remove
//
//    }
    public void addDeleteCourseStud (String studentID, String semester) {
        List<StudentEnrolment> result = new ArrayList<StudentEnrolment>();
        for (StudentEnrolment enrolment : this.studentEnrolmentList){
            if (enrolment.getStudent().getId().equals(studentID) && enrolment.getSemester().equals(semester)){
                result.add(enrolment);
            }

        }
    }

    public void allCourseOfStudent () {
        Scanner allCourseStudentID = new Scanner(System.in);
        Scanner allCourseStudentSem = new Scanner(System.in);
        System.out.print("Enter the student ID");
        String studentID = allCourseStudentID.nextLine();
        System.out.print("Enter the semester");
        String semesterAllCourse = allCourseStudentSem.nextLine();
        for (StudentEnrolment enrolment : this.studentEnrolmentList) {
            if (enrolment.getStudent().getId().equals(studentID) && enrolment.getSemester().equals(semesterAllCourse)) {
                System.out.println("All the course of the student in the semester: ");
                System.out.println(enrolment.getCourse().getCourseName());
            }
        }
    }

    public void allStudentInCourse (String courseID, String semester) {
         for (StudentEnrolment enrolment : this.studentEnrolmentList) {
             if (enrolment.getCourse().getCourseID().equals(courseID) && enrolment.getSemester().equals(semester)) {
                 System.out.println("All the student in this course: ");
                 System.out.println(enrolment.getStudent().getName());
             }
         }
    }



    @Override
    public boolean update() {
        /**
         * Case 1: change the student in the enrolment
         * case 2: change the course in the enrolment ( student enrolment include student id | course id | semester
         * case 3: change the semester in the enrolmen
         */

        Scanner askScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chose options below:");
            System.out.println("1. Update the student in the enrolment");
            System.out.println("2. Update the course in the enrolment");
            System.out.println("3. Update the semester in the enrolment");
            System.out.println("0. Exit");
            System.out.print("Please Enter your option: ");
            int askValue = askScanner.nextInt();

            if (askValue == 0) {
                return false;
            }

            StudentEnrolment curStuEnr = getStudentEnrolmentFromUserInput();

            if (curStuEnr == null) {
                return false;
            }

            switch (askValue) {
                case 1:
                    Student foundStudent = getFoundStudent();
                    curStuEnr.setStudent(foundStudent);
                    break;
                case 2:
                    Course foundCourse = getFoundCourse();
                    curStuEnr.setCourse(foundCourse);
                    break;
                default:
                    String foundSemester = getFoundSemester();
                    curStuEnr.setSemester(foundSemester);
                    break;
            }

            System.out.println("Student Enrolment updated successfully");

            return true;
        }
    }

    @Override
    public boolean delete() {
        StudentEnrolment curStuEnr = getStudentEnrolmentFromUserInput();

        if (curStuEnr == null) {
            return false;
        }

        this.studentEnrolmentList.remove(curStuEnr);
        System.out.println("Student Enrolment deleted successfully");

        return true;
    }
}