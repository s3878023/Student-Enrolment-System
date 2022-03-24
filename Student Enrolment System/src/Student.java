
import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private String birthDate;
    private ArrayList<Course> courseList;

    public Student(String id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.courseList = new ArrayList<Course>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }
}
