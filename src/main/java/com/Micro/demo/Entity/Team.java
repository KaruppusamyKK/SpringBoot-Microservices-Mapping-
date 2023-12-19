// Team.java
package com.Micro.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String teamName;
    private String teamLead;


    @JsonManagedReference
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Team() {
        this.employeeList = new ArrayList<>();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

//    @Override
//    public String toString() {
//        return "Team{" +
//                "Id=" + Id +
//                ", teamName='" + teamName + '\'' +
//                ", teamLead='" + teamLead + '\'' +
//                ", employeeList=" + employeeList +
//                '}';
//    }
}
