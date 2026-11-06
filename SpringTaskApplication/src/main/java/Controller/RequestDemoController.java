package Controller;

import Exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class RequestDemoController {

    @GetMapping("/error/{id}")
    public String getEmployee(@PathVariable Long id) {

        throw new EmployeeNotFoundException(
                "Employee with ID " + id + " does not exist"
        );
    }

    @GetMapping("/server-error")
    public String serverError() {

        throw new IllegalStateException("Database connection failed");
    }
}