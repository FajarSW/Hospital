package com.hmsapp.hospitalmanagement.doclogin.enity;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String age;
    private String symtomps;
    private String number;

    public Appointment(){
    }

    public Appointment(long id, String name, String age, String symtomps, String number) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.symtomps = symtomps;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSymtomps() {
        return symtomps;
    }

    public void setSymtomps(String symtomps) {
        this.symtomps = symtomps;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
