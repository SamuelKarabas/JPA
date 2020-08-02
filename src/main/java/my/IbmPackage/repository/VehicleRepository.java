package my.IbmPackage.repository;

import my.IbmPackage.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {




List<Vehicle> findByNameContaining(String name);

    List<Vehicle> findAllByNameNotContaining(String num);

    @Async
    CompletableFuture<Vehicle> findByName(String status);


    //@Query("FROM Vehicle WHERE name like '%q%'")

    @Query("SELECT v FROM Vehicle v WHERE v.address = :address")
    List<Vehicle> retrieveByName(@Param("address")String address);




}
