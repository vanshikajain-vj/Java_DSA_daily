package Task2;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final DepartmentService departmentService;

    public EmployeeService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
