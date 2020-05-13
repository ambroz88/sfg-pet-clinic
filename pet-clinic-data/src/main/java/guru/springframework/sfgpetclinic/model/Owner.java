package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {
    public Owner() {
    }

    @Builder
    public Owner(String firstName, String lastName, String address, String city, String telephone) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}
