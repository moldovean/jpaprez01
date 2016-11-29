package playground;

import entities.Employee;
import services.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by avrabie on 11/29/2016.
 */
public class Play {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        EmployeeService service = new EmployeeService(em);

        service.createEmployee("Victor","Turcanu",1000L);
        service.createEmployee("Gabriel","Turcanu",1000L);
        service.createEmployee("Ion","Turcanu",1000L);
        service.createEmployee("Victor","Berzoi",1000L);
        service.createEmployee("Vlad","Cadea",1000L);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        transaction.commit();

        service.deleteEmployee(2L);
        transaction.begin();
        transaction.commit();

        List<Employee> list = service.findAllEmployees();

        System.out.println(list);
        em.close();
        emf.close();

    }
}
