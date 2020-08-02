package my.IbmPackage.repository;

import my.IbmPackage.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrudRepositoryImpl extends CrudRepository<Vehicle,Long> {

 //   Vehicle ;

    Vehicle findByName(String name);
}
