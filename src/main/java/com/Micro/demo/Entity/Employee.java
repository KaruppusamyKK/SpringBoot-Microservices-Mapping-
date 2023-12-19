// Employee.java
package com.Micro.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emplID;
    private String emplName;
    private int emplAge;

//-------------------------- team mapping-------------------------------//
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk",referencedColumnName = "Id")
    Team team;
//------------------------------------------------------------------------//

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @Joi



    public Employee() {
    }
    public Long getEmplID() {
        return emplID;
    }
    public void setEmplID(Long emplID) {
        this.emplID = emplID;
    }
    public String getEmplName() {
        return emplName;
    }
    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }
    public int getEmplAge() {
        return emplAge;
    }
    public void setEmplAge(int emplAge) {
        this.emplAge = emplAge;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

}
