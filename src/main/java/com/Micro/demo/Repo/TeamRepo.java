package com.Micro.demo.Repo;

import com.Micro.demo.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team,Long> {

    Optional<Team> findByTeamName(String teamName);
}
