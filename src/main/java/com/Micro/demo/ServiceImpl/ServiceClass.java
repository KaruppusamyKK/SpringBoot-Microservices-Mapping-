package com.Micro.demo.ServiceImpl;

import com.Micro.demo.Entity.Employee;
import com.Micro.demo.Entity.Team;
import com.Micro.demo.ExceptionHandling.EmployeeNotFoundException;
import com.Micro.demo.ExceptionHandling.TeamNameAlreadyExistsException;
import com.Micro.demo.ExceptionHandling.TeamNotExists;
import com.Micro.demo.Repo.EmpRepo;
import com.Micro.demo.Repo.TeamRepo;
import com.Micro.demo.Service.ServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//    @Override
//    public Team InserTeamWithSameTeamService(Team team,Long id) {
//        Team getTeamId=teamRepo.findById(id).orElse(null);
//        return teamRepo.save(team);
//    }


    @Override
    public Employee GetByIdEmployeeService(Long id) {
        if (empRepo.findById(id).isEmpty())
            throw new EmployeeNotFoundException("not exeists");
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


    @Override
    public Team InserTeamWithSameTeamService(Team team, Long id) {
        String TargetName = team.getTeamName();
        Optional<Team> teamsWithSameName = teamRepo.findByTeamName(TargetName);
        if (teamsWithSameName.isEmpty()) {
            return teamRepo.save(team);
        } else {
            throw new TeamNameAlreadyExistsException("Team with name " + TargetName + " already exists.");
        }
    }


    //    @Override
//    public Team InsertEmployeeForTheSameTeam(Team team) {
//        String TargetName=team.getTeamName();
//        if (teamRepo.findByTeamName(TargetName)!=null)  // if exists
//        {
//            for (Employee employee : team.getEmployeeList()) {
//                employee.setTeam(team);
//        }
//            return teamRepo.save(team);
//    }
//        else {
//            throw  new TeamNotExists("Team with name :"+TargetName +"doesn't exists");
//        }
//}
@Override
public Team InsertEmployeeForTheSameTeam(String name) {
        Team team=teamRepo.findByTeamName(name).get();
    if (team!=null)  // if exists
    {
        return teamRepo.save(team);
    }
    else {
        throw  new TeamNotExists("Team with name :"+name +"doesn't exists");
    }
}
}
