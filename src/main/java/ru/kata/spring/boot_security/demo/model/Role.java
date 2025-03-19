package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();



    // Геттеры, сеттеры, конструкторы

    //@Autowired
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role() {}
    public Role(String name) {
        this.name = name;
    }


    //Имплементируемый метод
    @Override
    public String getAuthority() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name; // Возвращает название роли (например, "ROLE_ADMIN")
    }
}
