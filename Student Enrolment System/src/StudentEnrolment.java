public class StudentEnrolment {
    private Student student = null;
    private Course course = null;
    private String semester = "";

    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Student getStudent(){
        return this.student;
    }
    public Course getCourse(){
        return this.course;
    }
    public String getSemester(){
        return this.semester;
    }
}