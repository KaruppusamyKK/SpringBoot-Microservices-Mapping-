package com.Micro.demo.Repo;

import com.Micro.demo.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team,Long> {
}
