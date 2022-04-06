public class Course {
    private String courseID;
    private String courseName;
    private String numberCredit;

    public Course(String courseID, String courseName, String numberCredit) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.numberCredit = numberCredit;
    }

    // getter and setter of Course//
    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getNumberCredit() {
        return numberCredit;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setNumberCredit(String numberCredit) {
        this.numberCredit = numberCredit;
    }
}
