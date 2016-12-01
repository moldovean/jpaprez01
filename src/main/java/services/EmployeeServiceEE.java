package services;

import entities.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by avrabie on 11/29/2016.
 */

@Stateless
public class EmployeeServiceEE {
    @PersistenceContext(unitName = "EmployeeService")
    private EntityManager em;
    //For Java EE we delete the constructor and we hardcode the id in the Employee

    EntityManager getEntityManager(){
        return em;
    }

    public Employee createEmployee(Long id, String firstName, String lastName, Long salary){
        Employee employee=new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);
        getEntityManager().persist(employee);
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
