package com.Micro.demo.Controller;

import com.Micro.demo.Entity.Employee;
import com.Micro.demo.Entity.Team;
import com.Micro.demo.Repo.EmpRepo;
import com.Micro.demo.Repo.TeamRepo;
import com.Micro.demo.ServiceImpl.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerClass {
    @Autowired
    ServiceClass serviceClass;
    @Autowired
    TeamRepo teamRepo;

    @PostMapping("/post")
    public Employee InsertEmployeeController(@RequestBody Employee employee) {
        return serviceClass.InsertEmployeeService(employee);
    }   // employee---> team

//    @PostMapping("/postTeam")
//        public Team InsertTeamController(@RequestBody Team team)
//    {
//        System.out.println("Team inserted are  :"+team);
//        return serviceClass.InsertTeamService(team);
//    }
//@PostMapping("/postTeam")
//public Team InsertTeamController(@RequestBody Team team) {
//    System.out.println("Team inserted are  :" + team);
//    for (Employee employee : team.getEmployeeList()) {
//        employee.setTeam(team);
//    }
//    return serviceClass.InsertTeamService(team);
//}


    @PostMapping("/postTeam")
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
