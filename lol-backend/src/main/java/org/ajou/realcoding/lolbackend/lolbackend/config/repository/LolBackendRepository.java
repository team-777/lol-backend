package org.ajou.realcoding.lolbackend.lolbackend.config.repository;

import org.ajou.realcoding.lolbackend.lolbackend.config.domain.LeagueV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class LolBackendRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertPerformance(LeagueV4 leagueV4){ mongoTemplate.insert(leagueV4);}

    public LeagueV4 findPerformance(String summonerId) {
        Query query = Query.query(Criteria.where("summonerId").is(summonerId));
        return mongoTemplate.findOne(query, LeagueV4.class);
    }

}
