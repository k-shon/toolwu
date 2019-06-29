package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",query = "select p from Person p where p.name=?1 and address=?2")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;

    public Person(){
        super();
    }

    public Person(Long id,String name,Integer age,String address){
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;
}
