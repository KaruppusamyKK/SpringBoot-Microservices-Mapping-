package com.Micro.demo.ResponseHandler;

import com.Micro.demo.Entity.Employee;
import com.Micro.demo.Entity.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String errorMessage;
    private Team team;
    private Employee employee; //id and pass
    private List<Employee> employeeList;

    public Response(String errorMessage, Team team, Employee employee, List<Employee> employeeList) {
        this.errorMessage =errorMessage;
        this.team = team;
        this.employee = employee;
        this.employeeList = employeeList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

