package cl.bci.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String created;

    @Column
    private String lastLogin;

    @Column
    private String token;

    @Column
    private Boolean isActive;

    @OneToMany(targetEntity = Telephone.class, cascade = CascadeType.ALL)
    private Set<Telephone> phones;


}

