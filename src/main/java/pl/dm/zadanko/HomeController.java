package pl.dm.zadanko;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dm.zadanko.employee.Employee;
import pl.dm.zadanko.employee.EmployeeRepository;

import java.time.LocalDate;

@Controller
public class HomeController {

    private EmployeeRepository employeeRepository;

    public HomeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "home";
    }
}
