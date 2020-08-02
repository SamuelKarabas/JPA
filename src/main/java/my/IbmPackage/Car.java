package my.IbmPackage;


import my.IbmPackage.model.Vehicle;
import my.IbmPackage.repository.ArticleRepository;
import my.IbmPackage.repository.CrudRepositoryImpl;
import my.IbmPackage.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@SpringBootApplication(scanBasePackages = {"my.IbmPackage"})
@EntityScan("my.IbmPackage.model")
public class Car {


    @Autowired
    VehicleRepository repository;
    @Autowired
    CrudRepositoryImpl crudRepositoryImpl;
    @Autowired
    EntityManager em;
    @Autowired
    private ArticleRepository repo;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Car.class, args);

    }

    public List<Vehicle> findWithName(String address) {
        return em.createQuery(
                "SELECT v FROM Vehicle v WHERE v.id = '" + 19 + "'", Vehicle.class)

                .getResultList();

    }

    @GetMapping("/qw")
    public String a() throws ExecutionException, InterruptedException {


        String name="sona";
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Vehicle> criteriaQuery = cb.createQuery(Vehicle.class);
        Root<Vehicle> customer = criteriaQuery.from(Vehicle.class);
        ParameterExpression<String> nameParameter = cb.parameter(String.class, "name");
        criteriaQuery.select(customer).where(cb.equal(customer.get("name"), nameParameter));
        Vehicle name1 = em.createQuery(criteriaQuery).setParameter("name", name).getSingleResult();

        System.out.println(name1.getName());

//        ParameterExpression<String> paramEmpNumber = cb.parameter(String.class);
//        cQuery.select(c).where(cb.equal(c.get(Vehicle_.name), paramEmpNumber));
//
//        TypedQuery<Vehicle> query = em.createQuery(cQuery);
//        String empNumber = "A123";
//        query.setParameter(paramEmpNumber, empNumber);
//        List<Vehicle> employee = query.getResultList();

//        TypedQuery<Vehicle> vv = em.createQuery("SELECT v FROM Vehicle v WHERE v.name= :name", Vehicle.class);
//
//        //.getSingleResult();
//
//        List<String> s = new ArrayList<>() {{
//            add("sona");
//            add("A123");
//        }};
//
//        System.out.println(vv.setParameter("name", "sona").getSingleResult().getName());
//
//
//        // System.out.println(">>>" + vv.getSingleResult().getName());
//        //return r
//        // epository.findAllByNameNotContaining("qq").get(0).getName();
//
//
//        List<Vehicle> v = repository.retrieveByName("bruselska");
//

        return "a";


//        try {
//            Stream<Vehicle> qq = repository.findAllByName("qq");
//            Long n = qq.count();
//            System.out.println(n);
//            return n;
//        } catch (Exception e) {
//
//        }


    }


}
