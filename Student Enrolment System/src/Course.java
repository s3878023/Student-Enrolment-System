public class Course {
    private String courseID;
    private String courseName;
    private int numberCredit;

    public Course(String courseID, String courseName, int numberCredit) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.numberCredit = numberCredit;
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

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setNumberCredit(int numberCredit) {
        this.numberCredit = numberCredit;
    }
}
