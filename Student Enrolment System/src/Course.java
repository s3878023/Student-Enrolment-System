
import java.util.ArrayList;

public class Course {
    private String courseID;
    private String courseName;
    private int numberCredit;
    private ArrayList<Student> studentList;

    public Course(){
        this.courseID = "default";
        this.courseName = "default";
        this.numberCredit = 000;
        this.studentList = new ArrayList<Student>();
    }

    public Course(String courseID, String courseName, int numberCredit) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.numberCredit = numberCredit;
        this.studentList = new ArrayList<Student>();
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberCredit() {
        return numberCredit;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}
