package net.woniper.data.rest;

import javax.persistence.*;

/**
 * Created by woowahan on 2017. 2. 16..
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToOne
    private Address address;

    public Account() {}

    public Account(String name) {
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }
}
