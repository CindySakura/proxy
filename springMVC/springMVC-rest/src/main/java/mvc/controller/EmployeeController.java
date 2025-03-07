package mvc.controller;

import mvc.bean.Employee;
import mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * 功能：
 * 作者：Cindy
 * 日期：10/08/2024 22:18
 */
@Controller
public class EmployeeController {
    @Autowired//默认根据byType 其次byName Resource 默认 byName, 如果byName找不到才 byType，Autowired 根据类型装配，想要根据名称需要配合 Qualifier
    private EmployeeDao employeeDao;

    @RequestMapping(value="/employee", method= RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList",employeeList);
        return "employee_list";
    }

    @RequestMapping(value="/employee/{id}", method= RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping(value="/employee", method= RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value="/employee/{id}", method= RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @RequestMapping(value="/employee", method= RequestMethod.PUT)
    public String updateEmployeeById(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
