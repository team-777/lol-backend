package org.ajou.realcoding.lolbackend.lolbackend.config.service;

import org.ajou.realcoding.lolbackend.lolbackend.config.api.LolBackendApi;
import org.ajou.realcoding.lolbackend.lolbackend.config.domain.LeagueV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.domain.SummonerV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.repository.LolBackendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LolBackendService {

    @Autowired
    LolBackendApi lolBackendApi;

    @Autowired
    LolBackendRepository lolBackendRepository;

    public SummonerV4 getSummonerIdByName(String summonerName){
        return lolBackendApi.requestSummonerId(summonerName);
    }

    public List<LeagueV4> getPerformanceById(String summonerId){
        if(lolBackendRepository.findPerformance(summonerId).isEmpty())
            lolBackendRepository.insertPerformance(lolBackendApi.requestPerformance(summonerId));
        else
            lolBackendRepository.updatePerformance(lolBackendApi.requestPerformance(summonerId));
        return lolBackendRepository.findPerformance(summonerId);
    }
}
