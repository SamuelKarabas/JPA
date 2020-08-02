package my.IbmPackage.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Vehicle {
    

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String address;

    public Vehicle() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }
}
