package org.ajou.realcoding.lolbackend.lolbackend.config.service;

import org.ajou.realcoding.lolbackend.lolbackend.config.api.LolBackendApi;
import org.ajou.realcoding.lolbackend.lolbackend.config.domain.LeagueV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.domain.SummonerV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.repository.LolBackendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LolBackendService {

    @Autowired
    LolBackendApi lolBackendApi;

    @Autowired
    LolBackendRepository lolBackendRepository;

    public SummonerV4 getSummonerIdByName(String summonerName){
        return lolBackendApi.requestSummonerId(summonerName);
    }

    public LeagueV4 getPerformanceById(String summonerId){

        lolBackendRepository.insertPerformance(lolBackendApi.requestPerformance(summonerId));
        return lolBackendRepository.findPerformance(summonerId);
    }
}
