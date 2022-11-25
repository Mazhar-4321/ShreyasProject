package com.example.IPL.model.data;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;


    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate,EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");
          Map<String,Team> map = new HashMap<>();
          entityManager.createQuery("select m.team1,count(*) from Match m group by m.team1",Object[].class)
                    .getResultList().stream().map(e->new Team((String)e[0],e[1]+"")).forEach(team->map.put(team.getName(),team));

            entityManager.createQuery("select m.team2,count(*) from Match m group by m.team2",Object[].class)
                    .getResultList().stream().forEach(e->
                    {
                          Team name= map.get((String)e[0]) ;
                         // Integer losses=((Long)e[1]);
                        Long losses=(Long)e[1];
                        Long totalMatches=(Long.parseLong(name.getMatchesWon()))+losses;
                        name.setNoOfMatches(totalMatches+"");
                          name.setMatchesLost(losses+"");
                          map.put(name.getName(),name);
                    }
            );
            System.out.println(map);
                map.values().forEach(team->
                {entityManager.persist(team);
                    System.out.println(team);});
            //System.out.println(list);

          //  entityManager.cr
        }
    }
}