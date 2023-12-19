package com.Micro.demo.Controller;

import com.Micro.demo.Entity.Employee;
import com.Micro.demo.Entity.Team;
import com.Micro.demo.ExceptionHandling.TeamNotExists;
import com.Micro.demo.Repo.EmpRepo;
import com.Micro.demo.Repo.TeamRepo;
import com.Micro.demo.ResponseHandler.Response;
import com.Micro.demo.ServiceImpl.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ControllerClass{
    @Autowired
    ServiceClass serviceClass;
    @Autowired
    TeamRepo teamRepo;

    @PostMapping("/PostEmployee")
    public ResponseEntity<Response> InsertEmployeeController(@RequestBody Employee employee) {
    return new ResponseEntity<>( new Response("Success",
            null,serviceClass.InsertEmployeeService(employee),
            null),HttpStatus.ACCEPTED);
    }




    @PostMapping("/postTeamWithEmployee")
    public Team InsertTeamController(@RequestBody Team team) {
    System.out.println("Team inserted are  :" + team);

    if (team.getEmployeeList() == null) {
        team.setEmployeeList(new ArrayList<>());
    }
    for (Employee employee : team.getEmployeeList()) {
        employee.setTeam(team);
    }
    return serviceClass.InsertTeamService(team);
    //   team---> employee
}

//    @PostMapping("/PostEmployeeWithSameTeam/{id}")
//    public Team InserTeamWithSameTeamController(@PathVariable Long id, @RequestBody Team team) {
//        for (Employee employee : team.getEmployeeList()) {
//            employee.setTeam(team);
//        }
//        return serviceClass.InserTeamWithSameTeamService(team, id);
//    }

    @PostMapping("/postTeamWithEmployee/{id}")
    public Team InserTeamWithSameTeamController(@PathVariable Long id, @RequestBody Team team) {
        for (Employee employee : team.getEmployeeList()) {
            employee.setTeam(team);
        }
        team.setId(id);
        return serviceClass.InserTeamWithSameTeamService(team, id);
    }

    @PostMapping("/postTeamWithEmployeeAddMoreEmployee/{name}")
    public Team InsertEmployeeForTheSameTeamController(@PathVariable String name,@RequestBody Employee employee) {
        if(teamRepo.findByTeamName(name).isEmpty())
            throw  new TeamNotExists("Team with name :"+name +"doesn't exists");
        else {
            Team team = teamRepo.findByTeamName(name).get();
            team.getEmployeeList().add(employee);
            employee.setTeam(team);
            return serviceClass.InsertEmployeeForTheSameTeam(name);
        }
    }






































    @GetMapping("/{id}")
    public Employee GetByIdEmployeeController(@PathVariable("id") Long id)
    {
        return serviceClass.GetByIdEmployeeService(id);
    }

    @PutMapping("/{id}")
    public Employee UpdateEmployeeController(@PathVariable Long id,@RequestBody Employee employee)
    {
        return serviceClass.UpdateEmployeeService(employee);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> GetAllEmployeeController()
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serviceClass.GetAllEmployeeService());
    }


}
