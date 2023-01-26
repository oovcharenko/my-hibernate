package ru.home.entity;


import jakarta.persistence.*;

@Entity
@Table(schema = "my", name = "user")
public class User {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String name;
    @Column
    @Enumerated(EnumType.STRING)
    public Type type;

    @Embedded
    public UserAddress address;

    public User(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
