package org.ajou.realcoding.lolbackend.lolbackend.config.repository;

import org.ajou.realcoding.lolbackend.lolbackend.config.domain.LeagueV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    public void updatePerformance(LeagueV4[] leagueV4s){

        for(LeagueV4 leagueV4 : leagueV4s) {
            Query query = Query.query(Criteria.where("queueType").is(leagueV4.getQueueType()));
            Update update = new Update();

            update.set("queueType", leagueV4.getQueueType());
            update.set("summonerName", leagueV4.getSummonerName());
            update.set("hotStreak", leagueV4.getHotStreak());
            update.set("wins", leagueV4.getWins());
            update.set("veteran", leagueV4.getVeteran());
            update.set("losses", leagueV4.getLosses());
            update.set("rank", leagueV4.getRank());
            update.set("tier", leagueV4.getTier());
            update.set("inactive", leagueV4.getInactive());
            update.set("freshBlood", leagueV4.getFreshBlood());
            update.set("leagueId", leagueV4.getLeagueId());
            update.set("summonerId", leagueV4.getSummonerId());
            update.set("leaguePoints", leagueV4.getLeaguePoints());

            mongoTemplate.updateMulti(query, update, LeagueV4.class);
        }
    }
}
