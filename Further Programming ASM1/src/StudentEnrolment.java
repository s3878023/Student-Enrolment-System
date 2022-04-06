public class StudentEnrolment {
    private Student student = null;
    private Course course = null;
    private String semester = "";

    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    //all the get set for the student
    public Student getStudent() {
        return this.student;
    }

    public Course getCourse() {
        return this.course;
    }

    public String getSemester() {
        return this.semester;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public boolean isMatchingStudentEnrolment(String studentID, String courseID, String semester) {
        String curStudentID = this.student.getId();
        String curCourseID = this.course.getCourseID();
        String curSemester = this.semester;
        return curStudentID.equals(studentID) && curCourseID.equals(courseID) && curSemester.equals(semester);
    }

    public void printInfo() {
        System.out.println("\nStudent ID: " + this.student.getId() + "\nStudent name: " + this.student.getName() +
                "\nCourse: " + this.course.getCourseName() + "\nSemester: " + this.semester);
    }
}