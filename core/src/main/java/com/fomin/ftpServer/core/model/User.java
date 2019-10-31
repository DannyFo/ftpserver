package com.fomin.ftpServer.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@EqualsAndHashCode(of = {"email"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserRole> roleSet = new HashSet<>();

    public void addRole(UserRole role){
        roleSet.add(role);
        role.getUserSet().add(this);
    }

    public void removeRole(UserRole role){
        roleSet.remove(role);
        role.getUserSet().remove(this);
    }
}
