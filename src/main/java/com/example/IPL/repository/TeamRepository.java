package com.example.IPL.repository;

import com.example.IPL.model.data.Match;
import com.example.IPL.model.data.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByName(String name);

}
