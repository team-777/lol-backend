package org.ajou.realcoding.lolbackend.lolbackend.config.controller;

import org.ajou.realcoding.lolbackend.lolbackend.config.domain.LeagueV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.domain.SummonerV4;
import org.ajou.realcoding.lolbackend.lolbackend.config.service.LolBackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LolBackendController {

    @Autowired
    LolBackendService lolBackendService;

    @GetMapping("/LOL-backend/Performance/BySummonerName/{summonerName}")
    public List<LeagueV4> getPerformance(@PathVariable String summonerName){
        SummonerV4 summonerV4 = lolBackendService.getSummonerIdByName(summonerName);
        return lolBackendService.getPerformanceById(summonerV4.getId());
    }
}
