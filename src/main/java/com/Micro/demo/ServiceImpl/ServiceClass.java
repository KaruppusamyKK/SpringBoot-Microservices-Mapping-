package com.Micro.demo.ServiceImpl;

import com.Micro.demo.Entity.Employee;
import com.Micro.demo.Entity.Team;
import com.Micro.demo.Repo.EmpRepo;
import com.Micro.demo.Repo.TeamRepo;
import com.Micro.demo.Service.ServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClass implements ServiceImple {
    @Autowired
    EmpRepo empRepo;
    @Autowired
    TeamRepo teamRepo;

    @Override
    public Employee InsertEmployeeService(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public Team InsertTeamService(Team team) {
        return teamRepo.save(team);

    }

    @Override
    public Employee GetByIdEmployeeService(Long id) {
        return empRepo.findById(id).get();
    }

    @Override
    public Employee UpdateEmployeeService(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> GetAllEmployeeService() {
        return empRepo.findAll();
    }
}
