package services;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by avrabie on 11/29/2016.
 */
public class EmployeeService {
    private EntityManager em = null;

    public EmployeeService(EntityManager entityManager) {
        this.em = entityManager;
    }

    public Employee createEmployee(String firstName, String lastName, Long salary) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);
        em.persist(employee);
        return employee;
    }

    public void deleteEmployee(Long id) {
        Employee employee = em.find(Employee.class, id);
        if (!(employee == null)) {
            em.remove(employee);
        }
        return;
    }

    public Employee findEmployee(Long id) {
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e",Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    public Employee raiseEmployeeSalary(Long id, long raise) {
        Employee employee = findEmployee(id);
        if (!(employee == null)) {
            employee.setSalary(employee.getSalary() + raise);
        }
        return employee;
    }
}
