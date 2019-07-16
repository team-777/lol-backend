package org.ajou.realcoding.lolbackend.lolbackend.config.repository;

import org.ajou.realcoding.lolbackend.lolbackend.config.domain.LeagueV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LolBackendRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertPerformance(LeagueV4[] leagueV4s) {
        for(LeagueV4 leagueV4 : leagueV4s)
            mongoTemplate.insert(leagueV4);
    }

    public List<LeagueV4> findPerformance(String summonerId) {
        Query query = Query.query(Criteria.where("summonerId").is(summonerId));
        return mongoTemplate.find(query, LeagueV4.class);
    }

}
