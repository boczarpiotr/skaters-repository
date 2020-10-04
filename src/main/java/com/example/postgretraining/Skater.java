package com.example.postgretraining;


import javax.persistence.*;

@Entity
@Table(name = "skater")
public class Skater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public Skater() {
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

    @Override
    public String toString() {
        return "Skater{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
