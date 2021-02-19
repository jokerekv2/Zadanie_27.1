package pl.dm.zadanko.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("newEmployee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/add/employee")
    public String addEmployee(Employee newEmployee) {
        LocalDate birthday = newEmployee.getBirthday();
        employeeRepository.save(newEmployee);
        return "redirect:/";
    }

}
