package com.Micro.demo.Repo;

import com.Micro.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee,Long> {

}
