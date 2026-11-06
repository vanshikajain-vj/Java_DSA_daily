package Service;
import DTO.EmployeeDTO;
import Entity.Employee;
import Repository.EmployeeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Page<EmployeeDTO> getEmployeeList(Pageable pageable) {

        Page<Employee> employees = repo.findAll(pageable);

        return employees.map(e -> new EmployeeDTO(
                e.getId(),
                e.getName(),
                e.getDepartment()
        ));
    }
}
