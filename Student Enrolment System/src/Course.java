
import java.util.ArrayList;

public class Course implements StudentEnrolmentManager{
    private String courseID;
    private String courseName;
    private int numberCredit;
    private ArrayList<Student> studentList;



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

    public boolean add (Student student) {
        if (studentList.contains(student)){
            return false;
        }
        studentList.add(student);
        student.getCourseList().add(this);
        return true;
    }

    public void delete(){
        return;
    }
    public void getOne(){
        return;
    }
    public void update(){
        return;
    }
    public void getAll(){
        return;
    }


}
