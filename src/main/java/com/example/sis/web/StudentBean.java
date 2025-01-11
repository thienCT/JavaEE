import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "studentBean")
@RequestScoped
public class StudentBean implements Serializable {

    @Inject
    private EntityManager em;

    @Inject
    private StudentService studentService; // EJB for business logic

    private String name;
    private String address;
    private List<Student> students;

    // Constructor
    public StudentBean() {
        students = loadAllStudents();
    }

    // Getters and setters for name, address
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
