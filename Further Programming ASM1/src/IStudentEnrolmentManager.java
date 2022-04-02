import java.util.List;

public interface IStudentEnrolmentManager {
    public void add();

    public List getAll();

    public boolean update();

    public boolean delete();

    public StudentEnrolment getOne(String studentId, String courseId, String semester);
}
